package com.mogateway.util;

import net.sf.json.JSONObject;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.DefaultHttpAsyncClient;
import org.apache.http.nio.client.HttpAsyncClient;
import org.apache.http.nio.reactor.IOReactorException;
import org.apache.log4j.Logger;
import org.apache.poi.util.IOUtils;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

public class RequestUtil {

	private static Logger logger = Logger.getLogger(RequestUtil.class);

    private static final int SUBSTATION_TIMEOUT = 1000 * 5; 	//设置默认连接超时为5s
    private static final int SOCKET_TIMEOUT = 1000 * 30;        //设置默认读取超时为30s

    private static class TrustAnyTrustManager implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[] {};
        }
    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

	public static JSONObject requestHttpUrl(String url, Object request) throws Exception {
//		logger.info("请求服务器开始:" + url + ";时间:" + Tools.date2Str(new Date()));
		// 创建连接
		URL realUrl = new URL(URLDecoder.decode(url, "UTF-8"));
		HttpURLConnection httpURLConnection = (HttpURLConnection)realUrl.openConnection();
		realUrl = null;
		// 设置请求方式
		httpURLConnection.setRequestMethod("POST");
		// 设置接收数据的格式
		httpURLConnection.setRequestProperty("Accept", "application/json");
		// 设置发送数据个格式
		httpURLConnection.setRequestProperty("Content-Type", "application/json");
		httpURLConnection.setRequestProperty("Connection", "close");
		httpURLConnection.setRequestProperty("Charset", "UTF-8");
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setConnectTimeout(SUBSTATION_TIMEOUT);
        httpURLConnection.setReadTimeout(SOCKET_TIMEOUT);
        String jsonResult = "";
        if (request != null) {
        	// 请求的输出流
            OutputStreamWriter out = new OutputStreamWriter(httpURLConnection.getOutputStream(), "utf-8");
            jsonResult = JSONObject.fromObject(request).toString();
           // String string=jsonResult.toString().replaceAll("\\\\", "").trim();
//            logger.info("连接服务器并发送请求数据：" + jsonResult);
            out.write(jsonResult);
            out.flush();
            out.close();
            out = null;
        }
        JSONObject json = null;
        // 获得响应状态
        int responseCode = httpURLConnection.getResponseCode();
        if (HttpURLConnection.HTTP_OK == responseCode) {
//        	logger.info("连接服务器成功");
        	StringBuilder strBuilder = new StringBuilder();
        	String readLine = null;
        	InputStreamReader in = new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8");
            BufferedReader br = new BufferedReader(in);
            while((readLine = br.readLine()) != null){
            	strBuilder.append(readLine);
            }
            br.close();
            in.close();
            readLine = null;
            br = null;
            in = null;
            if (strBuilder != null) {
            	json = JSONObject.fromObject(strBuilder.toString());
//            	logger.info("服务器返回结果：" + json.toString());
            }
            strBuilder = null;
            httpURLConnection = null;
		} else if (HttpURLConnection.HTTP_CLIENT_TIMEOUT == responseCode) {
			logger.error("请求服务器超时");
		} else {
			logger.error("请求服务器失败,响应状态码：" + responseCode);
		}
//        logger.info("请求服务器结束");
        return json;
	}


	public static String requestXMLHttpUrl(String url, String requestXML) throws Exception {
		logger.info("请求服务器开始:" + url);
		// 创建连接
		URL realUrl = new URL(URLDecoder.decode(url, "UTF-8"));
		HttpURLConnection httpURLConnection = (HttpURLConnection)realUrl.openConnection();
		realUrl = null;
		// 设置请求方式
		httpURLConnection.setRequestMethod("POST");
		// 设置接收数据的格式
		httpURLConnection.setRequestProperty("Accept", "application/xml");
		// 设置发送数据个格式
		httpURLConnection.setRequestProperty("Content-Type", "application/xml");
		httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
		httpURLConnection.setRequestProperty("Charset", "UTF-8");
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(2000);
        if (requestXML != null) {
        	// 请求的输出流
            OutputStreamWriter out = new OutputStreamWriter(httpURLConnection.getOutputStream(), "utf-8");
            logger.info("连接服务器并发送请求XML数据：" + requestXML);
            out.write(requestXML);
            out.flush();
            out.close();
            out = null;
        }
        String responseXML = null;
        // 获得响应状态
        int responseCode = httpURLConnection.getResponseCode();
        if (HttpURLConnection.HTTP_OK == responseCode) {
        	logger.info("连接服务器成功");
        	StringBuilder strBuilder = new StringBuilder();
        	String readLine = null;
        	InputStreamReader in = new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8");
            BufferedReader br = new BufferedReader(in);
            while((readLine = br.readLine()) != null){
            	strBuilder.append(readLine);
            }
            br.close();
            in.close();
            readLine = null;
            br = null;
            in = null;
            if (strBuilder != null) {
            	responseXML = strBuilder.toString();
            }
            strBuilder = null;
            httpURLConnection = null;
		} else if (HttpURLConnection.HTTP_CLIENT_TIMEOUT == responseCode) {
			logger.info("请求服务器超时");
		} else {
			logger.info("请求服务器失败,响应状态码：" + responseCode);
		}
        logger.info("请求服务器结束");
        return responseXML;
	}
	
	/**
	 * https post请求
	 * @param httpsUrl
	 * @return 
	 */
    public static JSONObject requestHttps(String httpsUrl, Map<String, Object> requestMap) {
         try {
         // 获取一个SSLContext实例
         SSLContext sc = SSLContext.getInstance("SSL");
         // 初始化SSLContext实例
         sc.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());
         URL realUrl = new URL(httpsUrl);
         // 打开和URL之间的连接
         HttpsURLConnection connection = (HttpsURLConnection) realUrl.openConnection();
         //设置https相关属性
         connection.setSSLSocketFactory(sc.getSocketFactory());
         connection.setHostnameVerifier(new TrustAnyHostnameVerifier());
         // 设置接收数据的格式
         connection.setRequestProperty("Accept", "application/json");
         // 设置发送数据个格式
         connection.setRequestProperty("Content-Type", "application/json");
         connection.setRequestProperty("Connection", "Keep-Alive");
         connection.setRequestProperty("Charset", "UTF-8");
         connection.setDoOutput(true);
         connection.setDoInput(true);
         connection.setUseCaches(false);
         // 设置通用的请求属性
         connection.setRequestMethod("POST");
         connection.setConnectTimeout(SUBSTATION_TIMEOUT);
         connection.setReadTimeout(SUBSTATION_TIMEOUT);
         String jsonResult = "";
         if (requestMap != null) {
         // 请求的输出流
         OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "utf-8");
         jsonResult = JSONObject.fromObject(requestMap).toString().trim();
         out.write(jsonResult);
         out.flush();
         out.close();
         }
         JSONObject json = null;
         // 获得响应状态
         int responseCode = connection.getResponseCode();
         if (HttpsURLConnection.HTTP_OK == responseCode) {
         logger.info("连接服务器成功");
         StringBuilder strBuilder = new StringBuilder();
         String readLine = null;
         InputStreamReader in = new InputStreamReader(connection.getInputStream(), "UTF-8");
         BufferedReader br = new BufferedReader(in);
         while((readLine = br.readLine()) != null){
         strBuilder.append(readLine);
         }
         br.close();
         in.close();
         if (strBuilder != null) {
         json = JSONObject.fromObject(strBuilder.toString());
         logger.info("POST请求返回的数据"+json);
         }
         } else if (HttpsURLConnection.HTTP_CLIENT_TIMEOUT == responseCode) {
         logger.error("请求服务器超时");
         } else {
         logger.error("请求服务器失败,响应状态码：" + responseCode);
         }
         return json;

         } catch (Exception e) {
         e.printStackTrace();
         return null;
         }
     }


    public static Object uploadHttpUrl(String url, String filePath, String startDTTM) throws IOException {

        Object result = null;
        File file = new File(filePath);
        if (!file.exists()) {
            logger.error("文件发送失败，发送文件不存在：" + filePath);
            return "NotFound";
        }
        file = null;
        logger.info("发送文件-请求服务器开始:" + url);
        InputStream pictureInput = new FileInputStream(filePath);

        // 将流转为byte数组,用IOUtils.toByteArray 很方便
        byte[] data = IOUtils.toByteArray(pictureInput);
        // 创建连接
        URL realUrl = new URL(URLDecoder.decode(url, "UTF-8"));
        HttpURLConnection httpURLConnection = (HttpURLConnection)realUrl.openConnection();
        realUrl = null;
        // 设置请求方式
        httpURLConnection.setRequestMethod("POST");
        // 设置接收数据的格式
        httpURLConnection.setRequestProperty("Accept", "application/json");
        // 设置发送数据个格式
        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        httpURLConnection.setRequestProperty("User-Agent", "kjtc");
        httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream;charset=UTF-8");
        httpURLConnection.setRequestProperty("Content-Disposition",  "attachment; filename=\"" + filePath.substring(filePath.lastIndexOf("/") + 1) + "\"");
        httpURLConnection.setRequestProperty("FileName", "" + filePath.substring(filePath.lastIndexOf("/") + 1));
        httpURLConnection.setRequestProperty("FileDateTime", startDTTM);
        httpURLConnection.setRequestProperty("Content-Length", "" + data.length);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setConnectTimeout(SUBSTATION_TIMEOUT);
        httpURLConnection.setReadTimeout(SUBSTATION_TIMEOUT);
//        logger.info("发送的文件：" + filePath);
        OutputStream out = new BufferedOutputStream(httpURLConnection.getOutputStream());
        out.write(data);
        out.flush();
        out.close();
        out = null;

        // 获得响应状态
        int responseCode = httpURLConnection.getResponseCode();
        if (HttpURLConnection.HTTP_OK == responseCode) {
//        	logger.info("连接服务器成功");
            StringBuilder strBuilder = new StringBuilder();
            String readLine = null;
            InputStreamReader in = new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8");
            BufferedReader br = new BufferedReader(in);
            while((readLine = br.readLine()) != null){
                strBuilder.append(readLine);
            }
            br.close();
            in.close();
            readLine = null;
            br = null;
            in = null;

            JSONObject json = null;
            if (strBuilder != null) {
                json = JSONObject.fromObject(strBuilder.toString());
//            	logger.info("服务器返回结果：" + json.toString());
            }
            strBuilder = null;
            httpURLConnection = null;
            result = json;
        } else if (HttpURLConnection.HTTP_CLIENT_TIMEOUT == responseCode) {
            logger.error("请求服务器超时");
            result = "Timeout";
        } else {
            logger.error("请求服务器失败,响应状态码：" + responseCode);
            result = "error";
        }
        logger.info("发送文件-请求服务器结束");

        return result;
    }

    public static Object uploadHttpsUrl(String url, String filePath, String startDTTM) throws Exception {

        Object result = null;
        File file = new File(filePath);
        if (!file.exists()) {
            logger.error("文件发送失败，发送文件不存在：" + filePath);
            return "NotFound";
        }
        file = null;
        logger.info("发送文件-请求服务器开始:" + url);
        InputStream pictureInput = new FileInputStream(filePath);

        // 将流转为byte数组,用IOUtils.toByteArray 很方便
        byte[] data = IOUtils.toByteArray(pictureInput);
        // 获取一个SSLContext实例
        SSLContext sc = SSLContext.getInstance("SSL");
        // 初始化SSLContext实例
        sc.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());
        // 创建连接
        URL realUrl = new URL(URLDecoder.decode(url, "UTF-8"));
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection)realUrl.openConnection();
        //设置https相关属性
        httpsURLConnection.setSSLSocketFactory(sc.getSocketFactory());
        httpsURLConnection.setHostnameVerifier(new TrustAnyHostnameVerifier());
        // 设置请求方式
        httpsURLConnection.setRequestMethod("POST");
        // 设置接收数据的格式
        httpsURLConnection.setRequestProperty("Accept", "application/json");
        // 设置发送数据个格式
        httpsURLConnection.setRequestProperty("Connection", "Keep-Alive");
        httpsURLConnection.setRequestProperty("Charset", "UTF-8");
        httpsURLConnection.setRequestProperty("User-Agent", "kjtc");
        httpsURLConnection.setRequestProperty("Content-Type", "application/octet-stream;charset=UTF-8");
        httpsURLConnection.setRequestProperty("Content-Disposition",  "attachment; filename=\"" + filePath.substring(filePath.lastIndexOf("/") + 1) + "\"");
        httpsURLConnection.setRequestProperty("FileName", "" + filePath.substring(filePath.lastIndexOf("/") + 1));
        httpsURLConnection.setRequestProperty("FileDateTime", startDTTM);
        httpsURLConnection.setRequestProperty("Content-Length", "" + data.length);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setConnectTimeout(SUBSTATION_TIMEOUT);
        httpsURLConnection.setReadTimeout(SUBSTATION_TIMEOUT);
        logger.info("发送的文件：" + filePath);
        OutputStream out = new BufferedOutputStream(httpsURLConnection.getOutputStream());
        out.write(data);
        out.flush();
        out.close();
        out = null;

        // 获得响应状态
        int responseCode = httpsURLConnection.getResponseCode();
        if (HttpsURLConnection.HTTP_OK == responseCode) {
//        	logger.info("连接服务器成功");
            StringBuilder strBuilder = new StringBuilder();
            String readLine = null;
            InputStreamReader in = new InputStreamReader(httpsURLConnection.getInputStream(), "UTF-8");
            BufferedReader br = new BufferedReader(in);
            while((readLine = br.readLine()) != null){
                strBuilder.append(readLine);
            }
            br.close();
            in.close();
            readLine = null;
            br = null;
            in = null;

            JSONObject json = null;
            if (strBuilder != null) {
                json = JSONObject.fromObject(strBuilder.toString());
//            	logger.info("服务器返回结果：" + json.toString());
            }
            result = json;
        } else if (HttpsURLConnection.HTTP_CLIENT_TIMEOUT == responseCode) {
            logger.error("请求服务器超时");
            result = "Timeout";
        } else {
            logger.error("请求服务器失败,响应状态码：" + responseCode);
            result = "error";
        }
//        logger.info("发送文件-请求服务器结束");

        return result;
    }
}

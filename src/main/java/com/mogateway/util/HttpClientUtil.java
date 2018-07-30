package com.mogateway.util;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.*;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.CodingErrorAction;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 */
public class HttpClientUtil {

	private static final String DEFAULT_CHARSET = "UTF-8";          //设置默认通信报文编码为UTF-8
	private final static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
	private static ObjectMapper om = new ObjectMapper();
	private static PoolingHttpClientConnectionManager connManager = null;
	private static CloseableHttpClient httpclient = null;
	private static final int CONNECTION_TIMEOUT = 1000 * 5; 	//设置默认连接超时为5s
	private static final int SOCKET_TIMEOUT = 1000 * 30;        //设置默认读取超时为30s
	static {
		try {
			RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory> create();
			ConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();
			registryBuilder.register("http", plainSF);
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			TrustStrategy anyTrustStrategy = new TrustStrategy() {
				@Override
				public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
					return true;
				}
			};
			SSLContext sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(trustStore, anyTrustStrategy)
					.build();

			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
					.register("http", PlainConnectionSocketFactory.INSTANCE)
					.register("https", new SSLConnectionSocketFactory(sslContext)).build();

			connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
			// Create socket configuration
			SocketConfig socketConfig = SocketConfig.custom().setRcvBufSize(2048).setSndBufSize(2048)
					.setSoKeepAlive(true).setTcpNoDelay(true).setSoTimeout(2*60*1000).build();
			connManager.setDefaultSocketConfig(socketConfig);
			// Create message constraints
			MessageConstraints messageConstraints = MessageConstraints.custom().setMaxHeaderCount(200)
					.setMaxLineLength(2000).build();
			// Create connection configuration
			ConnectionConfig connectionConfig = ConnectionConfig.custom()
					.setMalformedInputAction(CodingErrorAction.IGNORE)
					.setUnmappableInputAction(CodingErrorAction.IGNORE).setCharset(Consts.UTF_8)
					.setMessageConstraints(messageConstraints).build();
			connManager.setDefaultConnectionConfig(connectionConfig);
			connManager.setMaxTotal(60000);
			connManager.setDefaultMaxPerRoute(120);
			httpclient = HttpClients.custom().setConnectionManager(connManager).build();
			
		} catch (KeyManagementException e) {
			logger.error("KeyManagementException", e);
		} catch (NoSuchAlgorithmException e) {
			logger.error("NoSuchAlgorithmException", e);
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * get 方式提交
	 */
	public static String httpGet(String url, Map<String, String> params, Map<String, String> heads){
		if(heads!=null&&"info".equals(heads.get("level"))){
			logger.info("请求{}发送的数据:{},发送的头信息{}",url, JSON.toJSONString(params), JSON.toJSONString(heads));
		}else {
			logger.debug("请求{}发送的数据:{},发送的头信息{}", url, JSON.toJSONString(params), JSON.toJSONString(heads));
		}
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String result = "";
		try {
			String queryString = "";
			if(null != params){
				for(Entry<String,String> entry : params.entrySet()){
					if(entry.getValue()!=null) {
						queryString += "&" + entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), DEFAULT_CHARSET);
					}
				}
			}
			HttpGet httpGet = new HttpGet(url + (StringUtils.isNotBlank(queryString)?"?"+queryString.substring(1):""));
			if(null != heads){
				for(Entry<String,String> entry : heads.entrySet()){
					httpGet.addHeader(entry.getKey(), entry.getValue());
				}
			}
			// 执行get请求.
			CloseableHttpResponse response = httpclient.execute(httpGet);
			// 获取响应实体
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity,DEFAULT_CHARSET);
				if(heads!=null&&"info".equals(heads.get("level"))) {
					logger.info("请求{}接收的数据:{}",url,result);
				}else{
					logger.debug("请求{}接收的数据:{}",url,result);
				}
			}
		}catch(Exception ex){
			throw new RuntimeException("请求通信[" + url + "]时遇到异常", ex);
		}finally{
			try {
				httpclient.close();
			} catch (IOException ex) {
				throw new RuntimeException("关闭通信[" + url + "]时遇到异常", ex);
			}
		}
		return result;
	}

	/**
	 * post方式提交表单
	 */
	public static String httpPost(String url, Map<String,String> paramsMap, String level) {
		if("info".equals(level)){
			logger.info("请求{}发送的数据:{}",url, JSON.toJSONString(paramsMap));
		}else {
			logger.debug("请求{}发送的数据:{}", url, JSON.toJSONString(paramsMap));
		}
		String result = "";
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//CloseableHttpAsyncClient httpclient  = HttpClientFactory.getInstance().getHttpAsyncClientPool().getAsyncHttpClient();
		//CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();

		// 创建httppost
		HttpPost httpPost = new HttpPost(url);
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(CONNECTION_TIMEOUT)
				.setSocketTimeout(SOCKET_TIMEOUT).build();
		httpPost.setConfig(requestConfig);
		// 创建参数队列
		List<BasicNameValuePair> formparams = new ArrayList<>();
		/**
		 * 		for (Entry<String, String> entry : paramsMap.entrySet()) {
		 if(entry.getValue()!=null) {
		 String key = entry.getKey();
		 formparams.add(new BasicNameValuePair(key, entry.getValue().toString()));
		 }
		 }
		 */

		try {
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, DEFAULT_CHARSET);
			httpPost.setEntity(uefEntity);
			CloseableHttpResponse response = httpclient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity,DEFAULT_CHARSET);
				if("info".equals(level)){
					logger.info("请求{}接收的数据:{}", url, result);
				}else{
					logger.debug("请求{}接收的数据:{}", url, result);
				}
			}
		}catch(Exception ex){
			throw new RuntimeException("请求通信[" + url + "]时遇到异常", ex);
		}finally{
			try {
				httpclient.close();
			} catch (IOException ex) {
				throw new RuntimeException("关闭通信[" + url + "]时遇到异常", ex);
			}
		}
		return result;
	}

	/**
	 * setConnectTimeout：设置连接超时时间，单位毫秒。
	 * setConnectionRequestTimeout：设置从connect Manager获取Connection 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
	 * setSocketTimeout：请求获取数据的超时时间，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
	 */
	public static String postJSON(String url, String params, Map<String, String> heads){
		logger.debug("请求{},发送的参数：{},发送的头信息：{}",url,params,heads);
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        String result = null;
        try{
        	RequestConfig requestConfig = RequestConfig.custom()
        	        .setConnectTimeout(CONNECTION_TIMEOUT)
        	        .setSocketTimeout(SOCKET_TIMEOUT).build();
        	HttpPost httpPost = new HttpPost(url);
        	httpPost.setConfig(requestConfig);
			httpPost.setHeader(HTTP.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			httpPost.setEntity(new StringEntity(null==params?"":params, DEFAULT_CHARSET));
			if(null != heads){
				for(Entry<String,String> entry : heads.entrySet()){
					httpPost.addHeader(entry.getKey(), entry.getValue());
				}
			}
			HttpResponse response = closeableHttpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, ContentType.getOrDefault(entity).getCharset());
			logger.debug("请求{},获取的结果：{}",url,result);
        }catch(Exception ex){
        	throw new RuntimeException("请求通信[" + url + "]时遇到异常", ex);
        }finally{
        	try {
        		closeableHttpClient.close();
			} catch (IOException ex) {
				throw new RuntimeException("关闭通信[" + url + "]时遇到异常", ex);
			}
        }
        return result;
    }

}

package com.mogateway.util;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018-03-28.
 */
public class CommonUtils {

    public static Date parseDate(String dateStr, String format) {
        Date date=null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            date = dateFormat.parse(dateStr);
        } catch (Exception e) {

        }
        return date;
    }

    public static int checkUrlConnection(String url) {
        int status = 404;
        try {
            URL urlObj = new URL(url);
            HttpURLConnection oc = (HttpURLConnection) urlObj.openConnection();
            oc.setUseCaches(false);
            oc.setConnectTimeout(30 * 1000); // 设置超时时间
            status = oc.getResponseCode();// 请求状态
        } catch (Exception e) {
            e.printStackTrace();
            status = -1;
        }
        return status;
    }

    public static String exception2Str(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw, true));
        String strs = sw.toString();
        return strs;
    }

    public static String date2Str(Date date,String format){
        if(date!=null){
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }else{
            return "";
        }
    }

    public static String byte2HexStr(byte[] b) {
        String stmp = "";
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            sb.append((stmp.length() == 1) ? "0" + stmp : stmp);
        }
        return sb.toString().toUpperCase().trim();
    }

    public static String getKey(String prex, String id) {
        return prex + ":" + id;
    }

    public static String convertMsg(RedisTemplate<Serializable, Object> redisTemplate, Message message) {
        try {
            byte[] body = message.getBody();
            return redisTemplate.getValueSerializer().deserialize(body).toString();
        } catch (Exception e) {
            return null;
        }
    }
}

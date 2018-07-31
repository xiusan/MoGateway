package com.mogateway;

/**
 * Created by xiaojinlu on     2018/7/17.
 */
public class Test {
    public static void main(String[] args) {
        String   na= "ss_oo";
        String str = null;
        if(na.contains("_") == true){
            StringBuffer  sb = new StringBuffer();
            String[]  spStr = na.split("_");
            sb.append(spStr[0]);
            for (int i = 1; i < spStr.length; i++) {
                sb.append(spStr[i].substring(0,1).toUpperCase()+spStr[i].substring(1,spStr[i].length()).toLowerCase());
            }
            str = sb.toString();
        }else {
            str = na.toLowerCase();
        }
    }


    public String getStr(String na) {
        String str = null;
        if(na.contains("_") == true){
            StringBuffer  sb = new StringBuffer();
            String[]  spStr = na.split("_");
            sb.append(spStr[0]);
            for (int i = 1; i < spStr.length; i++) {
                sb.append(spStr[i].substring(0,1).toUpperCase()+spStr[i].substring(1,spStr[i].length()).toLowerCase());
            }
            str = sb.toString();
        }else {
            str = na.toLowerCase();
        }
        return str;
    }
}

package com.mogateway.util;

import java.io.*;

/**
 * 创建用户:杨辽
 * 创建时间: 2018-04-04 13:33
 * 描   述:
 **/
public class CinTxt {


    /**
     * 读入TXT文件
     *
     * @param filePath
     * @return
     */
    public static String getTxtData(String filePath) {
        StringBuilder line = new StringBuilder();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(filePath)))) {
            line.append(new StringBuilder(new BufferedReader(reader).readLine()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line.toString();
    }

    /**
     * 写入文件
     *
     * @param filePath
     * @param data
     */
    public static void setTxtData(String filePath, String data) {
        try (FileWriter fw = new FileWriter(new File(filePath), true); PrintWriter pw = new PrintWriter(fw)){
            //\r\n即为换行
            pw.println(data);
            pw.flush();
            fw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String s = getTxtData("/data/redis.txt");
        System.out.println(s);
        try {
            new File("/data/aaaaaaa.txt").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setTxtData("/data/aaaaaaa.txt", s + "\n" + s);
        setTxtData("/data/aaaaaaa.txt", s + "\n" + s);
        setTxtData("/data/aaaaaaa.txt", s + "\n" + s);
        setTxtData("/data/aaaaaaa.txt", s + "\n" + s);
        setTxtData("/data/aaaaaaa.txt", s + "\n" + s);
    }

}

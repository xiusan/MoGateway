package com.mogateway.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2018-04-09.
 */
public class CmdInfoStream implements Runnable {

    private Process process;

    public CmdInfoStream(Process process) {
        this.process = process;
    }

    @Override
    public void run() {
        BufferedReader brInfo = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        try {
            while ((line = brInfo.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("执行完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

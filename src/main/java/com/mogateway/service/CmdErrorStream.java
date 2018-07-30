package com.mogateway.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2018-04-09.
 */
public class CmdErrorStream implements Runnable {

    private Process process;

    public CmdErrorStream(Process process) {
        this.process = process;
    }

    @Override
    public void run() {
        BufferedReader brError = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        StringBuilder sb = new StringBuilder();
        try {
            while ((line = brError.readLine()) != null) {
                sb.append(line + "\n");
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

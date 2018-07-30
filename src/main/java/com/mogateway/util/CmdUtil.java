package com.mogateway.util;

import com.mogateway.service.CmdErrorStream;
import com.mogateway.service.CmdInfoStream;
import com.sun.jna.Platform;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018-04-25.
 */
public class CmdUtil {

    public static Process startJar(String jarPath) throws Exception {
        String cmd = "";
        if (Platform.isLinux()) {
            cmd = "nohup java -jar " + jarPath + " &";
        } else if (Platform.isWindows()){
            cmd = "cmd.exe /c start /b java -jar " + jarPath;
        } else {
            return null;
        }
        return execCmd(cmd);
    }

    public static Process execCmd(String cmd) throws Exception {
        Process process = Runtime.getRuntime().exec(cmd);
        ExecutorService service = Executors.newCachedThreadPool();
        CmdInfoStream cmdInfoStream = new CmdInfoStream(process);
        CmdErrorStream cmdErrorStream = new CmdErrorStream(process);
        service.execute(cmdInfoStream);
        service.execute(cmdErrorStream);
        return process;
    }

    public static void killProcess(int pid) throws Exception {
        String cmd = "";
        if (pid == -1) {
            return;
        }
        if (Platform.isLinux()) {
            cmd = "kill -9 " + String.valueOf(pid);
        } else if (Platform.isWindows()){
            cmd = "taskkill /F /PID " + String.valueOf(pid);
        }
        execCmd(cmd);
    }
}

package com.mogateway.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 创建用户:杨辽
 * 创建时间: 2018-04-04 14:51
 * 描   述:
 **/
public class FileUtils {

    /**
     * 创建文件
     *
     * @param path
     * @param filename
     * @throws IOException
     */
    public static void createFile(String path, String filename) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(path + "/" + filename);
        if (!file.exists()) {
            file.createNewFile();
        }
    }


    private static final DecimalFormat df = new DecimalFormat("#");

    /**
     * 获取文件大小
     *
     * @param file
     * @return
     */
    public static Integer getFileSize(File file) {
        long fileS = file.length();
        if (fileS <= 1048576) {
            return 0;
        }
        return Integer.valueOf(df.format((double) fileS / 1048576));
    }

    /**
     * 读取文件创建时间
     */
    public static Date getCreateTime(String fullFileName) {
        Path path = Paths.get(fullFileName);
        BasicFileAttributeView basicview = Files.getFileAttributeView(path, BasicFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
        BasicFileAttributes attr;
        try {
            attr = basicview.readAttributes();
            return new Date(attr.creationTime().toMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.set(1970, 0, 1, 0, 0, 0);
        return cal.getTime();
    }

    /**
     * 读取修改时间的方法
     */
    public static Date getModifiedTime(String fullFileName) {
        File f = new File(fullFileName);
        long time = f.lastModified();
        return new Date(time);
    }

}

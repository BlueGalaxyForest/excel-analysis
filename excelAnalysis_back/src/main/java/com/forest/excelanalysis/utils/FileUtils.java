package com.forest.excelanalysis.utils;
import org.springframework.util.StringUtils;

public class FileUtils {

    /**
     * 获得文件名的后缀
     * @param filename 文件名称
     * @return
     */
    public static String getFileExtension(String filename) {
        if (StringUtils.isEmpty(filename)) {
            return null;
        }

        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex == -1) {
            return null; // 没有找到文件后缀
        }

        return filename.substring(dotIndex + 1);
    }

}

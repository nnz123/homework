package com.ccbtrust.remoteclient.util;

/**
 * 获取文件存储的基本路径
 * @author nzhang
 */
public class PathUtil {
    /**
     * 获取电脑目录的分隔符
     */
    private static String seperator = System.getProperty("file.separator");
    /**
     *  获取图片存储的基本路径，根据操作系统的不同而不同
     */
    public static String getImgBasePath() {
        String basePath;
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            basePath = "D:/ideaWorkspace/image/";
        } else {
            basePath = "/home/nn/image";
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }
}

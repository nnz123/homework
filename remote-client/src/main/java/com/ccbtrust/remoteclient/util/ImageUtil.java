package com.ccbtrust.remoteclient.util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 图像处理工具
 * @author nzhang
 */
public class ImageUtil {
    /**
     *   获取图像的完整存储路径
     * @param  imageName 图像名称
     */
    public static String generateImageAddr(String imageName) {
        //获取随机文件名
        String realFileName= getRandomFileName();
        //获取上传的文件的扩展名
        String extension = getFileExtension(imageName);
        //创建图片的相对目录
        String fullAddr = PathUtil.getImgBasePath()+realFileName+extension;
        return fullAddr;
    }
    /**
     * 获取随机文件名
     */
    private static String getRandomFileName() {
        //获取随机的5位数
        int randomNum = new Random().nextInt(8999)+10000;
        String nowTimeStr = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return nowTimeStr+randomNum;
    }

    /**
     * 获取上传文件的扩展名
     */
    private static String getFileExtension(String imageName) {
        return imageName.substring(imageName.lastIndexOf("."));
    }
}

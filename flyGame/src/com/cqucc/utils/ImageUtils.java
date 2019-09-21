package com.cqucc.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyu
 * @date 2019-09-11-9:38
 */
public class ImageUtils {

    private static Map<String, BufferedImage> images =
            new HashMap<String,BufferedImage>();

    public static BufferedImage load(String name){
        BufferedImage image = images.get(name);
        try{
            if(image == null){//当map集合中没有对应名字的值时，将图片添加到map集合
                image = ImageIO.read(ImageUtils.class.
                        getClassLoader().
                        getResourceAsStream(name));
                images.put(name, image);
            }
            return image;
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
}

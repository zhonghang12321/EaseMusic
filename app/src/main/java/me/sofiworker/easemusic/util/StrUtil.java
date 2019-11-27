package me.sofiworker.easemusic.util;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/27 21:25
 * @description 字符串工具类
 */
public class StrUtil {

    public static boolean isBlank(String ...str){
        return str == null || str.length == 0 || (str.length == 1 && "".equals(str[0]));
    }
}

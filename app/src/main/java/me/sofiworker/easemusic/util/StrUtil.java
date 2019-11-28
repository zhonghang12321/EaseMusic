package me.sofiworker.easemusic.util;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/27 21:25
 * @description 字符串工具类
 */
public class StrUtil {

    public static boolean isBlank(String str){
        if (str == null) {
            return true;
        }else {
            return "".equals(str);
        }
    }
}

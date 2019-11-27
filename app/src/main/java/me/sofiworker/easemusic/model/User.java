package me.sofiworker.easemusic.model;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/27 22:48
 * @description 用户实体类
 */
public class User {

    private int loginType;
    private int code;

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

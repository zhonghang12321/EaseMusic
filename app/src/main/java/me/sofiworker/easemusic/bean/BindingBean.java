package me.sofiworker.easemusic.bean;

import java.io.Serializable;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/28 20:34
 * @description userBean中的子类
 */
public class BindingBean implements Serializable {

    private static final long serialVersionUID = 8087329643267097942L;
    private long bindingTime;
    private int refreshTime;
    private int expiresIn;
    private boolean expired;
    private String url;
    private String tokenJsonStr;
    private int userId;
    private long id;
    private int type;

    public long getBindingTime() {
        return bindingTime;
    }

    public void setBindingTime(long bindingTime) {
        this.bindingTime = bindingTime;
    }

    public int getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(int refreshTime) {
        this.refreshTime = refreshTime;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTokenJsonStr() {
        return tokenJsonStr;
    }

    public void setTokenJsonStr(String tokenJsonStr) {
        this.tokenJsonStr = tokenJsonStr;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BindingBean{" +
                "bindingTime=" + bindingTime +
                ", refreshTime=" + refreshTime +
                ", expiresIn=" + expiresIn +
                ", expired=" + expired +
                ", url='" + url + '\'' +
                ", tokenJsonStr='" + tokenJsonStr + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                ", type=" + type +
                '}';
    }
}

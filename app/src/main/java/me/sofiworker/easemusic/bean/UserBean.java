package me.sofiworker.easemusic.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/11/27 22:48
 * @description 用户实体类
 */
public class UserBean implements Serializable {

    private static final long serialVersionUID = -6691567134970337035L;
    private int loginType;
    private int code;
    private AccountBean account;
    private ProfileBean profile;
    private List<BindingBean> bindings;

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

    public AccountBean getAccount() {
        return account;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }

    public List<BindingBean> getBindings() {
        return bindings;
    }

    public void setBindings(List<BindingBean> bindings) {
        this.bindings = bindings;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "loginType=" + loginType +
                ", code=" + code +
                ", account=" + account +
                ", profile=" + profile +
                ", bindings=" + bindings +
                '}';
    }
}

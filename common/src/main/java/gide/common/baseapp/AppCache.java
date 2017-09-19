package gide.common.baseapp;

import android.content.Context;

/**
 * Created by zhaofuqi on 2017/9/19.
 * App缓
 */

public class AppCache {
    private Context context;//应用实例
    private volatile static AppCache instance;
    private String token;
    private String userId = "1000";
    private String userName = "赵";
    private String icon = "Image/20160819/1471570856669.jpeg";//  ？


    private AppCache() {
    }

    public static AppCache getInstance() {
        if (null == instance) {
            synchronized (AppCache.class) {
                if (null == instance) {
                    instance = new AppCache();
                }
            }
        }
        return instance;
    }




    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

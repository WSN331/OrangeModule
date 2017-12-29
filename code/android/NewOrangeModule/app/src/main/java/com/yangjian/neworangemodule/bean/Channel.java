package com.yangjian.neworangemodule.bean;

/**
 * Created by Yang on 2017/11/23.
 * Function：
 */

public class Channel {
    private String name;
    private int icon;

    public Channel(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}

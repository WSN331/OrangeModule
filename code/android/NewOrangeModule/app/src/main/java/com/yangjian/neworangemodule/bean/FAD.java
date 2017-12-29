package com.yangjian.neworangemodule.bean;

/**
 * Created by Yang on 2017/11/23.
 * Function：
 */

public class FAD {
    private int image;
    private String title;

    public FAD(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

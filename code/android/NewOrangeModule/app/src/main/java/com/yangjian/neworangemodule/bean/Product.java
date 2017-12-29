package com.yangjian.neworangemodule.bean;

/**
 * Created by Yang on 2017/10/31.
 * Function：产品类
 */

public class Product {
    private int image;
    private String title;
    private String price;
    private int count;
    private boolean isSelected;

    public Product(int image, String title, String price) {
        this.image = image;
        this.title = title;
        this.price = price;
    }

    public Product(int image, String title, String price, int count, boolean isSelected) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.count = count;
        this.isSelected = isSelected;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

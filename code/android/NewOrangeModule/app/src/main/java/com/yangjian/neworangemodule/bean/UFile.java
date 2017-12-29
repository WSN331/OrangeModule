package com.yangjian.neworangemodule.bean;

/**
 * Created by Yang on 2017/11/22.
 * Function：
 */

public class UFile {
    private String fileName;
    private int fileIcon;

    public UFile(String fileName, int fileIcon) {
        this.fileName = fileName;
        this.fileIcon = fileIcon;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileIcon() {
        return fileIcon;
    }

    public void setFileIcon(int fileIcon) {
        this.fileIcon = fileIcon;
    }
}

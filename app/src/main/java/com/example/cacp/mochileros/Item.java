package com.example.cacp.mochileros;

public class Item {

    //private int image;
    private String title;
    private String url;

    public Item() {
        super();
    }

    public Item(String title, String url) {
        super();
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

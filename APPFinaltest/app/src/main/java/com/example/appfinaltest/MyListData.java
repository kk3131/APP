package com.example.appfinaltest;

public class MyListData {
    private String name;        // 商品名稱
    private int imageId;        // 商品圖片資源 ID
    private String description; // 商品描述
    private String productId;   // 商品編號
    private double price;       // 商品價格

    public MyListData(String name, int imageId, String description, String productId, double price) {
        this.name = name;
        this.imageId = imageId;
        this.description = description;
        this.productId = productId;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getImgId() {
        return imageId;
    }

    public String getDescription() {
        return description;
    }

    public String getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }
}

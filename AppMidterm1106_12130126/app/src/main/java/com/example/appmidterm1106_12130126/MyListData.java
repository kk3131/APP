package com.example.appmidterm1106_12130126;

public class MyListData {
    private String name;        // 景點名稱
    private int imageId;        // 圖片資源 ID
    private String description; // 景點介紹

    public MyListData(String name, int imageId, String description) {
        this.name = name;
        this.imageId = imageId;
        this.description = description;
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

    public String getTitle() {
        return name;
    }
}

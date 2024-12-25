package com.example.appquiz20241225_12130126;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static Cart instance; // 單例模式，確保只有一個購物車存在
    private List<MyListData> cartItems;

    private Cart() {
        cartItems = new ArrayList<>();
    }


    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    //加入商品到購物車
    public void addItem(MyListData item) {
        cartItems.add(item);
        Log.d("Cart", "商品已加入購物車: " + item.getName());
    }


    public List<MyListData> getItems() {
        return cartItems;
    }

    //計算總金額
    public double calculateTotal() {
        double total = 0;
        for (MyListData product : cartItems) {
            total += product.getPrice();
        }
        return total;
    }

    //清空購物車
    public void clearCart() {
        cartItems.clear();
        Log.d("Cart", "購物車已清空");
    }
}

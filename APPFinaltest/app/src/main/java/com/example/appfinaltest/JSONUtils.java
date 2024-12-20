package com.example.appfinaltest;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JSONUtils {

    public static List<MyListData> loadProducts(Context context) {
        List<MyListData> productList = new ArrayList<>();
        try {
            InputStream is = context.getAssets().open("12130126_json.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String name = obj.getString("name");
                String productId = obj.getString("productId");
                String imageName = obj.getString("imageId");
                int imageId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
                double price = obj.getDouble("price");
                String description = obj.getString("description");
                String test= obj.getString("test");

                productList.add(new MyListData(name, imageId, description, productId, price,test));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
}

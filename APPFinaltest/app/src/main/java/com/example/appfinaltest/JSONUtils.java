package com.example.appfinaltest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.appfinaltest.SQLiteHelper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JSONUtils {

    public static void loadProductsToDatabase(Context context) {
        SQLiteHelper dbHelper = new SQLiteHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            // 載入 JSON 檔案
            InputStream is = context.getAssets().open("12130126_json.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(json); // 解析 JSON Array

            // 開始事務處理
            db.beginTransaction();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i); // 取得每一個商品資料

                ContentValues values = new ContentValues();
                values.put("productId", obj.getString("productId"));
                values.put("name", obj.getString("name"));
                values.put("price", obj.getDouble("price"));
                values.put("description", obj.getString("description"));
                values.put("test", obj.getString("test"));
                values.put("imageId", obj.getString("imageId"));

                // 插入資料庫
                db.insert("products", null, values);
            }
            db.setTransactionSuccessful(); // 設定事務成功
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            db.close();
        }
    }
}

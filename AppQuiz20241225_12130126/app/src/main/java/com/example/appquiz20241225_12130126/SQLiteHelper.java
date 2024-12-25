package com.example.appquiz20241225_12130126;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "productDatabase.db";
    private static final int DATABASE_VERSION = 2;

    // 建立商品資料表 SQL 語句
    private static final String CREATE_PRODUCTS_TABLE =
            "CREATE TABLE products (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "productId TEXT, " +
                    "name TEXT, " +
                    "price REAL, " +
                    "description TEXT, " +
                    "ISBN TEXT, " +
                    "imageId TEXT);";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PRODUCTS_TABLE); // 創建商品資料表
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS products"); // 刪除舊資料表
        onCreate(db);
    }
}


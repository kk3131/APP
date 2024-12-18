package com.example.ex18_sqlite01_12130126;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//用來連結SQLite
public class MySQLiteHelper extends SQLiteOpenHelper {
public static final String TABLE_COMMENTS="comments";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_COMMENT="comments";
//    　貼上
private static final String DATABASE_NAME="comments.db";
private static final int DATABASE_VERSION=1;
//    以上
    static String name;
    static int version;
    final String DATABASE_CREATE="create table "
            +TABLE_COMMENTS+"("+COLUMN_ID
            +"integer primary key autoincrement, "+COLUMN_COMMENT  //看55:00
            +" text not null);";
    public MySQLiteHelper(@Nullable Context context){
        super(context,name, null, version);
    }

    public MySQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //剪下
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //剪下
        db.execSQL(DATABASE_CREATE);
    }
}

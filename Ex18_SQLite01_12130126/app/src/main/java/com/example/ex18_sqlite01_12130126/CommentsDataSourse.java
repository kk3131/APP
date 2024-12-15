package com.example.ex18_sqlite01_12130126;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class CommentsDataSourse {
    MySQLiteHelper dbHelper;
    SQLiteDatabase db;
    public CommentsDataSourse(Context context){
        dbHelper=new MySQLiteHelper(context);


    }
    void open()throws SQLException {
        db = dbHelper.getWritableDatabase();

    }
    void close(){
        db.close();
    }
    public Comment creatComment(String comment){
        //39:17分
    }
    void deleteComment(Comment comment){
        long id=comment.getId();
        db.delete(MySQLiteHelper.TABLE_COMMENTS,MySQLiteHelper.COLUMN_ID
                + " = " + id, null);

    }

    List<Comment> getAllComments(){
        String[] allColumns={MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_COMMENT};
        List<Comment> comments=new ArrayList<Comment>();
        Cursor cursor=db.query(MySQLiteHelper.TABLE_COMMENTS,allColumns,null,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Comment comment=cursorToComment(cursor);
            comments.add(comment);
            cursor.moveToNext();

        }
        cursor.close();
        return comments;
    }

    private  Comment cursorToComment(Cursor cursor){
        Comment comment=new Comment();
        comment.setId(cursor.getLong(0));
        comment.setComment(cursor.getString(1));
        return comment;
    }

}

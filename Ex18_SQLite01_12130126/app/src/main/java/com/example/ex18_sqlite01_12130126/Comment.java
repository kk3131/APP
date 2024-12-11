package com.example.ex18_sqlite01_12130126;

import androidx.annotation.NonNull;

//物件導向
public class Comment extends Object{

    private long id;
    private String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public String toString() {
        String str="";
        str=str+comment;
        return comment;
    }
}

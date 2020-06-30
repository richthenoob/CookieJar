package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cookies")
public class Cookie {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "cookie")
    private String mCookie;


    public Cookie(@NonNull String mCookie) {
        this.mCookie = mCookie;
    }

    public String getCookie() {
        return this.mCookie;
    }

    public String addSpace(){
        return "    " + this.mCookie;
    }

}
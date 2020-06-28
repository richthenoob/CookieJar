package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CookieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Cookie word);

    @Delete
    void delete(Cookie word);

    @Query("DELETE from cookies")
    void deleteAll();

    @Query("SELECT * from cookies ORDER BY cookie ASC")
    LiveData<List<Cookie>> getAll();

    @Query("SELECT cookie from cookies ORDER BY RANDOM() LIMIT 1")
    Cookie getRandom();
}

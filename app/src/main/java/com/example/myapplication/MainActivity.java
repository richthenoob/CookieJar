package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void show_log(View view){
        android.util.Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, Log.class);
        startActivity(intent);
    }

    public void add_paper(View view) {
        android.util.Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, Add.class);
        startActivity(intent);
    }

    public void take_paper(View view) {
        android.util.Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, Read.class);
        startActivity(intent);
    }
}
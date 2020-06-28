package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Read extends AppCompatActivity {

    private CookieViewModel cookieViewModel;

    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        cookieViewModel = ViewModelProviders.of(this).get(CookieViewModel.class);
//        TextView textView = findViewById(R.id.single);
//        textView.setText(cookieViewModel.getRand().getCookie());
    }

        public void back (View view){
            Log.d(LOG_TAG, "Button clicked!");
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }
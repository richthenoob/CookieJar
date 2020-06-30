package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import androidx.lifecycle.Observer;

import androidx.lifecycle.ViewModelProviders;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;

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
        cookieViewModel = ViewModelProviders.of(this).get(CookieViewModel.class);
        final TextView textView = findViewById(R.id.single);
        textView.setMovementMethod(new ScrollingMovementMethod());
        final Random random = new Random();
        cookieViewModel.getAllWords().observe(this, new Observer<List<Cookie>>() {
            @Override
            public void onChanged(@Nullable final List<Cookie> words) {
                if(words.isEmpty()){
                    textView.setText(R.string.empty);
                }
                else{
                    textView.setText(words.get(random.nextInt(words.size())).getCookie());
            }}
        });

    }

    public void back(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void randomize(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, Read.class);
        startActivity(intent);
    }

}
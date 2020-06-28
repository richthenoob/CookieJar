package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add extends AppCompatActivity {

    private CookieViewModel cookieViewModel;

    private EditText mEditWordView;

    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        cookieViewModel = ViewModelProviders.of(this).get(CookieViewModel.class);
    }

    public void add_to_db(View view) {
        mEditWordView = findViewById(R.id.editTextTextMultiLine);
        Log.d(LOG_TAG, "Button clicked!");
        Intent replyIntent = new Intent();
        if (TextUtils.isEmpty(mEditWordView.getText())) {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        } else {
            Cookie word = new Cookie(mEditWordView.getText().toString());
            cookieViewModel.insert(word);
            Toast.makeText(
                    getApplicationContext(),
                    R.string.saved,
                    Toast.LENGTH_LONG).show();
            mEditWordView.setText("");
        }
    }



public void back(View view){
        Log.d(LOG_TAG,"Button clicked!");
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        }
        }
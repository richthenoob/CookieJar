package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class Log extends AppCompatActivity {

    private CookieViewModel cookieViewModel;

    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookies);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final CookieListAdapter adapter = new CookieListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cookieViewModel = ViewModelProviders.of(this).get(CookieViewModel.class);
        cookieViewModel.getAllWords().observe(this, new Observer<List<Cookie>>() {
            @Override
            public void onChanged(@Nullable final List<Cookie> words) {
                // Update the cached copy of the words in the adapter.
                for (Cookie word:
                     words) {
                    word.addSpace();
                }
                adapter.setWords(words);
            }
        });
        ItemTouchHelper helper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0,
                        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView,
                                          RecyclerView.ViewHolder viewHolder,
                                          RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder,
                                         int direction) {
                        int position = viewHolder.getAdapterPosition();
                        Cookie myWord = adapter.getCookieAtPosition(position);
                        Toast.makeText(Log.this, "Deleted " +
                                myWord.getCookie(), Toast.LENGTH_LONG).show();

                        // Delete the word
                        cookieViewModel.delete(myWord);
                    }
                });

        helper.attachToRecyclerView(recyclerView);
    }

    public void back(View view) {
        android.util.Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void deleteAll(View view) {
        android.util.Log.d(LOG_TAG, "Button clicked!");
        cookieViewModel.deleteAll();
        Intent intent = new Intent(this, Log.class);
        startActivity(intent);
    }


}
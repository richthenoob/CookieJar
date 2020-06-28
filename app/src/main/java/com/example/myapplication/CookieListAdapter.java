package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CookieListAdapter extends RecyclerView.Adapter<CookieListAdapter.CookieViewHolder>{

    private final LayoutInflater mInflater;
    private List<Cookie> mWords; // Cached copy of words

    CookieListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public CookieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new CookieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CookieViewHolder holder, int position) {
        if (mWords != null) {
            Cookie current = mWords.get(position);
            holder.wordItemView.setText(current.getCookie());
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
        }
    }

    void setWords(List<Cookie> words) {
        mWords = words;
        notifyDataSetChanged();
    }

    void setWord(Cookie word){
        mWords.add(word);
        notifyDataSetChanged();
    }

    public Cookie getCookieAtPosition (int position) {
        return mWords.get(position);
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;
    }

    class CookieViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;

        private CookieViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }
}

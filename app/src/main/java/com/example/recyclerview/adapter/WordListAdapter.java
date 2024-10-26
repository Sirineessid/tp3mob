package com.example.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.model.Word;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>  {
    private final LinkedList<Word> mWordList;

    public WordListAdapter(LinkedList<Word> mWordList) {
        this.mWordList = mWordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View adapterLayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wordlist_item, parent, false);

        return new WordViewHolder(adapterLayout, this);
    }
    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        Word mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent.getWord());
    }

    @Override
    public int getItemCount() {
        return 0;
    }



    public static class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView wordItemView;
        public LinkedList<Word> mWordList;
        final WordListAdapter mAdapter;
        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word_title);
            this.mAdapter = adapter;
            mWordList = new LinkedList<>();
        }
        public void WordListAdapter(LinkedList<Word> mWordList) {
            this.mWordList = mWordList;
        }

        public int getItemCount() {
            return mWordList.size();
        }
    }
}

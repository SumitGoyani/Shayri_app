package com.example.shayri_app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shayri_app.Fourth_page;
import com.example.shayri_app.R;

public class EmojiAdapter extends BaseAdapter {

    Fourth_page fourth_page;
    String[] emoji;

    public EmojiAdapter(Fourth_page fourth_page, String[] emoji) {
        this.fourth_page = fourth_page;
        this.emoji = emoji;
    }

    @Override
    public int getCount() {
        return emoji.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(fourth_page).inflate(R.layout.emoji_item,parent,false);

        TextView textView = convertView.findViewById(R.id.emoji_textview);
        textView.setText(""+emoji[position]);

        return convertView;
    }
}

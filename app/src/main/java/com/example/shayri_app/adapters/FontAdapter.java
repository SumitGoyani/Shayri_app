package com.example.shayri_app.adapters;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shayri_app.Fourth_page;
import com.example.shayri_app.R;

public class FontAdapter extends BaseAdapter {

    Fourth_page fourth_page;
    String[] fonts;

    public FontAdapter(Fourth_page fourth_page, String[] fonts) {
        this.fourth_page = fourth_page;
        this.fonts = fonts;
    }

    @Override
    public int getCount() {
        return fonts.length;
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

        convertView = LayoutInflater.from(fourth_page).inflate(R.layout.font_item,parent,false);
        Typeface typeface = Typeface.createFromAsset(fourth_page.getAssets(),fonts[position]);
        TextView textView = convertView.findViewById(R.id.fonts);
        textView.setText("शायरी");
        textView.setTypeface(typeface);

        return convertView;
    }
}

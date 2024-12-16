package com.example.shayri_app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shayri_app.Fourth_page;
import com.example.shayri_app.R;

public class BgAdapter extends BaseAdapter {

    Fourth_page fourth_page;
    int[] colorarr;

    public BgAdapter(Fourth_page fourth_page, int[] colorarr) {
        this.fourth_page = fourth_page;
        this.colorarr = colorarr;
    }

    @Override
    public int getCount() {
        return colorarr.length;
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
        convertView = LayoutInflater.from(fourth_page).inflate(R.layout.bg_grid_color_item,parent,false);

        TextView textView = convertView.findViewById(R.id.background);
        textView.setBackgroundResource(colorarr[position]);

        return convertView;
    }
}

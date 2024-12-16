package com.example.shayri_app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shayri_app.R;

public class ListAdapter extends BaseAdapter {

    com.example.shayri_app.list_second_page list_second_page;
    int img;
String shayri[];

    public ListAdapter(com.example.shayri_app.list_second_page list_second_page, int img, String[] shayri) {
        this.list_second_page = list_second_page;
        this.img = img;
        this.shayri = shayri;
    }

    @Override
    public int getCount() {
        return shayri.length;
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
        convertView = LayoutInflater.from(list_second_page).inflate(R.layout.list_item,parent,false);

        ImageView imageView = convertView.findViewById(R.id.img2);
        ImageView imageView2 = convertView.findViewById(R.id.nextbutton);
        TextView textView = convertView.findViewById(R.id.txt2);
        imageView.setImageResource(img);
        textView.setText(""+shayri[position]);
        imageView2.setImageResource(R.drawable.navigate_next_24);

        return convertView;
    }
}

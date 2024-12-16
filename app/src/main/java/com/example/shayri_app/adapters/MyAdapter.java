package com.example.shayri_app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shayri_app.MainActivity;
import com.example.shayri_app.R;

public class MyAdapter extends BaseAdapter
{
    MainActivity mainActivity;
    int[] img;
    String[] s1;


    public MyAdapter(MainActivity mainActivity, int[] img, String[] s1) {
        this.mainActivity = mainActivity;
        this.img = img;
        this.s1 = s1;

    }

    @Override
    public int getCount() {
        return s1.length;
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

        convertView = LayoutInflater.from(mainActivity).inflate(R.layout.main_item,parent,false);
        ImageView imageView = convertView.findViewById(R.id.img1);
        TextView textView = convertView.findViewById(R.id.txt1);
        imageView.setImageResource(img[position]);
        textView.setText(""+s1[position]);
        return convertView;
    }

    
}

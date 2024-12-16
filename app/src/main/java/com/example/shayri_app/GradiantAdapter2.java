package com.example.shayri_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GradiantAdapter2 extends BaseAdapter {

    Fourth_page fourth_page;
    int[] gradientArr;

    public GradiantAdapter2(Fourth_page fourth_page, int[] gradientArr) {
        this.fourth_page = fourth_page;
        this.gradientArr = gradientArr;
    }

    @Override
    public int getCount() {
        return gradientArr.length;
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
        convertView = LayoutInflater.from(fourth_page).inflate(R.layout.bottom_sheet_gradient_item,parent,false);

        TextView textView = convertView.findViewById(R.id.gridGradients);
        textView.setBackgroundResource(gradientArr[position]);

        return convertView;
    }
}

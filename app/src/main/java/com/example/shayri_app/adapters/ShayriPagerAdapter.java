package com.example.shayri_app.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.shayri_app.R;

public class ShayriPagerAdapter extends PagerAdapter
{
    Context context;
    String[] ss;
    TextView textView;
    public ShayriPagerAdapter(Context context, String[] ss, TextView textView) {
        this.context=context;
        this.ss=ss;
        this.textView=textView;
    }

    @Override
    public int getCount() {
        return ss.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view= LayoutInflater.from(context).inflate(R.layout.pager_item,container,false);
        //textView.setText(""+ss[position-1]);
        Log.d("TTT", "instantiateItem: Position="+position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View) object);
    }
}

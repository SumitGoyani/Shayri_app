//package com.example.shayri_app;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.GridView;
//import android.widget.TextView;
//
//public class grid_color extends AppCompatActivity
//{
//    GridView gridView;
//    gridAdapter adapter;
//    int gridcolorarr[] = {R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,R.drawable.c11,R.drawable.c12,R.drawable.c13,R.drawable.c14,R.drawable.c15};
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_grid_colors);
//        gridView = findViewById(R.id.gridviewcolor);
//        adapter = new gridAdapter(grid_color.this,gridcolorarr);
//        gridView.setAdapter(adapter);
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(grid_color.this,Third_page.class);
//                intent.putExtra("gridcolor",gridcolorarr[position]);
//                startActivity(intent);
//            }
//        });
//    }
//}

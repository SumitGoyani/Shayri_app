package com.example.shayri_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shayri_app.adapters.BgAdapter;
import com.example.shayri_app.adapters.EmojiAdapter;
import com.example.shayri_app.adapters.FontAdapter;
import com.example.shayri_app.adapters.TextcolorAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Fourth_page extends AppCompatActivity
{
    TextView textView,t1,t2,t3,t4,t5,t6;
    ImageView imageView1,imageView2;
    ListView listView;
    int cnt=0,i=0,a;
    String[] shayri;
    GridView gridView,gridView1,gridView2;
    int[] gridcolorarr;
    int[] position;
    private File downloadFile;
    //private LinearLayout view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_page);

        textView=findViewById(R.id.txtshayri);
        t1=findViewById(R.id.menu1);
        t2=findViewById(R.id.menu2);
        t3=findViewById(R.id.menu3);
        t4=findViewById(R.id.menu4);
        t5=findViewById(R.id.menu5);
        t6=findViewById(R.id.menu6);
        imageView1=findViewById(R.id.imageview1);
        imageView2=findViewById(R.id.imageview2);
        gridcolorarr = getIntent().getIntArrayExtra("gridcolorarr");
        shayri = getIntent().getStringArrayExtra("shayri");
        a = getIntent().getIntExtra("a",0);
        textView.setText(""+shayri[a]);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cnt<15) {
                    if (cnt == i) {
                        textView.setBackgroundResource(gridcolorarr[i]);
                        cnt++;
                        i++;
                    }
                }else{
                    cnt=0;
                    i=0;
                }
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Fourth_page.this);
                bottomSheetDialog.setContentView(R.layout.bottom_sheet_gradients);
                GradiantAdapter2 adapter=new GradiantAdapter2(Fourth_page.this,config.gradientArr);
                gridView=bottomSheetDialog.findViewById(R.id.gridviewGradients);
                gridView.setAdapter(adapter);
                bottomSheetDialog.show();
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textView.setBackgroundResource(config.gradientArr[i]);
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog2 = new BottomSheetDialog(Fourth_page.this);
                bottomSheetDialog2.setContentView(R.layout.bg_colors);
                BgAdapter adapter2 = new BgAdapter(Fourth_page.this,config.colorarr);
                gridView1 = bottomSheetDialog2.findViewById(R.id.bg_gridview);
                gridView1.setAdapter(adapter2);
                bottomSheetDialog2.show();
                gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        textView.setBackgroundResource(config.colorarr[position]);
                        bottomSheetDialog2.dismiss();
                    }
                });
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog3 = new BottomSheetDialog(Fourth_page.this);
                bottomSheetDialog3.setContentView(R.layout.activity_text_color);
                TextcolorAdapter adapter3 = new TextcolorAdapter(Fourth_page.this,config.colorarr);
                gridView2 = bottomSheetDialog3.findViewById(R.id.textcolor_gridview);
                gridView2.setAdapter(adapter3);
                bottomSheetDialog3.show();
                gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position1, long id) {
                        textView.setTextColor(getResources().getColor(config.colorarr[position1]));
                        bottomSheetDialog3.dismiss();
                    }
                });
            }
        });

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog3 = new BottomSheetDialog(Fourth_page.this);
                bottomSheetDialog3.setContentView(R.layout.activity_font);
                FontAdapter adapter = new FontAdapter(Fourth_page.this,config.fonts);
                GridView gridView3 = bottomSheetDialog3.findViewById(R.id.fonts_gridview);
                gridView3.setAdapter(adapter);
                bottomSheetDialog3.show();

                gridView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Typeface typeface = Typeface.createFromAsset(getAssets(),config.fonts[position]);
                        textView.setTypeface(typeface);
                    }
                });
            }
        });

        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog4 = new BottomSheetDialog(Fourth_page.this);
                bottomSheetDialog4.setContentView(R.layout.activity_emoji);
                EmojiAdapter adapter4 = new EmojiAdapter(Fourth_page.this,config.emoji);
                listView = bottomSheetDialog4.findViewById(R.id.emoji_listview);
                listView.setAdapter(adapter4);
                bottomSheetDialog4.show();

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        textView.setText(""+config.emoji[position]+"\n"+shayri[position]+"\n"+config.emoji[position]);
                        bottomSheetDialog4.dismiss();
                    }
                });
            }
        });

        t6.setOnClickListener(view -> {
            BottomSheetDialog bottomSheetDialog4 = new BottomSheetDialog(Fourth_page.this);
            bottomSheetDialog4.setContentView(R.layout.activity_text_size);
            SeekBar seekBar= bottomSheetDialog4.findViewById(R.id.seekBar);
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    textView.setTextSize(2,20+i);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
            bottomSheetDialog4.show();
        });
        t3.setOnClickListener(view -> {
            Bitmap icon = getBitmapFromView(textView);
            //Intent share = new Intent(Intent.ACTION_SEND);
            Intent share =new Intent(Intent.ACTION_SEND);
            share.setType("image/jpeg");
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            int num=new Random().nextInt(2000);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
            String currentDateandTime = sdf.format(new Date());

            downloadFile= new File(config.file.getAbsolutePath() + "/IMG_"+currentDateandTime+".jpg");
            try
            {
                downloadFile.createNewFile();
                FileOutputStream fo = new FileOutputStream(downloadFile);
                fo.write(bytes.toByteArray());
                Toast.makeText(Fourth_page.this,"File Downloaded",Toast.LENGTH_LONG).show();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            share.putExtra(Intent.EXTRA_STREAM, Uri.parse(downloadFile.getAbsolutePath()));
            startActivity(Intent.createChooser(share, "Share Image"));

        });
    }

    private Bitmap getBitmapFromView(TextView textView)
    {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(textView.getWidth(), textView.getHeight(), Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable = textView.getBackground();
        if (bgDrawable != null)
        {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        }
        else
        {
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        }
        // draw the view on the canvas
        textView.draw(canvas);
        //return the bitmap
        return returnedBitmap;

    }
}

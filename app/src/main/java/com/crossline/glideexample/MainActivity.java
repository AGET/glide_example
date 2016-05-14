package com.crossline.glideexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private ImageView imgToShow;
    private Button btnLoadImage;
    private Button btnCircleImagen;
    private Button btnCenterCrop;
    private Button btnPlaceHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    private void initComponents()
    {
        imgToShow = (ImageView)findViewById(R.id.imgToShow);
        btnLoadImage = (Button)findViewById(R.id.btnLoadImage);
        btnCircleImagen = (Button)findViewById(R.id.btnCircleImagen);
        btnCenterCrop = (Button)findViewById(R.id.btnCenterCrop);
        btnPlaceHolder = (Button)findViewById(R.id.btnPlaceHolder);



        btnLoadImage.setOnClickListener(this);
        btnCircleImagen.setOnClickListener(this);
        btnCenterCrop.setOnClickListener(this);
        btnPlaceHolder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnLoadImage:
                Glide.with(this.getApplicationContext())
                        .load("https://nuevastecsomamfyc.files.wordpress.com/2015/06/versiones-android.jpg")
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(imgToShow);
                break;
            case R.id.btnCircleImagen:
                Glide.with(this.getApplicationContext())
                        .load("https://nuevastecsomamfyc.files.wordpress.com/2015/06/versiones-android.jpg")
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .bitmapTransform(new CircleTransform(this))
                        .into(imgToShow);
                break;
            case R.id.btnCenterCrop:
                Glide.with(this.getApplicationContext())
                        .load("https://nuevastecsomamfyc.files.wordpress.com/2015/06/versiones-android.jpg")
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .centerCrop()
                        .into(imgToShow);
                break;
            case R.id.btnPlaceHolder:
                Glide.with(this.getApplicationContext())
                        .load("https://nuevastecsomamfyc.files.wordpress.com/2015/06/versiones-android.jpg")
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .crossFade(1000)
                        .placeholder(R.drawable.placeholder)
                        .into(imgToShow);
                break;
        }
    }

    @Override
    protected void onDestroy()
    {
        Glide.clear(imgToShow);
        super.onDestroy();
    }
}

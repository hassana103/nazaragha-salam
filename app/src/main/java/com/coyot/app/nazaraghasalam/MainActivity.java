package com.coyot.app.nazaraghasalam;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ViewPager vp;
    ArrayList<GalleryItem> GalleryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GalleryItem i1=new GalleryItem(R.drawable.ic_launcher_background,"item 1111");
        GalleryItem i2=new GalleryItem(R.drawable.ic_launcher_background,"item 2222");
        GalleryItem i3=new GalleryItem(R.drawable.ic_launcher_background,"item 3333");
        GalleryItem i4=new GalleryItem(R.drawable.ic_launcher_background,"item 4444");

        GalleryList=new ArrayList<GalleryItem>();
        GalleryList.add(i1);
        GalleryList.add(i2);
        GalleryList.add(i3);
        GalleryList.add(i4);

        GalleryAdapter ga=new GalleryAdapter(this,GalleryList);

        vp=(ViewPager) findViewById(R.id.gallery_main);
        vp.setAdapter(ga);

        //vp.setPageTransformer(true, new ZoomOutPageTransformer());


        //startGalleryAnimation();


    }


    public void startGalleryAnimation(){

        Handler galleryAnimationHandler=new Handler();

        galleryAnimationHandler.post(new Runnable() {
            @Override
            public void run() {
                int pos=vp.getCurrentItem();
                vp.setCurrentItem((pos+1)%GalleryList.size(),true);
                vp.postDelayed(this,2000);
            }
        });

    }



}

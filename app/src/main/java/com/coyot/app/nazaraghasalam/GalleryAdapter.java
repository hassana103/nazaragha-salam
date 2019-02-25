package com.coyot.app.nazaraghasalam;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GalleryAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<GalleryItem> mList;

    public GalleryAdapter(Context c , ArrayList<GalleryItem> list){
        mContext=c;
        mList=list;

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        final GalleryItem item = mList.get(position);


        View convertView= LayoutInflater.from(mContext).inflate(R.layout.gallery_item,container,false);

        convertView.setTag(item.Link);

        ImageView GalleryItemImage=(ImageView)convertView.findViewById(R.id.img_GalleryItem);
        GalleryItemImage.setImageResource(item.ImageId);


        TextView GalleryItemText=(TextView)convertView.findViewById(R.id.txt_GallertItem);
        GalleryItemText.setText(item.Link);

        container.addView(convertView);
        return convertView;

    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}

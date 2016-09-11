package com.example.pesc.phrapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by PESC on 2016-09-10.
 */
public class GridAdapter extends BaseAdapter {

    Context context;
    int layout;
    int image[];
    LayoutInflater inflater;

    public GridAdapter(Context context, int layout, int[] image ) {
        this.context = context;
        this.layout = layout;
        this.image = image;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int position) {
        return image[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null)
            convertView = inflater.inflate(layout, null);
        ImageLoader imageLoader = ImageLoader.getInstance();

        ImageView imageView = (ImageView)convertView.findViewById(R.id.imageView);
        //imageView.setImageResource(image[position]);
        imageLoader.displayImage("drawable://"+image[position],imageView);

        return convertView;
    }

}

package com.example.diegofranco.materialbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by DiegoFranco on 12/3/14.
 */
public class GridViewAdapter extends BaseAdapter {


    @Override
    public int getCount() {
        return 10;
    }


    @Override
    public Object getItem(int i) {
        return "Item " + String.valueOf(i + 1);
    }


    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_item, viewGroup, false);
        }


        String imageUrl = "http://lorempixel.com/800/600/abstract/" + String.valueOf(i + 1);
        view.setTag(imageUrl);


        ImageView image = (ImageView) view.findViewById(R.id.image);
        Picasso.with(view.getContext())
                .load(imageUrl)
                .into(image);


        TextView text = (TextView) view.findViewById(R.id.text);
        text.setText(getItem(i).toString());


        return view;
    }
}

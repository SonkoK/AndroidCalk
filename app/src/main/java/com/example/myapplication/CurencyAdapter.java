package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class CurencyAdapter extends BaseAdapter {
    private List<Currencies> currencyList= new ArrayList<>();
    private Context context;
    public CurencyAdapter(Context context, List<Currencies> currencyList) {
//        super(context,R.layout.spinner_layout);
//        super(context, 0);
        this.currencyList= currencyList;
        this.context=context;
    }

    public View getCustomView(int position, View convertView,
                              ViewGroup parent) {

        convertView = (LayoutInflater.from(context)).inflate(R.layout.spinner_layout, null);



        TextView curencyName = (TextView) convertView.findViewById(R.id.item_txt_view);

// Setting the text using the array
        curencyName.setText(currencyList.get(position).getCurensyName());

// Setting the color of the text
        curencyName.setTextColor(Color.rgb(75, 180, 225));

// Declaring and Typecasting the imageView in the inflated layout
        ImageView img = (ImageView) convertView.findViewById(R.id.item_img_view);

// Setting an image using the id's in the array
        img.setImageResource(currencyList.get(position).getImage());

// Setting Special atrributes for 1st element
//        if (position == 0) {
//// Removing the image view
//            img.setVisibility(View.GONE);
//// Setting the size of the text
//            curencyName.setTextSize(20f);
//// Setting the text Color
//            curencyName.setTextColor(Color.BLACK);
//
//        }

        return convertView;
    }

    // It gets a View that displays in the drop down popup the data at the specified position
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        return currencyList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    // It gets a View that displays the data at the specified position
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
}

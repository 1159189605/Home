package com.example.a123.homelvoe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.a123.homelvoe.R;
import com.example.a123.homelvoe.util.Shop;

import java.util.ArrayList;

/**
 * Created by 123 on 2016/8/9.
 */
public class Shopadapter extends BaseAdapter{
    ArrayList<Shop> shops;
    Context context;
    public Shopadapter(Context context, ArrayList<Shop> citys) {
        this.context = context;
        this.shops = citys;
    }


    @Override
    public int getCount() {
        return shops.size();
    }

    @Override
    public Object getItem(int i) {
        return shops.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.home_listitem,null);
        return view;
    }
}

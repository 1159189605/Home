package com.example.a123.homelvoe.fragment;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.a123.homelvoe.R;
import com.example.a123.homelvoe.adapter.Shopadapter;
import com.example.a123.homelvoe.util.Shop;

import org.xutils.x;

import java.util.ArrayList;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * Created by 123 on 2016/8/9.
 */
public class HomepageFragment extends Fragment{
  ArrayList<Fragment> arrayList=new ArrayList<>();
    ArrayList<Shop> shops=new ArrayList<>();
    ArrayList<Fragment> lunbo=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
       View view=  inflater.inflate(R.layout.fragmenthomepage,null);

        arrayList.add(new HomeGridFragment());
        arrayList.add(new HomeGridFragment2());
        lunbo.add(new ReleaseFragment());
        lunbo.add(new PersonalFragment());
        ViewPager pager=   (ViewPager)view.findViewById(R.id.viewpager);
        ListView listView=(ListView)view.findViewById(R.id.home_list);
        AutoScrollViewPager scrollViewPager=  (AutoScrollViewPager)view.findViewById(R.id.lunbo);
        pager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return arrayList.get(position);
            }

            @Override
            public int getCount() {
                return arrayList.size();
            }
        });
        Shopadapter shopadapter=new Shopadapter(getContext(),shops);
        listView.setAdapter(shopadapter);
        scrollViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return lunbo.get(position);
            }

            @Override
            public int getCount() {
                return lunbo.size();
            }
        });
       scrollViewPager.setInterval(2000); //设置自动滚动的间隔时间，单位为毫秒
        scrollViewPager.setDirection(0) ;//设置自动滚动的方向，默认向右
        scrollViewPager.setCycle(true); //是否自动循环轮播，默认为true
        //scrollViewPager.setScrollDurationFactor(double) 设置ViewPager滑动动画间隔时间的倍率，达到减慢动画或改变动画速度的效果
        scrollViewPager.setStopScrollWhenTouch(true); //当手指碰到ViewPager时是否停止自动滚动，默认为true
        //scrollViewPager.setSlideBorderMode(int); //滑动到第一个或最后一个Item的处理方式，支持没有任何操作、轮播以及传递到父View三种模式
        scrollViewPager.setBorderAnimation(true); //设置循环滚动时滑动到从边缘滚动到下一个是否需要动画，默认为true
        scrollViewPager.startAutoScroll();




        return view;
    }
}

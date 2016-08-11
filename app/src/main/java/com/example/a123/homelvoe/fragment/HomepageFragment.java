package com.example.a123.homelvoe.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.a123.homelvoe.MainActivity;
import com.example.a123.homelvoe.R;
import com.example.a123.homelvoe.util.Shop;
import com.flyco.animation.BaseAnimatorSet;
import com.flyco.animation.FadeExit.FadeExit;
import com.flyco.animation.SlideEnter.SlideTopEnter;
import com.flyco.animation.SlideExit.SlideBottomExit;
import com.flyco.dialog.listener.OnBtnLeftClickL;
import com.flyco.dialog.listener.OnBtnRightClickL;
import com.flyco.dialog.widget.MaterialDialog;
import com.flyco.dialog.widget.NormalDialog;
import com.squareup.picasso.Picasso;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;

import cn.trinea.android.common.util.ListUtils;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * Created by 123 on 2016/8/9.
 */
public class HomepageFragment extends Fragment{
    ArrayList<Fragment> arrayList=new ArrayList<>();

    ArrayList<Fragment> lunbo=new ArrayList<>();
    ArrayList<String> shopname=new ArrayList<>();
    ArrayList<String> shopper=new ArrayList<>();
    ArrayList<String> opentime=new ArrayList<>();
    ArrayList<String> closetime=new ArrayList<>();
    ArrayList<String> shopsimg=new ArrayList<>();
    ArrayList<String>  shopphone=new ArrayList<>();
    BaseAdapter baseAdapter;
    AutoScrollViewPager scrollViewPager;
    BaseAnimatorSet bas_in;
    BaseAnimatorSet bas_out;
    String phone;




    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view=  inflater.inflate(R.layout.fragmenthomepage,null);
        bas_in = new SlideTopEnter();
        bas_out = new SlideBottomExit();

        arrayList.add(new HomeGridFragment());
        arrayList.add(new HomeGridFragment2());

        lunbo.add(new PersonalFragment());
        lunbo.add(new ReleaseFragment());

        ViewPager pager=   (ViewPager)view.findViewById(R.id.viewpager);
        ListView listView=(ListView)view.findViewById(R.id.home_list);
        wangluo();
         scrollViewPager=  (AutoScrollViewPager)view.findViewById(R.id.lunbo);
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
        //scrollViewPager.setDirection(0) ;//设置自动滚动的方向，默认向右
        scrollViewPager.setCycle(true); //是否自动循环轮播，默认为true
        //scrollViewPager.scheduleDrawable(); //设置ViewPager滑动动画间隔时间的倍率，达到减慢动画或改变动画速度的效果
        scrollViewPager.setStopScrollWhenTouch(true); //当手指碰到ViewPager时是否停止自动滚动，默认为true
        //scrollViewPager.setSlideBorderMode(int); //滑动到第一个或最后一个Item的处理方式，支持没有任何操作、轮播以及传递到父View三种模式
        //scrollViewPager.setBorderAnimation(false); //设置循环滚动时滑动到从边缘滚动到下一个是否需要动画，默认为true
        scrollViewPager.startAutoScroll();
       scrollViewPager.setCurrentItem(Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % ListUtils.getSize(lunbo));


        baseAdapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return shopname.size();
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(final int i, View view, ViewGroup viewGroup) {
                view=inflater.inflate(R.layout.home_listitem,null);
               ((TextView)view.findViewById(R.id.item_name)).setText(shopname.get(i));
               ((TextView)view.findViewById(R.id.item_per)).setText("$"+shopper.get(i)+"元/人");
              ((TextView)view.findViewById(R.id.item_time)).setText(opentime.get(i)+"--"+closetime.get(i));

                Picasso.with(getContext()).load(shopsimg.get(i)).into((ImageView)view.findViewById(R.id.item_tu));

              ImageView imageView= (ImageView) view.findViewById(R.id.listphone);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        phone=shopphone.get(i);

                        NormalDialogCustomAttr();

                    }
                });



                return view;
            }
        };

       listView.setAdapter(baseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Toast.makeText(getContext(), "我是"+(i+1)+"楼", Toast.LENGTH_SHORT).show();
                    case 1:
                        Toast.makeText(getContext(), "我是"+(i+1)+"楼", Toast.LENGTH_SHORT).show();


                }

            }
        });







        return view;
    }
    public void wangluo(){
        RequestParams rp=new RequestParams("http://123.206.87.139/LoveHomeTownServer/detailInfo?is_approve=1");
        x.http().get(rp, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Shop shop= JSON.parseObject(result,Shop.class);
                for(int i=0;i<shop.getList().size();i++){
                    shopname.add(shop.getList().get(i).getMerchant_name());
                    shopper.add(shop.getList().get(i).getPer_capita_consumption());
                    opentime.add(shop.getList().get(i).getOpening_time());
                    closetime.add(shop.getList().get(i).getClosing_time());
                    shopsimg.add(shop.getList().get(i).getImgUrlList().get(0).getImg_url());
                    shopphone.add(shop.getList().get(i).getPhone());

                }
                 baseAdapter.notifyDataSetChanged();


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    private void NormalDialogCustomAttr() {
        final NormalDialog dialog = new NormalDialog(getContext());
        dialog.isTitleShow(false)//
                .bgColor(Color.parseColor("#ffffff"))//
                .cornerRadius(5)//
                .content("确定要拨打的电话："+phone)//
                .contentGravity(Gravity.CENTER)//
                .contentTextColor(Color.parseColor("#222222"))//
                .dividerColor(Color.parseColor("#222222"))//
                .btnTextSize(15.5f, 15.5f)//
                .btnTextColor(Color.parseColor("#33ff33"), Color.parseColor("#33ff33"))//
                .btnColorPress(Color.parseColor("#ffffff"))//
                .widthScale(0.85f)//
                .showAnim(bas_in)//
                .dismissAnim(bas_out)//
                .show();

        dialog.setOnBtnLeftClickL(new OnBtnLeftClickL() {
            @Override
            public void onBtnLeftClick() {
                Intent intent = new Intent(Intent.ACTION_CALL);
                Uri data = Uri.parse("tel:" + phone);
                intent.setData(data);
                startActivity(intent);


                dialog.dismiss();
            }
        });

        dialog.setOnBtnRightClickL(new OnBtnRightClickL() {
            @Override
            public void onBtnRightClick() {

                dialog.dismiss();
            }
        });
    }

}

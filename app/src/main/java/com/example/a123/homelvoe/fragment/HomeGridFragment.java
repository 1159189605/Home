package com.example.a123.homelvoe.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.a123.homelvoe.MainActivity;
import com.example.a123.homelvoe.R;
import com.example.a123.homelvoe.util.Imagetype;
import com.squareup.picasso.Picasso;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by 123 on 2016/8/9.
 */
public class HomeGridFragment extends Fragment {
    ArrayList<String> name=new ArrayList<>();
    ArrayList<String> image=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.homeviewpage_fragment,null);
        GridView gridView=(GridView) view.findViewById(R.id.home_grid);
        Log.e("TAG", "hahah");
        wangluo();
        gridView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return name.size();
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                view=LayoutInflater.from(getContext()).inflate(R.layout.home_griditem,null);

                ((TextView)view.findViewById(R.id.home_grid_tv)).setText(name.get(i));
                Bitmap bitmap = getHttpBitmap(image.get(i));




              ((ImageView)view.findViewById(R.id.home_grid_im)).setImageBitmap(bitmap);

                return view;
            }
        });

        return view;




    }
    public void wangluo(){
        RequestParams requestParams=new RequestParams("http://123.206.87.139/LoveHomeTownServer/printCategory");
        x.http().get(requestParams, new Callback.CommonCallback<String>() {


            public void onSuccess(String result) {
                Imagetype imagetype= JSON.parseObject(result,Imagetype.class);
                for (int i=0;i<8;i++){
                    name.add(imagetype.getList().get(i).getParent_cate_name());
                    image.add(imagetype.getList().get(i).getParent_cate_img_url());
                }
                Log.e("TAG",imagetype.getList().get(7).getParent_cate_name());
                Log.e("TAG",imagetype.getList().get(7).getParent_cate_img_url());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(getContext() ,"网络获取失败", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
    public static Bitmap getHttpBitmap(String url){
        URL myFileURL;
        Bitmap bitmap=null;
        try{
            myFileURL = new URL(url);
            //获得连接
            HttpURLConnection conn=(HttpURLConnection)myFileURL.openConnection();
            //设置超时时间为6000毫秒，conn.setConnectionTiem(0);表示没有时间限制
            conn.setConnectTimeout(6000);
            //连接设置获得数据流
            conn.setDoInput(true);
            //不使用缓存
            conn.setUseCaches(false);
            //这句可有可无，没有影响
            //conn.connect();
            //得到数据流
            InputStream is = conn.getInputStream();
            //解析得到图片
            bitmap = BitmapFactory.decodeStream(is);
            //关闭数据流
            is.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }


}

package com.example.a123.homelvoe.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.preference.DialogPreference;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a123.homelvoe.MainActivity;
import com.example.a123.homelvoe.R;

import java.util.ArrayList;

/**
 * Created by 123 on 2016/8/9.
 */
public class PersonalFragment extends Fragment{
    private ListView mylistview;
    private LinearLayout liner;
    private ArrayList<String>list=new ArrayList<String>();
    int[] arc={R.mipmap.img_1,R.mipmap.img_2,R.mipmap.img_3,R.mipmap.img_4,R.mipmap.img_5,
            R.mipmap.img_6,R.mipmap.img_7,R.mipmap.img_8,R.mipmap.img_9};
    String[]msg={"我的发布","我的草稿","我的收藏","我的消息","平台声明","关于爱家乡","分享软件","修改密码","清除缓存"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=  inflater.inflate(R.layout.fragmentpersonal,null);
        mylistview =(ListView)view.findViewById(R.id.lt);
        mylistview.setAdapter(new BaseAdapter() {
            public View getView(int position, View convertView, ViewGroup parent) {
                // TODO Auto-generated method stub
                convertView=LayoutInflater.from(getActivity()).inflate(R.layout.listview,null);
                ( (ImageView)convertView.findViewById(R.id.img)).setImageResource(arc[position]);
                ((TextView)convertView.findViewById(R.id.tx1)).setText(msg[position]);
                return convertView;
            }
            public long getItemId(int position) {
                // TODO Auto-generated method stub
                return position;
            }

            @Override
            public Object getItem(int position) {
                // TODO Auto-generated method stub
                return msg[position];
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return msg.length;
            }
        });
        view.findViewById(R.id.person_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getActivity(), com.example.usermanagement.MainActivity.class);
                startActivity(it);
            }
        });

        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case (0):
                        Intent it=new Intent(getActivity(),PersonalFragment.class);
                        getActivity().startActivity(it);
                        break;
                    case (1):
                        Intent it1=new Intent(getActivity(),PersonalFragment.class);
                        getActivity().startActivity(it1);
                        break;
                    case (2):
                        Intent it2=new Intent(getActivity(),PersonalFragment.class);
                        getActivity().startActivity(it2);
                        break;
                    case (3):
                        Intent it3=new Intent(getActivity(),PersonalFragment.class);
                        getActivity().startActivity(it3);
                        break;
                    case (4):
                        Intent it4=new Intent(getActivity(),PersonalFragment.class);
                        getActivity().startActivity(it4);
                        break;
                    case (5):
                        Intent it5=new Intent(getActivity(),PersonalFragment.class);
                        getActivity().startActivity(it5);
                        break;
                    case (6):
                        Intent it6=new Intent(getActivity(),PersonalFragment.class);
                        getActivity().startActivity(it6);
                        break;
                    case (7):
                        Intent it7=new Intent(getActivity(),PersonalFragment.class);
                        getActivity().startActivity(it7);
                        break;
                    case (8):
                        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                        builder.setTitle("确定清除缓存？");
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        builder.setNegativeButton("取消",null);
                        builder.show();

                        break;
                    default:
                        break;
                }
            }
        });
        return  view;

    }
}

package com.example.a123.homelvoe;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.a123.homelvoe.fragment.HomepageFragment;
import com.example.a123.homelvoe.fragment.PersonalFragment;
import com.example.a123.homelvoe.fragment.ReleaseFragment;

public class MainActivity extends FragmentActivity {
    FragmentManager fm;
    public void myclick(View view){
        switch (view.getId()){
            case R.id.main_bant1: {
                fm=getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.fragmnet_bant, new HomepageFragment());
                ft.commit();
            }
                break;
            case R.id.main_bant2:{
                fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.add(R.id.fragmnet_bant,new ReleaseFragment());
                ft.commit();}
                break;
            case R.id.main_bant3: {
                fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.add(R.id.fragmnet_bant,new PersonalFragment());
                ft.commit();
            }
                break;
        }

    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.fragmnet_bant,new HomepageFragment());
        ft.commit();


    }



}

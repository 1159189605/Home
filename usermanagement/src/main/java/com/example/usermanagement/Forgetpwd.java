package com.example.usermanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by andfoot on 2016/8/9.
 */
public class Forgetpwd extends Activity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgetpwd_layout);

        //按钮点击跳转
        ImageView i1 = (ImageView) findViewById(R.id.forgetpwd_return_btn);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent();
                it.setClass(Forgetpwd.this, MainActivity.class);
                //刷新
                it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(it, 1000);
            }
        });
    }
}

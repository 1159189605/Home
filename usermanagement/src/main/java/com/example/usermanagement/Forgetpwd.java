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

        final ImageView i1=(ImageView) findViewById(R.id.forgetpwd_return_btn);

        View.OnClickListener clickListener=new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                final Intent it = new Intent();

                i1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        it.setClass(Forgetpwd.this,MainActivity.class);
                    }
                });
                startActivity(it);
            }

        };
        i1.setOnClickListener(clickListener);
    }
}

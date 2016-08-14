package com.example.usermanagement;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usermanagement.database.UserSQL;

import org.xutils.x;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_usermanage);

        TextView t1=(TextView) findViewById(R.id.user_login_btn);
        TextView t2=(TextView) findViewById(R.id.forgetpwd_btn);
        Button b1=(Button) findViewById(R.id.go_btn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText b2=(EditText) findViewById(R.id.m_account_btn);
                EditText b3=(EditText)findViewById(R.id.m_pwd_btn);

                String m_account_c=b2.getText().toString();
                String m_pwd_c=b3.getText().toString();
                boolean c=new UserSQL(MainActivity.this).hasUser(m_account_c,MainActivity.this);
                Log.e("TAG","是否有账号?"+c);
                if (c==true){
                    boolean p=new UserSQL(MainActivity.this).user_tf(m_account_c,m_pwd_c);
                    Log.e("TAG","帐号密码是否正确？"+p);
                    if (p==true){
                        onBack();
                    }else {
                        Toast.makeText(MainActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "该用户未注册", Toast.LENGTH_SHORT).show();
                }
            }
        });


        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
                it.setClass(MainActivity.this, User_Login.class);
                startActivity(it);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent();
                it.setClass(MainActivity.this, Forgetpwd.class);
                startActivity(it);
            }
        });

        //按钮点击跳转
        final ImageView i1=(ImageView) findViewById(R.id.main_usermanage_btn);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBack();
            }
        });



    }

    //手动调用back方法
    public void onBack(){
        new Thread(){
            public void run() {
                try{
                    Instrumentation inst = new Instrumentation();
                    inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                }
                catch (Exception e) {
                    Log.e("Exception when onBack", e.toString());
                }
            }
        }.start();
    }
}

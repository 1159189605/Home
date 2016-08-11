package com.example.usermanagement;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;




/**
 * Created by andfoot on 2016/8/9.
 */
public class User_Login extends Activity{

    EditText phone_et;
    Button send_code_c;


    //按钮点击之后的显示Handler
    Handler timeHandler=new Handler(){


        public void handleMessage(Message msg){
            if ((int)msg.obj == 0){
                send_code_c.setText("重新获取");
                send_code_c.setEnabled(true);
            }else{
                send_code_c.setText(msg.obj+",秒后重新获取");
            }
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login_layout);

        //按钮点击获取验证码
        send_code_c=(Button) findViewById(R.id.send_code_btn);
        phone_et=(EditText) findViewById(R.id.phone_btn);

        send_code_c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //判断手机号码是否合法
                String phone_text = phone_et.getText().toString();
                //使用正则表达式
                if (!phone_text.matches("^[1][0-9]{10}$")){
                    Toast.makeText(User_Login.this, "手机号码不合法", Toast.LENGTH_SHORT).show();
                    return;
                }

                //禁用按钮
                send_code_c.setEnabled(false);
                //倒数30s
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i=30;i>=0;i--){
                            Message msg =    timeHandler.obtainMessage();
                            msg.obj = i;
                            timeHandler.sendMessage(msg);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();

                RequestParams rp=new RequestParams("http://123.206.87.139/LoveHomeTownServer/scanCode?phone="+phone_text);
                Log.e("TAG","Code_URL:"+rp);

                x.http().get(rp, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Toast.makeText(User_Login.this, "验证码发送成功", Toast.LENGTH_SHORT).show();
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
        });

        //点击注册按钮核对验证码并注册用户信息






        //按钮点击跳转
        ImageView i1=(ImageView) findViewById(R.id.user_login_return_btn);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent();
                it.setClass(User_Login.this, MainActivity.class);
                //刷新
                it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(it,1000);
            }
        });
    }


}

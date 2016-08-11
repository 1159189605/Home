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

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;




/**
 * Created by andfoot on 2016/8/9.
 */
public class User_Login extends Activity{

    EditText acount_et;
    EditText pwd_et;
    EditText pwd_again_et;
    EditText code_et;
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
        Button login_btn_c=(Button) findViewById(R.id.login_btn);


        login_btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //验证码
                code_et=(EditText) findViewById(R.id.code_btn);
                final String code_text=code_et.getText().toString();
                //用户帐号
                acount_et=(EditText)findViewById(R.id.user_acount_btn);
                String aount_text=acount_et.getText().toString();
                //用户密码
                pwd_et=(EditText)findViewById(R.id.user_pwd_btn);
                final String pwd_text=pwd_et.getText().toString();
                //确认密码
                pwd_again_et=(EditText)findViewById(R.id.pwd_again_btn);
                final String pwd_again_text=pwd_again_et.getText().toString();
                //电话号码
                final String phone_text_zc=phone_et.getText().toString();

                //判断1   验证码是否正确
                RequestParams rp_yzm=new RequestParams("http://123.206.87.139/LoveHomeTownServer/checkCode?code="+code_text);

                //JSON解析
                x.http().get(rp_yzm, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.v("TAG",result);
                        try {
                            JSONObject data=new JSONObject(result);
                            String msg=data.getString("msg");
                            Log.v("TAG","msg:"+msg);

                            if (msg.equals("success")){
                                Log.e("TAG","判断1");
                                //判断2   两次密码输入是否一致
                                if (pwd_text.equals(pwd_again_text)){
                                    RequestParams rp_zc=new RequestParams("http://123.206.87.139/LoveHomeTownServer/registerUser"+"?phone="+phone_text_zc+"?pwd="+pwd_text+"?code="+code_text);
                                    Log.e("TAG","Login_URL:"+rp_zc);

                                    Intent zc_it=new Intent();
                                    zc_it.setClass(User_Login.this,MainActivity.class);
                                    zc_it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(zc_it);

                                    Toast.makeText(User_Login.this, "注册成功", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(User_Login.this, "密码输入不一致", Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(User_Login.this, "验证码输入错误", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
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

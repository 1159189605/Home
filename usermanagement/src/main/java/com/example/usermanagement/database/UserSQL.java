package com.example.usermanagement.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

/**
 * Created by andfoot on 2016/8/13.
 */
public class UserSQL {
    SQLiteDatabase db;

    public UserSQL(Context context){
        CreatSQL creatSQL=new CreatSQL(context);
        db=creatSQL.getReadableDatabase();
    }

    //添加账户
    public String addUser(String user_account,String user_pwd,String user_phone,Context context){
        if (hasUser(user_account,context)){
            Toast.makeText(context, "该用户已存在", Toast.LENGTH_SHORT).show();
            return null;
        }
        String sql="insert into user_tb (user_account,user_pwd,user_phone) values (?,?,?)";
        db.execSQL(sql,new String[]{user_account});
        return "666";
    }


    //判断账号是否存在
    public boolean hasUser(String user_account,Context context){
        boolean flag=false;
        String sql="select * from user_tb where user_account=?";
        Cursor c=db.rawQuery(sql,new String[]{user_account});
        flag=c.moveToFirst();
        return flag;
    }

    //判断账号密码是否正确
    public boolean user_tf(String user_account,String user_pwd) {
        boolean flag=false;
        String sql1="select * from user_tb where user_account=? and user_pwd=?";
        Cursor c=db.rawQuery(sql1,new String[]{user_account,user_pwd});
        flag=c.moveToFirst();
        return flag;
    }

    //更新登录信息
    public void login(boolean zhuangtai,String user_account){
        String sql;
        if (zhuangtai){
            sql = "update user_tb set user_submit=1 where user_account=?";
        }else {
            sql = "update user_tb set user_submit=0 where user_account=?";
        }
        Cursor c = db.rawQuery(sql , new String[]{user_account});
    }


    //判断是否为登录状态
    public boolean loginInfo(String user_account){
        boolean flat=false;
        String sql = "select * from user_tb where user_account = ?";
        Cursor c = db.rawQuery(sql , new String[]{user_account});
        if (c==null){
            return  flat;
        }
        while (c.moveToNext()){
            int f=c.getInt(6);
            if (f==1){
                flat=true;
            }
        }
        return flat;
    }
}

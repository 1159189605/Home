package com.example.usermanagement.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by andfoot on 2016/8/12.
 */
public class CreatSQL extends SQLiteOpenHelper{
    public CreatSQL(Context context) {
        super(context, "lovemyhome.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="create table user_tb(" +
                "_id integer primary key autoincrement," +
                "user_account varchar(20)," +
                "user_pwd varchar(6)," +
                "user_phone varchar(11)," +
                "user_submit integer)";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

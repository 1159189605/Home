package com.example.personalmanagement;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * Created by Administrator on 2016/8/9.
 */

public class UsertActivity extends Activity {
    private ImageButton setBtn;
    private ImageView imge;
    private ListView mylistv;
    String[] msgs = {"用户名称", "联系方式", "联系地址"};

    private GoogleApiClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        setBtn = (ImageButton) findViewById(R.id.set_btn);
        imge = (ImageView) findViewById(R.id.imge);
        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = LayoutInflater.from(UsertActivity.this).inflate(R.layout.popupwindow, null);
                final PopupWindow pop = new PopupWindow(v, 500, 500);
                pop.setFocusable(true);
                pop.showAsDropDown(setBtn, 10, 0);
                v.findViewById(R.id.pop).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent it1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(it1, 1000);
                        pop.dismiss();
                    }
                });
                v.findViewById(R.id.pop1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent it2=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(it2,1001);
                        pop.dismiss();
                    }
                });
                v.findViewById(R.id.pop2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pop.dismiss();
                    }
                });
            }
        });

        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(new BaseAdapter() {
            @Override
            public View getView(int i, View convertView, ViewGroup viewGroup) {
                convertView = LayoutInflater.from(UsertActivity.this).inflate(R.layout.listview, null);
                ((TextView) convertView.findViewById(R.id.text)).setText(msgs[i]);
                return convertView;
            }

            @Override
            public long getItemId(int i) {
                // TODO Auto-generated method stub
                return i;
            }

            @Override
            public Object getItem(int i) {
                // TODO Auto-generated method stub
                return msgs[i];
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return msgs.length;
            }
        });
        return;
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_OK) {
            if (requestCode == 1000) {
          Bundle b=data.getExtras();
                Bitmap bm= (Bitmap) b.get("data");
                imge.setImageBitmap(bm);
                saveImg(bm);
            }else if (requestCode==1001){
                Uri uri=data.getData();
                //查询列：图片路径
                String[]pro={MediaStore.Images.Media.DATA};
               Cursor c=getContentResolver().query(uri,pro,null,null,null);
                c.moveToFirst();
                String path=c.getString(0);
               Bitmap bm= BitmapFactory.decodeFile(path);
                imge.setImageBitmap(bm);
            }
        }
    }

    private void saveImg(Bitmap bitmap) {
        String root = Environment.getExternalStorageDirectory() + "http_img";
        try {
            File saveFile = new File(root);
            if (!saveFile.exists()) {
                saveFile.mkdir();
            }
            String path = root +"/"+ UUID.randomUUID()+ ".jpg";
            FileOutputStream fos = new FileOutputStream(path);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


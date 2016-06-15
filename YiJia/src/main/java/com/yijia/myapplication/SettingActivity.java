package com.yijia.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SettingActivity extends AppCompatActivity {
    LinearLayout personalData,share,wehcatcode,aboutus,cleancache;
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        initViews();
        initListeners();
    }

    private void initViews() {
        mButton= (Button) findViewById(R.id.exit);
        personalData= (LinearLayout) findViewById(R.id.wodeziliao);
        share= (LinearLayout) findViewById(R.id.myshare);
        wehcatcode= (LinearLayout) findViewById(R.id.wechatcode);
        aboutus= (LinearLayout) findViewById(R.id.aboutus);
        cleancache= (LinearLayout) findViewById(R.id.cleancache);
    }

    private void initListeners() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(SettingActivity.this);
                builder.setMessage("确认退出？");
                builder.setTitle("提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent intent=new Intent(SettingActivity.this,LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();



            }
        });
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this,AboutUsActivity.class);
                startActivity(intent);

            }
        });
        wehcatcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showwechatview();
            }
        });
        personalData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this,PersonalInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void showwechatview() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        ImageView imageView=new ImageView(this);
        imageView.setImageResource(R.drawable.wechatcode);
        builder.setTitle("微信二维码")
                .setView(imageView)
                .show();
    }

    public void backme(View view) {
        finish();
    }
}

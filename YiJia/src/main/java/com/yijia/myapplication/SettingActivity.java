package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class SettingActivity extends AppCompatActivity {
LinearLayout personalData,share,wehcatcode,aboutus,cleancache;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        initViews();
        initListeners();
    }

    private void initViews() {
        personalData= (LinearLayout) findViewById(R.id.wodeziliao);
        share= (LinearLayout) findViewById(R.id.myshare);
        wehcatcode= (LinearLayout) findViewById(R.id.wechatcode);
        aboutus= (LinearLayout) findViewById(R.id.aboutus);
        cleancache= (LinearLayout) findViewById(R.id.cleancache);
    }

    private void initListeners() {
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

            }
        });
        personalData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this,PersonalInformationActivity.class);
                startActivity(intent);
            }
        });
    }


}

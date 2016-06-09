package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class CompanyDetailActivity extends AppCompatActivity {
LinearLayout company_design;
    LinearLayout company_infomation;
    LinearLayout company_certify;
    LinearLayout company_registinfo;
    Button applyfreedesign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_detail);
        initViews();
        initListener();
    }


    private void initViews() {
        company_design= (LinearLayout) findViewById(R.id.company_design);
        company_infomation= (LinearLayout) findViewById(R.id.company_infomation);
        company_certify= (LinearLayout) findViewById(R.id.company_certify);
        company_registinfo= (LinearLayout) findViewById(R.id.company_registinfo);
        applyfreedesign= (Button) findViewById(R.id.applyfreedesign);
    }

    private void initListener() {
        company_design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CompanyDetailActivity.this,CompanyDesignActivity.class);
                startActivity(intent);
            }
        });
        company_infomation.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(CompanyDetailActivity.this,CompaninfoActivity.class);
               startActivity(intent);
           }
       });
        company_certify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CompanyDetailActivity.this,CompanyCertifyActivity.class);
                startActivity(intent);
            }
        });
        company_registinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CompanyDetailActivity.this,CompanyRegistinfo.class);
                startActivity(intent);
            }
        });
        applyfreedesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CompanyDetailActivity.this,DesignApplyActivity.class);
                startActivity(intent);
            }
        });
    }
    public void back(View view) {
        finish();
    }
}

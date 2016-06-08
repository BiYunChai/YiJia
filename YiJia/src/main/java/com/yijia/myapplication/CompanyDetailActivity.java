package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class CompanyDetailActivity extends AppCompatActivity {
LinearLayout company_design;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_detail);
        initViews();
        initListener();
    }


    private void initViews() {
        company_design= (LinearLayout) findViewById(R.id.company_design);
    }

    private void initListener() {
        company_design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CompanyDetailActivity.this,CompanyDesignActivity.class);
                startActivity(intent);
            }
        });

    }
    public void back(View view) {
        finish();
    }
}

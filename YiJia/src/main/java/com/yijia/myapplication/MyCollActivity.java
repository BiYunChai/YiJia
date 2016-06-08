package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MyCollActivity extends AppCompatActivity {
    LinearLayout collteam;
    LinearLayout collstyle;
    LinearLayout collmaterial;
    LinearLayout colllike;
    LinearLayout collpost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycoll);
        initViews();
        initListeners();
    }
    private void initViews() {
        collteam= (LinearLayout) findViewById(R.id.storeteam);
        collstyle= (LinearLayout) findViewById(R.id.storestyle);
        collmaterial= (LinearLayout) findViewById(R.id.storematerial);
        colllike= (LinearLayout) findViewById(R.id.storelike);
        collpost= (LinearLayout) findViewById(R.id.storepost);
    }
    private void initListeners() {
        collteam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyCollActivity.this,CollTeamActivity.class);
                startActivity(intent);
            }
        });

        collstyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyCollActivity.this,CollStyleActivity.class);
                startActivity(intent);
            }
        });
        collmaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyCollActivity.this,CollMaterialActivity.class);
                startActivity(intent);
            }
        });
        colllike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyCollActivity.this,CollRecommentActivity.class);
                startActivity(intent);
            }
        });

        collpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyCollActivity.this,CollPostActivity.class);
                startActivity(intent);
            }
        });
    }

    public void backme(View view) {
        finish();
    }
}

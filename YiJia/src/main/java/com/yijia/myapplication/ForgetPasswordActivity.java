package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ForgetPasswordActivity extends AppCompatActivity {
    ImageView back;
    Button certain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);
        initViews();
        initListener();
    }
    private void initViews() {
        back= (ImageView) findViewById(R.id.back);
        certain= (Button) findViewById(R.id.certain);
    }
    private void initListener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ForgetPasswordActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        certain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ForgetPasswordActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}

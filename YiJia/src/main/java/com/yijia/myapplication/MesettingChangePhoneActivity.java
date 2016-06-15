package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MesettingChangePhoneActivity extends AppCompatActivity {
    EditText mEditText;
    Button msavephoneButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesetting_change_phone);

        initView();
        initoriginData();
        initListener();
    }


    private void initView() {
        mEditText= (EditText) findViewById(R.id.me_changephone_edit);
        msavephoneButton= (Button) findViewById(R.id.savephone);
    }

    private void initoriginData() {
        Intent intent=getIntent();
        String phone=intent.getStringExtra("phone");
        mEditText.setText(phone);
    }
    private void initListener() {
        msavephoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void back(View view) {
        finish();
    }
}

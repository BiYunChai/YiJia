package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MesettingChangePhoneActivity extends AppCompatActivity {
    EditText mEditText;
    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesetting_change_phone);
        Intent intent=getIntent();
        phone=intent.getStringExtra("phone");
        initView();
    }

    private void initView() {
        mEditText= (EditText) findViewById(R.id.me_changephone_edit);
        mEditText.setText(phone);
    }

    public void back(View view) {
        finish();
    }
}

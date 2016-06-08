package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MesettingChangeaddressActivity extends AppCompatActivity {
    EditText mEditText;
    String address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesetting_changeaddress);
        Intent intent=getIntent();
        address=intent.getStringExtra("address");
        initView();
    }

    private void initView() {
        mEditText= (EditText) findViewById(R.id.me_changeaddress_edit);
        mEditText.setText(address);
    }

    public void back(View view) {
        finish();
    }
}

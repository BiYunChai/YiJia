package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ChangeMesettingEmailActivity extends AppCompatActivity {
    EditText mEditText;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_mesetting_email);
        Intent intent=getIntent();
        email=intent.getStringExtra("email");
        initView();
    }

    private void initView() {
        mEditText= (EditText) findViewById(R.id.me_changeemail_edit);
        mEditText.setText(email);
    }

    public void back(View view) {
        finish();
    }
}

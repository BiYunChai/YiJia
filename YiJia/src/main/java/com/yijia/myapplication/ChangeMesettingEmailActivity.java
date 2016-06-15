package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChangeMesettingEmailActivity extends AppCompatActivity {
    EditText mEditText;
    Button msaveemailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_mesetting_email);
        initView();
        initoriginData();
        initListener();
    }
    private void initView() {
        mEditText= (EditText) findViewById(R.id.me_changeemail_edit);
        msaveemailButton= (Button) findViewById(R.id.saveemail);
    }

    private void initoriginData() {
        Intent intent=getIntent();
        String email=intent.getStringExtra("email");
        mEditText.setText(email);
    }


    private void initListener() {
        msaveemailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void back(View view) {
        finish();
    }
}

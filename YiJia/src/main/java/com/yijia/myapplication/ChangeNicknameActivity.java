package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ChangeNicknameActivity extends AppCompatActivity {
EditText mEditText;
    String nick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_nickname);
        Intent intent=getIntent();
       nick=intent.getStringExtra("nick");
        initView();
    }

    private void initView() {
        mEditText= (EditText) findViewById(R.id.me_changenickname_edit);
        mEditText.setText(nick);

    }

    public void back(View view) {
        finish();
    }
}

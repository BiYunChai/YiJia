package com.yijia.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangeNicknameActivity extends AppCompatActivity {
     EditText mEditText;
    Button mSavenicknameButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_nickname);
        initView();
        initoriginData();
        initListener();
    }

    private void initView() {
        mEditText= (EditText) findViewById(R.id.me_changenickname_edit);
        mSavenicknameButton= (Button) findViewById(R.id.savenickname);

    }

    private void initoriginData() {
        Intent intent=getIntent();
        String nickname=intent.getStringExtra("nickname");
        mEditText.setText(nickname);
    }
    private void initListener() {
        mSavenicknameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  AlertDialog.Builder builder=new AlertDialog.Builder(ChangeNicknameActivity.this);
                builder.setMessage("修改昵称成功").create().show();*/
            }
        });
    }

    public void back(View view) {
        finish();
    }
}

package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MesettingChangeaddressActivity extends AppCompatActivity {
    EditText mEditText;
    Button msaveaddressButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesetting_changeaddress);
        initView();
        initoriginData();
      //  initListener();
    }



    private void initoriginData() {
        Intent intent=getIntent();
        String address=intent.getStringExtra("adddetail");
        mEditText.setText(address);
    }

    private void initView() {
        mEditText= (EditText) findViewById(R.id.me_changeaddress_edit);
        msaveaddressButton= (Button) findViewById(R.id.saveemail);
    }

/*    private void initListener() {
        msaveaddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }*/
    public void back(View view) {
        finish();
    }
}

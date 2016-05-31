package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Cal_dzActivity extends AppCompatActivity {
    EditText mHouseLenth;
    EditText mHouseWidth;
    EditText mDZLenth;
    EditText mDZWidth;
    EditText mPerPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_dz);
        initview();

    }

    private void initview() {
        mDZLenth= (EditText) findViewById(R.id.dz_lenth);
        mDZWidth= (EditText) findViewById(R.id.dz_width);
        mPerPrice= (EditText) findViewById(R.id.dz_perprice);
        mHouseLenth= (EditText) findViewById(R.id.house_length);
        mHouseWidth= (EditText) findViewById(R.id.house_width);
    }



    public void count(View view) {
        String lenth=mHouseLenth.getText().toString();
        String width=mHouseWidth.getText().toString();
        String dz_lenth=mDZLenth.getText().toString();
        String dz_width=mDZWidth.getText().toString();
        String dz_perprice=mPerPrice.getText().toString();
        Log.e("获取房间长度",lenth);


        Intent intent=new Intent(Cal_dzActivity.this, Cal_dzdetailActivity.class);

        intent.putExtra("lenth",lenth);
        intent.putExtra("width",width);
        intent.putExtra("dz_lenth",dz_lenth);
        intent.putExtra("dz_width",dz_width);
        intent.putExtra("dz_perprice",dz_perprice);
        //Binder binder=new Binder();

        startActivity(intent);

    }

    public void backcalcuator(View view) {
        finish();
    }
}

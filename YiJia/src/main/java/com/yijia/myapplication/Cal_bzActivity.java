package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Cal_bzActivity extends AppCompatActivity {
    EditText mHouseLenth;
    EditText mHouseWidth;
    EditText mHouseHeight;
    EditText mBZFormat;
    EditText mPerPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_bz);
        initview();
    }
    private void initview() {
        mHouseHeight= (EditText) findViewById(R.id.house_height);
        mBZFormat= (EditText) findViewById(R.id.bz_format);
        mPerPrice= (EditText) findViewById(R.id.bz_perprice);
        mHouseLenth= (EditText) findViewById(R.id.bz_house_length);
        mHouseWidth= (EditText) findViewById(R.id.bz_house_width);
    }
    public void bz_count(View view) {
        String lenth=mHouseLenth.getText().toString();
        String width=mHouseWidth.getText().toString();
        String height=mHouseHeight.getText().toString();
        String bz_format=mBZFormat.getText().toString();
        String bz_perprice=mPerPrice.getText().toString();
        Log.e("获取房间长度",lenth);


        Intent intent=new Intent(Cal_bzActivity.this, Cal_bzdetailActivity.class);

        intent.putExtra("lenth",lenth);
        intent.putExtra("width",width);
        intent.putExtra("height",height);
        intent.putExtra("bz_format",bz_format);
        intent.putExtra("bz_perprice",bz_perprice);
        //Binder binder=new Binder();

        startActivity(intent);

    }

    public void backcalcuator(View view) {
        finish();
    }
}

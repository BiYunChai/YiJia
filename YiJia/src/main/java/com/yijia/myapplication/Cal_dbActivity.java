package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Cal_dbActivity extends AppCompatActivity {
    EditText mHouseLenth;
    EditText mHouseWidth;
    EditText mDBLenth;
    EditText mDBWidth;
    EditText mPerPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_db);
        initview();
    }

    private void initview() {
        mDBLenth= (EditText) findViewById(R.id.db_lenth);
        mDBWidth= (EditText) findViewById(R.id.db_width);
        mPerPrice= (EditText) findViewById(R.id.db_perprice);
        mHouseLenth= (EditText) findViewById(R.id.db_house_length);
        mHouseWidth= (EditText) findViewById(R.id.db_house_width);
    }

    public void db_count(View view) {
        String lenth=mHouseLenth.getText().toString();
        String width=mHouseWidth.getText().toString();
        String db_lenth=mDBLenth.getText().toString();
        String db_width=mDBWidth.getText().toString();
        String db_perprice=mPerPrice.getText().toString();
        Log.e("获取房间长度",lenth);


        Intent intent=new Intent(Cal_dbActivity.this, Cal_dbdetailActivity.class);

        intent.putExtra("lenth",lenth);
        intent.putExtra("width",width);
        intent.putExtra("db_lenth",db_lenth);
        intent.putExtra("db_width",db_width);
        intent.putExtra("db_perprice",db_perprice);

        startActivity(intent);

    }

    public void backcalcuator(View view) {
        finish();
    }
}

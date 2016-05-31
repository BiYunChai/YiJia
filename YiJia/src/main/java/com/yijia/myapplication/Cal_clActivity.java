package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Cal_clActivity extends AppCompatActivity {

    EditText mWindowWidth;

    EditText mClothPerprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_cl);
        initview();
    }
    private void initview() {
        mWindowWidth= (EditText) findViewById(R.id.window_width);
        mClothPerprice= (EditText) findViewById(R.id.cloth_perprice);

    }
    public void cl_count(View view) {
        String lenth=mWindowWidth.getText().toString();
        String width=mClothPerprice.getText().toString();




        Intent intent=new Intent(Cal_clActivity.this, Cal_cldetailActivity.class);

        intent.putExtra("windowwidth",lenth);
        intent.putExtra("clothwidth",width);


        startActivity(intent);

    }
    public void backcalcuator(View view) {
        finish();
    }


}

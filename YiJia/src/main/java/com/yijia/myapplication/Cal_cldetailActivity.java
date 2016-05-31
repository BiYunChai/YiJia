package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Cal_cldetailActivity extends AppCompatActivity {
    //默认比例
    private static final int SCALE = 2;
    TextView mPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_cldetail);
        mPriceTextView= (TextView) findViewById(R.id.priceresult);
        Intent intent=getIntent();

        String winwidth=intent.getStringExtra("windowwidth");
        float win_width=Float.parseFloat(winwidth);

        String cloperprice=intent.getStringExtra("clothwidth");
        float clo_perprice=Float.parseFloat(cloperprice);
        
        float res=win_width*clo_perprice* SCALE;

        DecimalFormat fnum = new DecimalFormat("##0.00");
        String result_pri=fnum.format(res);

        mPriceTextView.setText(result_pri+"元");

    }
    public void backcalcuator(View view) {
        finish();
    }
}

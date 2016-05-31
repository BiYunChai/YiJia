package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Cal_bzdetailActivity extends AppCompatActivity {
    private static final int INT = 2;
    TextView mNumTextView;
    TextView mPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_bzdetail);
        Intent intent=getIntent();

        String lenth=intent.getStringExtra("lenth");
        float l=Float.parseFloat(lenth);

        String width=intent.getStringExtra("width");
        float w=Float.parseFloat(width);

        String height=intent.getStringExtra("height");
        float h=Float.parseFloat(height);

        String bz_format=intent.getStringExtra("bz_format");
        float b_format=Float.parseFloat(bz_format);

        String b_perprice=intent.getStringExtra("bz_perprice");
        float b_p=Float.parseFloat(b_perprice);

        //计算
        //所需数量
        float num=((h*w+h*l)* INT) /b_format;

        //总价格
        float res=num*b_p;
        //四舍五入转化为两位

        DecimalFormat fnum = new DecimalFormat("##0.00");
        String result_pri=fnum.format(res);
        String result_num=fnum.format(num);

        mNumTextView= (TextView) findViewById(R.id.bz_numresult);
        mPriceTextView= (TextView) findViewById(R.id.bz_priceresult);

        mNumTextView.setText(result_num+"卷");
        mPriceTextView.setText(result_pri+"元");
        Log.e("数量",result_num);
        Log.e("价格",result_pri);
    }
    public void backcalcuator(View view) {
        finish();
    }
}

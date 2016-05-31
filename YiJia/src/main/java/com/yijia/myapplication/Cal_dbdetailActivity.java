package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Cal_dbdetailActivity extends AppCompatActivity {
    private static final int CHANGE = 1000000;
    TextView mNumTextView;
    TextView mPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_dbdetail);

        Intent intent=getIntent();
        //获取值
        String lenth=intent.getStringExtra("lenth");
        float l=Float.parseFloat(lenth);

        String width=intent.getStringExtra("width");
        float w=Float.parseFloat(width);

        String z_lenth=intent.getStringExtra("db_lenth");
        float z_l=Float.parseFloat(z_lenth);

        String z_width=intent.getStringExtra("db_width");
        float z_w=Float.parseFloat(z_width);

        String z_perprice=intent.getStringExtra("db_perprice");
        float z_p=Float.parseFloat(z_perprice);
        //计算
        //所需数量
        float num=((l*w* CHANGE)/(z_l*z_w));
        //总价格
        float res=num*z_p;
        //四舍五入转化为两位

        DecimalFormat fnum = new DecimalFormat("##0.00");
        String result_pri=fnum.format(res);
        String result_num=fnum.format(num);

        mNumTextView= (TextView) findViewById(R.id.numresult);
        mPriceTextView= (TextView) findViewById(R.id.priceresult);

        mNumTextView.setText(result_num+"块");
        mPriceTextView.setText(result_pri+"元");
        Log.e("数量",result_num);
        Log.e("价格",result_pri);
    }
    public void backcalcuator(View view) {
        finish();
    }
}

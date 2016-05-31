package com.yijia.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Cal_dzdetailActivity extends AppCompatActivity {

    private static final int CHANGE = 1000000;
    TextView mNumTextView;
    TextView mPriceTextView;
    ImageView mBackImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_dzdetail);
        Intent intent=getIntent();
        mBackImg= (ImageView) findViewById(R.id.back);
        //获取值
        String lenth=intent.getStringExtra("lenth");
        float l=Float.parseFloat(lenth);

        String width=intent.getStringExtra("width");
        float w=Float.parseFloat(width);

        String z_lenth=intent.getStringExtra("dz_lenth");
        float z_l=Float.parseFloat(z_lenth);

        String z_width=intent.getStringExtra("dz_width");
        float z_w=Float.parseFloat(z_width);

        String z_perprice=intent.getStringExtra("dz_perprice");
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

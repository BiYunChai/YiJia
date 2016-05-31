package com.yijia.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class CalcuatorActivity extends AppCompatActivity {
    ImageView mBackImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcuator);
        initview();

    }



    private void initview() {
        mBackImg= (ImageView) findViewById(R.id.back);

    }


    public void backhome(View view) {

        finish();
    }

    public void dz_dedatil(View view) {
        Intent intent=new Intent(CalcuatorActivity.this, Cal_dzActivity.class);
        startActivity(intent);

    }

    public void db_detail(View view) {
        Intent intent=new Intent(CalcuatorActivity.this, Cal_dbActivity.class);
        startActivity(intent);
    }
    public void cl_detail(View view) {
        Intent intent=new Intent(CalcuatorActivity.this, Cal_clActivity.class);
        startActivity(intent);
    }
    public void bz_detail(View view) {
        Intent intent=new Intent(CalcuatorActivity.this, Cal_bzActivity.class);
        startActivity(intent);
    }
}


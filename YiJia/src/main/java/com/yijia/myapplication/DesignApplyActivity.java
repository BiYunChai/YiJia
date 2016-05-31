package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.yijia.fragment.HomeFragment;

public class DesignApplyActivity extends AppCompatActivity {
    ImageView mBackImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_apply);
        initview();
        initData();
    }



    private void initview() {
        mBackImg= (ImageView) findViewById(R.id.back);
    }
    private void initData() {
    }

    public void backhome(View view) {
        /*Intent intent=new Intent(DesignApplyActivity.this, HomeFragment.class);
        startActivity(intent);*/
        finish();
    }
}

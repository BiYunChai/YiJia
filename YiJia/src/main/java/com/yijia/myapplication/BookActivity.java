package com.yijia.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class BookActivity extends AppCompatActivity {
    ImageView mBackImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book);
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

package com.yijia.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BuildStageRatingActivity extends AppCompatActivity {
Button compaintbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_stage_rating);
       compaintbtn= (Button) findViewById(R.id.compaint);
        initListener();
    }

    private void initListener() {
        compaintbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BuildStageRatingActivity.this, "评论成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

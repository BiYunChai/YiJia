package com.yijia.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuildStageRatingActivity extends AppCompatActivity {
     Button compaintbtn;
     EditText designscoreText;
     EditText writecontentText;
     EditText serviceText;
     EditText jobText;
     TextView averageText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_stage_rating);

        initview();
        initListener();
    }

    private void initview() {
        compaintbtn= (Button) findViewById(R.id.compaint);
        designscoreText= (EditText) findViewById(R.id.designscore);
        writecontentText= (EditText) findViewById(R.id.writecontent);
        serviceText= (EditText) findViewById(R.id.servicescore);
        jobText= (EditText) findViewById(R.id.jobscore);
        averageText= (TextView) findViewById(R.id.averagescore);
    }

    private void initListener() {
        compaintbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=writecontentText.getText().toString();
                Float design=Float.parseFloat(designscoreText.getText().toString());
                Float service=Float.parseFloat(serviceText.getText().toString());
                Float job=Float.parseFloat(jobText.getText().toString());
                Float score=(design+service+job)/3;
                averageText.setText(score+"");
                Log.e("score",averageText.getText().toString());
                Toast.makeText(BuildStageRatingActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

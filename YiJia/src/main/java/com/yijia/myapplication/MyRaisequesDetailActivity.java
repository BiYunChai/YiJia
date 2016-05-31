package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;

import com.yijia.beans.MyQuesDetailData;


public class MyRaisequesDetailActivity extends AppCompatActivity {
   /* ImageView mImageViewuser;
    TextView mTextViewusername;
    TextView mTextViewdate;
    TextView mTextViewquescontent;
    ImageView mImageViewpic;
    ImageView mImageViewzan;
    ImageView mImageViewcomment;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.raiseques_detail);
        Toast.makeText(MyRaisequesDetailActivity.this, "这是我提出的问题详情页", Toast.LENGTH_SHORT).show();
       /* initView();
        Intent intent=getIntent();
        MyQuesDetailData myQuesDetailData= (MyQuesDetailData) intent.getSerializableExtra("myquesdetail");
        int userpic=myQuesDetailData.getUserpic();
        String username=myQuesDetailData.getUsername();
        String quesdate=myQuesDetailData.getDate();
        String quescontent=myQuesDetailData.getQuescontent();
        int quespic=myQuesDetailData.getQuespic();
        int zan=myQuesDetailData.getZan();
        int comment=myQuesDetailData.getComment();
        mImageViewuser.setImageResource(userpic);
        mTextViewusername.setText(username);
         mTextViewdate.setText(quesdate);
        mTextViewquescontent.setText(quescontent);
        mImageViewpic.setImageResource(quespic);
         mImageViewzan.setImageResource(zan);
         mImageViewcomment.setImageResource(comment);*/

    }

   /* private void initView() {
        mImageViewuser= (ImageView) findViewById(R.id.userquespic);
        mTextViewusername= (TextView) findViewById(R.id.username);
        mTextViewdate= (TextView) findViewById(R.id.questiondate);
        mTextViewquescontent= (TextView) findViewById(R.id.questiontext);
        mImageViewpic= (ImageView) findViewById(R.id.questionpic);
        mImageViewzan= (ImageView) findViewById(R.id.zan);
        mImageViewcomment= (ImageView) findViewById(R.id.comment);

    }*/

}

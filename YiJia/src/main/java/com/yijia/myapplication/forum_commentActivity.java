package com.yijia.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.w4lle.library.NineGridlayout;
import com.yijia.adapter.Comment_PicAdapter;
import com.yijia.adapter.ForumDetail_list_Adapter;
import com.yijia.adapter.Post_CommentAdapter;
import com.yijia.bean.Comment;
import com.yijia.bean.Post;
import com.yijia.bean.Postimg;
import com.yijia.bean.Recommend;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class forum_commentActivity extends AppCompatActivity {
    Post post;
    LayoutInflater layoutInflater;
    ListView listview;
    List<Comment>  commentlist=new ArrayList<>();
    ImageView com_userphoto;
    TextView com_usernickname;
    TextView com_postcontent;
    TextView com_time;
    NineGridlayout com_mNineGridlayout;
    Comment_PicAdapter mComment_picAdapter;
    List<Postimg> mlistimg;
    Post_CommentAdapter mPost_commentAdapter;
    EditText mEditText;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_froum_comment);
        Intent intent=getIntent();
        String postString=intent.getStringExtra("post");
        Gson gson=new Gson();
        Type type=new TypeToken<Post>(){}.getType();
        post=gson.fromJson(postString,type);
        Log.e("cby",post.toString());


        mEditText= (EditText) findViewById(R.id.writecomment);
        mButton= (Button) findViewById(R.id.OKbtn);


        layoutInflater=LayoutInflater.from(forum_commentActivity.this);
        View view=layoutInflater.inflate(R.layout.comment_header,null);


        initview(view);
        initheaderview();
        initData();
        sendcomment();
    }


    private void initview(View view) {

        listview= (ListView) findViewById(R.id.comment_list);
        listview.addHeaderView(view);
        Log.e("hhhh","添加头布局");

    }

    private void initheaderview() {
        com_userphoto= (ImageView) findViewById(R.id.comment_header_userimg);
        com_usernickname= (TextView)findViewById(R.id.comment_header_username);
        com_postcontent= (TextView)findViewById(R.id.comment_header_content);
        com_time= (TextView)findViewById(R.id.comment_header_time);
        com_mNineGridlayout= (NineGridlayout) findViewById(R.id.comment_header_pic);

        com_usernickname.setText(post.getUasernickname());
        Log.e("hhh",post.getUasernickname());
        com_postcontent.setText(post.getContent());

        Glide.with(forum_commentActivity.this)
                .load(post.getUserphoto())
                .into(com_userphoto);
        Log.e("hhh",post.getUserphoto());
        com_time.setText(post.getDate());
        mlistimg=post.getPostimgs();
        mComment_picAdapter=new Comment_PicAdapter(forum_commentActivity.this,mlistimg);
        com_mNineGridlayout.setAdapter(mComment_picAdapter);
        Log.e("hhhh","初始化头布局");





    }


    private void initData() {

        Comment comment=new Comment(1,"张丰鸽","这几天有点背","2016-06-06");
        commentlist.add(comment);
        mPost_commentAdapter=new Post_CommentAdapter(forum_commentActivity.this,commentlist);
        listview.setAdapter(mPost_commentAdapter);
        Log.e("hhhh","初始化评论数据");


    }

    public void sendcomment() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String comment_content=mEditText.getText().toString();
                Log.e("content",comment_content);
                if(!(comment_content.equals(""))){
                  Comment comment=new Comment(2,"程明明",comment_content,"2016-06-06");
                commentlist.add(comment);
                mPost_commentAdapter.notifyDataSetChanged();
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
                mEditText.setText("");
                }
                else {
                    Toast.makeText(forum_commentActivity.this,"评论内容不能为空",Toast.LENGTH_LONG).show();
                }


            }
        });


    }

    public void backforum(View view) {
        finish();
    }
}

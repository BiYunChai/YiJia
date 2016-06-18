package com.yijia.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v4.util.LogWriter;
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
import com.yijia.adapter.ForumCommentHeader_list_Adapter;
import com.yijia.adapter.ForumDetail_list_Adapter;
import com.yijia.adapter.Post_CommentAdapter;
import com.yijia.bean.Comment;
import com.yijia.bean.Post;
import com.yijia.bean.Post_comment;
import com.yijia.bean.Postimg;
import com.yijia.bean.User;
import com.yijia.utils.HttpUrl;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class forum_commentActivity extends AppCompatActivity {
    private static final String REGISTER = "register";
    private static final String LOGIN = "login";
    Post post;
    int pid=0;
    ListView PostListView;
    LayoutInflater layoutInflater;
    ListView listview;
    String username;
    String nickname;
    List<Post_comment>  commentlist=new ArrayList<>();
    List<Post> postList=new ArrayList<>();
    ImageView com_userphoto;
    TextView com_usernickname;
    TextView com_postcontent;
    TextView com_time;
    NineGridlayout com_mNineGridlayout;
    Comment_PicAdapter mComment_picAdapter;
    ForumCommentHeader_list_Adapter mForumCommentHeader_list_adapter;
    List<Postimg> mlistimg;
    List<Post_comment> post_comments;
    Post_CommentAdapter mPost_commentAdapter;
    EditText mEditText;
    Button mButton;
    SharedPreferences mSharedPreferences;
    SharedPreferences mSharedPreferenceslogin;
    boolean isregister=false;
    boolean islogin=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_froum_comment);




        layoutInflater=LayoutInflater.from(forum_commentActivity.this);
        View view=layoutInflater.inflate(R.layout.comment_header,null);


        //接受gson数据
        initGson();
        initCommentView();
        initview(view);
        initheaderview(view);

        initPostData(post);
        initCommentsData(post_comments);


        sendcomment();
        Log.e("yun","sendcomment");
    }

   private void initCommentView() {
        listview= (ListView) findViewById(R.id.comment_list);
        mEditText= (EditText) findViewById(R.id.writecomment);
        mButton= (Button) findViewById(R.id.sendcommend);
        mSharedPreferences=getSharedPreferences(REGISTER,MODE_PRIVATE);
        mSharedPreferenceslogin=getSharedPreferences(LOGIN,MODE_PRIVATE);
        isregister=mSharedPreferences.getBoolean("isregister",false);
        islogin=mSharedPreferenceslogin.getBoolean("islogin",false);
    }

    private void initGson() {

        Intent intent=getIntent();
        String postString=intent.getStringExtra("post");
        Gson gson=new Gson();
        Type type=new TypeToken<Post>(){}.getType();
        post=gson.fromJson(postString,type);
        mlistimg=post.getPostimgs();
        Log.e("mlistimg",mlistimg.toString());
        post_comments=post.getPost_comments();
        Log.e("post_comments",post_comments.toString());
        pid=post.getPid();
        Log.e("pid",pid+"");

    }


    private void initPostData(Post post) {

        /*postList.add(post);
        postList.add(post);
        Log.e("postsize",postList.size()+"");
        mForumCommentHeader_list_adapter=new ForumCommentHeader_list_Adapter(forum_commentActivity.this,postList);
        PostListView.setAdapter(mForumCommentHeader_list_adapter);
        mForumCommentHeader_list_adapter.notifyDataSetChanged();*/
        /*ForumDetail_list_Adapter forumDetail_list_adapter=new ForumDetail_list_Adapter(forum_commentActivity.this,postList);
        PostListView.setAdapter(forumDetail_list_adapter);*/
        Log.e("yun","ok");


        com_usernickname.setText(post.getUsername());
        Log.e("cbycommentActivity",post.getUsername());
        com_postcontent.setText(post.getContent());
        Log.e("cbycommentActivity",post.getContent());

        Glide.with(forum_commentActivity.this)
                .load(post.getUserphoto())
                .into(com_userphoto);
        Log.e("cbycommentActivity",post.getUserphoto());


        mComment_picAdapter=new Comment_PicAdapter(forum_commentActivity.this,mlistimg);
        com_mNineGridlayout.setAdapter(mComment_picAdapter);
        com_time.setText(post.getDate()+"");
        Log.e("yun","ok");

    }


    private void initview(View view) {

        Log.e("cbycommentActivity","添加头布局1");
        listview.addHeaderView(view);

        Log.e("cbycommentActivity","添加头布局2");

    }

    private void initheaderview(View view) {
        com_userphoto= (ImageView)view.findViewById(R.id.comment_header_userimg);
        com_usernickname= (TextView)view.findViewById(R.id.comment_header_username);
        com_postcontent= (TextView)view.findViewById(R.id.comment_header_content);
        com_time= (TextView)view.findViewById(R.id.comment_header_time);
        com_mNineGridlayout= (NineGridlayout) view.findViewById(R.id.comment_header_pic);

      //  PostListView= (ListView) view.findViewById(R.id.Comment_postlist);


        Log.e("cbycommentActivity","初始化头布局");





    }


    private void initCommentsData(List<Post_comment> mlist) {

        for(Post_comment post_comment:mlist){
            String username=post_comment.getUsername();
            String nickname=post_comment.getComm_username();
            String content=post_comment.getComm_content();
            String date=post_comment.getDate();
            Post_comment post_comment1=new Post_comment(username,nickname,content,date);
            commentlist.add(post_comment1);

            mPost_commentAdapter=new Post_CommentAdapter(forum_commentActivity.this,commentlist);
            listview.setAdapter(mPost_commentAdapter);
            mPost_commentAdapter.notifyDataSetChanged();

        }
    }

    public void sendcomment() {

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if(islogin){
                        String comment_content=mEditText.getText().toString();
                        username=mSharedPreferenceslogin.getString("username","error");
                        nickname=mSharedPreferenceslogin.getString("nickname","error");
                        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                        String date=sDateFormat.format(new java.util.Date());
                        Log.e("content",comment_content);
                        if(comment_content.equals("")){
                            Toast.makeText(forum_commentActivity.this,"评论内容不能为空",Toast.LENGTH_SHORT).show();
                            Log.e("hhhh","评论内容不能为空");

                        }
                        else{


                            RequestParams params=new RequestParams(HttpUrl.SENDCOMMEND);
                            params.addBodyParameter("username",username);

                            params.addBodyParameter("pid",pid+"");
                            params.addBodyParameter("commend_content",comment_content);
                            params.addBodyParameter("commend_date",date+"");

                            Post_comment post_comment=new Post_comment(username,nickname,comment_content,date+"");
                            commentlist.add(post_comment);

                            x.http().post(params, new Callback.CommonCallback<String>() {
                                @Override
                                public void onSuccess(String result) {
                                    mEditText.setText("");
                                    Toast.makeText(forum_commentActivity.this,"发送成功",Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onError(Throwable ex, boolean isOnCallback) {
                                    Log.e("post",ex.getMessage());
                                    Toast.makeText(forum_commentActivity.this,"访问网络失败",Toast.LENGTH_SHORT).show();

                                }

                                @Override
                                public void onCancelled(CancelledException cex) {

                                }

                                @Override
                                public void onFinished() {

                                }
                            });



                        }
                    }else{
                        Toast.makeText(forum_commentActivity.this,"没有登录不能评论呦",Toast.LENGTH_LONG).show();
                    }




            }
        });


    }

    public void backforum(View view) {
        finish();
    }


}

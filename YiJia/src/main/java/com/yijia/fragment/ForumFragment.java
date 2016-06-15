package com.yijia.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yijia.adapter.ForumDetail_list_Adapter;
import com.yijia.bean.Post;
import com.yijia.bean.Post_comment;
import com.yijia.bean.Postimg;
import com.yijia.myapplication.R;
import com.yijia.myapplication.SendPostActivity;
import com.yijia.myapplication.forum_commentActivity;
import com.yijia.utils.HttpUrl;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/13.
 */
public class ForumFragment extends Fragment{
    List<Post> mPostList=new ArrayList<>();
    PullToRefreshListView mPullToRefreshListView;

    ForumDetail_list_Adapter mForum_Detail_list_adapter;
    ImageView mSendPost;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.forum,null);
        initView(view);
        initDate();
        initLIstener();
        mPullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),position,Toast.LENGTH_SHORT).show();
            }
        });
        return view;

    }

    @Override
    public void onResume() {
        Log.e("--yun--","进入onresume");
        super.onResume();
        RequestParams params=new RequestParams(HttpUrl.POST_SELECTALL);
        Log.e("url",HttpUrl.POST_SELECTALL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                Type type=new TypeToken<List<Post>>(){}.getType();
                List<Post> mPostList;
                mPostList=gson.fromJson(result,type);

                for(Post post:mPostList ){
                    int pid=post.getPid();
                    Log.e("lllll",pid+"");
                    String nickname=post.getUsername();
                    String userphoto=post.getUserphoto();
                    String content=post.getContent();
                    String date=post.getDate();
                    List<Postimg> imgs=post.getPostimgs();
                    List<Post_comment> comments=post.getPost_comments();

                    Post post1=new Post(pid,nickname,userphoto,content,date,imgs,comments);
                    mPostList.add(post1);
                    mForum_Detail_list_adapter = new ForumDetail_list_Adapter(getContext(), mPostList);
                    mPullToRefreshListView.setAdapter(mForum_Detail_list_adapter);
                    mForum_Detail_list_adapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {


            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });




    }

    private void initView(View view) {
       mPullToRefreshListView= (PullToRefreshListView) view.findViewById(R.id.forum_list);
        mSendPost= (ImageView) view.findViewById(R.id.sendpostimg);
    }

    private void initDate() {
        RequestParams params=new RequestParams(HttpUrl.POST_SELECTALL);
        Log.e("url",HttpUrl.POST_SELECTALL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                Type type=new TypeToken<List<Post>>(){}.getType();
                List<Post> mPostList;
                mPostList=gson.fromJson(result,type);

                for(Post post:mPostList ){
                    int pid=post.getPid();
                    String nickname=post.getUsername();
                    String userphoto=post.getUserphoto();
                    String content=post.getContent();
                    String date=post.getDate();
                    List<Postimg> imgs=post.getPostimgs();
                    List<Post_comment> comments=post.getPost_comments();

                    Post post1=new Post(pid,nickname,userphoto,content,date,imgs,comments);
                    mPostList.add(post1);
                    mForum_Detail_list_adapter = new ForumDetail_list_Adapter(getContext(), mPostList);
                    mPullToRefreshListView.setAdapter(mForum_Detail_list_adapter);
                    mForum_Detail_list_adapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {


            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });




    }
    private void initLIstener() {
        mPullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //Toast.makeText(getContext(),position,Toast.LENGTH_SHORT).show();
                        Gson gson=new Gson();
                        Post post1=mPostList.get(position);
                        String result=gson.toJson(post1);
                        Log.e("cbyfs",post1.toString());
                        Intent intent=new Intent(getActivity(),forum_commentActivity.class);
                        intent.putExtra("post",result);
                        startActivity(intent);


            }
        });

        mSendPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SendPostActivity.class);
                startActivity(intent);

            }
        });
    }



}

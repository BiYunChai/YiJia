package com.yijia.myapplication;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yijia.adapter.ForumDetail_list_Adapter;
import com.yijia.adapter.MyPostAdapter;
import com.yijia.bean.Post;
import com.yijia.bean.Post_comment;
import com.yijia.bean.Postimg;
import com.yijia.fragment.MyRaisePostFragment;
import com.yijia.fragment.MyRelyPostFragment;
import com.yijia.utils.HttpUrl;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MyPostActivity extends AppCompatActivity {
    private static final String LOGIN = "login";
    RadioGroup mRadioGrouppost;
    PullToRefreshListView mPullToRefreshListView;
    List<Fragment> mListpostFragment;
    MyRaisePostFragment mRaisePostFragment;
    MyRelyPostFragment mRelyPostFragment;
    FragmentManager mFragmentManager;
    ViewPager mViewPagerPost;
    MyPostAdapter mPostAdapter;
    SharedPreferences mSharedPreferenceslogin;
    ForumDetail_list_Adapter mForum_Detail_list_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypost);
        initViews();
        initData();
        initListener();
    }
    private void initViews() {
       /* mViewPagerPost= (ViewPager) findViewById(R.id.viewpagerpost);*/
        mRadioGrouppost= (RadioGroup) findViewById(R.id.raiseandrelypost);
        mPullToRefreshListView= (PullToRefreshListView) findViewById(R.id.mypost_list);
        mSharedPreferenceslogin=getSharedPreferences(LOGIN,MODE_PRIVATE);
    }
    private void initData() {
        /*mListpostFragment=new ArrayList<>();
        mRaisePostFragment=new MyRaisePostFragment();
        mRelyPostFragment=new MyRelyPostFragment();
        mListpostFragment.add(mRaisePostFragment);
        mListpostFragment.add(mRelyPostFragment);
        mFragmentManager=getSupportFragmentManager();
        mPostAdapter=new MyPostAdapter(mFragmentManager,mListpostFragment);
        mViewPagerPost.setAdapter(mPostAdapter);*/
        String username=mSharedPreferenceslogin.getString("username","error");
        RequestParams params=new RequestParams(HttpUrl.USERPOST);
        //params.addBodyParameter("username","13092605210");
        params.addBodyParameter("username",username);
        x.http().post(params, new Callback.CommonCallback<String>() {
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
                    mForum_Detail_list_adapter = new ForumDetail_list_Adapter(MyPostActivity.this, mPostList);
                    mPullToRefreshListView.setAdapter(mForum_Detail_list_adapter);
                    mForum_Detail_list_adapter.notifyDataSetChanged();

                }


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                //Log.e("访问失败",ex.getMessage());

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    private void initListener() {
        mRadioGrouppost.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetViewpager(checkedId);
            }
        });
        /*mViewPagerPost.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
           //根据当前位置默认默认选中单选按钮
                resetRadioButton(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });*/
    }


    private void resetViewpager(int checkedId) {
        switch (checkedId){
            case R.id.myRaisepost:
                mViewPagerPost.setCurrentItem(0);
                break;
            case R.id.myReplypost:
                mViewPagerPost.setCurrentItem(1);
        }
    }
    private void resetRadioButton(int position) {
        RadioButton radioButton= (RadioButton) mRadioGrouppost.getChildAt(position);
        radioButton.setChecked(true);
    }


    public void backME(View view) {
        finish();
    }
}

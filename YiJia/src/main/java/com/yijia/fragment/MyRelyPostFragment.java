package com.yijia.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yijia.adapter.MyPostlistviewAdapter;
import com.yijia.beans.MyPostData;
import com.yijia.myapplication.MyReplypostDetailActivity;
import com.yijia.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laz on 2016/5/28.
 */
public class MyRelyPostFragment extends Fragment {
    List<MyPostData> mListrelypost;
    MyPostlistviewAdapter mQueslistviewAdapter;
    ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initData();
        View view = inflater.inflate(R.layout.myreplypost, null);
        mListView = (ListView) view.findViewById(R.id.listiewmyrelypost);
        mQueslistviewAdapter = new MyPostlistviewAdapter(mListrelypost, getContext());
        mListView.setAdapter(mQueslistviewAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyPostData myQuestionData = mListrelypost.get(position);
                Intent intent = new Intent(getContext(), MyReplypostDetailActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void initData() {
        mListrelypost=new ArrayList<>();
        MyPostData q1=new MyPostData(R.mipmap.user,"哈哈","我回复的帖子帖子帖子帖子帖子帖子帖子帖子帖子帖子1",R.drawable.company1,"2016-01-02");
        MyPostData q2=new MyPostData(R.mipmap.user,"李思","帖子帖子帖子帖子2",R.drawable.company1,"2016-01-06");
        MyPostData q3=new MyPostData(R.mipmap.user,"哈哈","帖子帖子帖子帖子3",R.drawable.company1,"2016-02-02");
        MyPostData q4=new MyPostData(R.mipmap.user,"呵呵","帖子帖子帖子帖子4",R.drawable.company1,"2016-02-04");
        MyPostData q5=new MyPostData(R.mipmap.user,"哦哦","帖子帖子帖子帖子5",R.drawable.company1,"2016-02-14");
        mListrelypost.add(q1);
        mListrelypost.add(q2);
        mListrelypost.add(q3);
        mListrelypost.add(q4);
        mListrelypost.add(q5);
    }
}
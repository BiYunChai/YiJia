package com.yijia.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yijia.adapter.ForumDetail_list_Adapter;
import com.yijia.bean.Post;
import com.yijia.bean.Postimg;
import com.yijia.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/13.
 */
public class ForumFragment extends Fragment{
    List<Post> mPostList=new ArrayList<>();
    PullToRefreshListView mPullToRefreshListView;

    ForumDetail_list_Adapter mForum_Detail_list_adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.forum,null);
        initView(view);
        initDate();
       // initLIstener();
        return view;

    }


    private void initView(View view) {
       mPullToRefreshListView= (PullToRefreshListView) view.findViewById(R.id.forum_list);
    }

    private void initDate() {
        List<Postimg> mPostimgList1 = new ArrayList<>();
        Postimg postimg1 = new Postimg(1, 1, "http://o7ghiqnts.bkt.clouddn.com/dengtwo.jpg");
        Postimg postimg2 = new Postimg(1, 2, "http://o7ghiqnts.bkt.clouddn.com/dengtwo.jpg");
        Postimg postimg3 = new Postimg(1, 3, "http://o7ghiqnts.bkt.clouddn.com/dengtwo.jpg");
        Postimg postimg4 = new Postimg(1, 4, "http://o7ghiqnts.bkt.clouddn.com/dengtwo.jpg");
        Postimg postimg5 = new Postimg(1, 5, "http://o7ghiqnts.bkt.clouddn.com/dengtwo.jpg");
        mPostimgList1.add(postimg1);
        mPostimgList1.add(postimg2);
        mPostimgList1.add(postimg3);
        mPostimgList1.add(postimg4);
        mPostimgList1.add(postimg5);


        List<Postimg> mPostimgList2 = new ArrayList<>();
        Postimg postimg6 = new Postimg(1, 1, "http://o7ghiqnts.bkt.clouddn.com/beij.jpg");
        Postimg postimg7 = new Postimg(1, 2, "http://o7ghiqnts.bkt.clouddn.com/beij.jpg");
        Postimg postimg8 = new Postimg(1, 3, "http://o7ghiqnts.bkt.clouddn.com/beij.jpg");
        Postimg postimg9 = new Postimg(1, 4, "http://o7ghiqnts.bkt.clouddn.com/beij.jpg");

        mPostimgList2.add(postimg6);
        mPostimgList2.add(postimg7);
        mPostimgList2.add(postimg8);
        mPostimgList2.add(postimg9);

        List<Postimg> mPostimgList3 = new ArrayList<>();
        mPostimgList3.add(postimg1);
        mPostimgList3.add(postimg6);
        mPostimgList3.add(postimg9);
        mPostimgList3.add(postimg7);
        mPostimgList3.add(postimg3);
        mPostimgList3.add(postimg8);
        mPostimgList3.add(postimg4);

        List<Postimg> mPostimgList4 = new ArrayList<>();
        mPostimgList4.add(postimg1);


        Post post1 = new Post("http://o7ghiqnts.bkt.clouddn.com/userphoto1.jpg", 1, "玩命敲代码", "无意中竟然发现这么大一个bug", "2016-06-06", mPostimgList1);
        Post post2 = new Post("http://o7ghiqnts.bkt.clouddn.com/userphoto1.jpg", 1, "玩命敲代码", "无意中竟然发现这么大一个bug", "2016-06-06", mPostimgList2);
        Post post3 = new Post("http://o7ghiqnts.bkt.clouddn.com/userphoto1.jpg", 1, "玩命敲代码", "无意中竟然发现这么大一个bug", "2016-06-06", mPostimgList3);
        Post post4 = new Post("http://o7ghiqnts.bkt.clouddn.com/userphoto1.jpg", 1, "玩命敲代码", "无意中竟然发现这么大一个bug", "2016-06-06", mPostimgList4);

        mPostList.add(post1);
        mPostList.add(post2);
        mPostList.add(post3);
        mPostList.add(post4);


        mForum_Detail_list_adapter = new ForumDetail_list_Adapter(getContext(), mPostList);
        mPullToRefreshListView.setAdapter(mForum_Detail_list_adapter);
    }



}

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

import com.yijia.adapter.MyQueslistviewAdapter;
import com.yijia.beans.MyQuestionData;
import com.yijia.myapplication.MyReplyquesDetailActivity;
import com.yijia.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import static com.yijia.myapplication.R.*;

/**
 * Created by laz on 2016/5/27.
 */
public class MyReplyQuesFragment extends Fragment {
    List<MyQuestionData> mListrelyques;
    MyQueslistviewAdapter mQueslistviewAdapter;
    ListView mListView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initData();
        View view=inflater.inflate(layout.myreplyquestion,null);
       mListView= (ListView) view.findViewById(id.listiewmyrelyques);
        mQueslistviewAdapter=new MyQueslistviewAdapter(mListrelyques,getContext());
        mListView.setAdapter(mQueslistviewAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyQuestionData myQuestionData=mListrelyques.get(position);
                Intent intent=new Intent(getContext(),MyReplyquesDetailActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void initData() {
mListrelyques=new ArrayList<>();
        MyQuestionData q1=new MyQuestionData(R.mipmap.user,"哈哈","我回复的问题问题问题问题问题问题问题问题问题1",R.drawable.ques,"2016-01-02");
        MyQuestionData q2=new MyQuestionData(R.mipmap.user,"李思","问题问题问题2",R.drawable.ques,"2016-01-06");
        MyQuestionData q3=new MyQuestionData(R.mipmap.user,"哈哈","问题问题问题3",R.drawable.ques,"2016-02-02");
        MyQuestionData q4=new MyQuestionData(R.mipmap.user,"呵呵","问题问题问题4",R.drawable.ques,"2016-02-04");
        MyQuestionData q5=new MyQuestionData(R.mipmap.user,"哦哦","问题问题问题5",R.drawable.ques,"2016-02-14");
        mListrelyques.add(q1);
        mListrelyques.add(q2);
        mListrelyques.add(q3);
        mListrelyques.add(q4);
        mListrelyques.add(q5);
    }
}

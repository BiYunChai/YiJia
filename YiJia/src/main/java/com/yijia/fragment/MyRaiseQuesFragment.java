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
import com.yijia.beans.MyQuesDetailData;
import com.yijia.beans.MyQuestionData;
import com.yijia.myapplication.MyRaisequesDetailActivity;
import com.yijia.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laz on 2016/5/27.
 */
public class MyRaiseQuesFragment extends Fragment {
    List<MyQuestionData> mListques;
    MyQueslistviewAdapter mQueslistviewAdapter;
    ListView mListView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initData();
        View view= inflater.inflate(R.layout.myraisequestion,null);
        mListView= (ListView) view.findViewById(R.id.listiewmyraiseques);
        mQueslistviewAdapter=new MyQueslistviewAdapter(mListques,getContext());
        mListView.setAdapter(mQueslistviewAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyQuestionData myQuestionData=mListques.get(position);
                Intent intent=new Intent(getContext(), MyRaisequesDetailActivity.class);
                intent.putExtra("myquesdetail",myQuestionData);
                startActivity(intent);
            }
        });
        return view;
    }

    private void initData() {
mListques=new ArrayList<>();
        MyQuestionData q1=new MyQuestionData(R.mipmap.user,"李思","我提出的问题问题问题问题问题问题问题问题问题1",R.drawable.ques,"2016-01-02");
        MyQuestionData q2=new MyQuestionData(R.mipmap.user,"李思","问题问题问题2",R.drawable.ques,"2016-01-06");
        MyQuestionData q3=new MyQuestionData(R.mipmap.user,"李思","问题问题问题3",R.drawable.ques,"2016-02-02");
        MyQuestionData q4=new MyQuestionData(R.mipmap.user,"李思","问题问题问题4",R.drawable.ques,"2016-02-04");
        MyQuestionData q5=new MyQuestionData(R.mipmap.user,"李思","问题问题问题5",R.drawable.ques,"2016-02-14");
        mListques.add(q1);
        mListques.add(q2);
        mListques.add(q3);
        mListques.add(q4);
        mListques.add(q5);

    }
}

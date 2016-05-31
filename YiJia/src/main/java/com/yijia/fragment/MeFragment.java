package com.yijia.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yijia.myapplication.LoginActivity;
import com.yijia.myapplication.MyBuildActivity;
import com.yijia.myapplication.MyPostActivity;
import com.yijia.myapplication.MyStoreActivity;
import com.yijia.myapplication.MyquestionActivity;
import com.yijia.myapplication.R;
import com.yijia.myapplication.SettingActivity;

/**
 * Created by Administrator on 2016/5/13.
 */
public class MeFragment extends Fragment {
    LinearLayout gongdi,question,tiezi,store,setting;
    Button mButton;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.me, null);
        initViews();
        gongdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MyBuildActivity.class);
                startActivity(intent);
            }
        });


        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), SettingActivity.class);
                startActivity(intent);
            }
        });


        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MyStoreActivity.class);
                startActivity(intent);
            }
        });
mButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
    }
});

        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MyquestionActivity.class);
                startActivity(intent);
            }
        });
       tiezi.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getContext(),MyPostActivity.class);
               startActivity(intent);
           }
       });
        return view;
    }

    private void initViews() {
        gongdi= (LinearLayout) view.findViewById(R.id.building);
        question= (LinearLayout) view.findViewById(R.id.question);
        tiezi= (LinearLayout) view.findViewById(R.id.post);
        store= (LinearLayout) view.findViewById(R.id.store);
        setting= (LinearLayout) view.findViewById(R.id.setting);
        mButton= (Button) view.findViewById(R.id.LoginAndRegister);
    }

}

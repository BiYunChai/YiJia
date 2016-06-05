package com.yijia.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yijia.adapter.CompanylocaAdpter;
import com.yijia.adapter.ThemetypeAdpter;
import com.yijia.bean.TestData;
import com.yijia.bean.Theme;
import com.yijia.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/31.
 */
public class ThemeTypeFragment extends Fragment {
    ListView mListview;
    List<Theme> themeList;
    ThemetypeAdpter mThemetypeAdpter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.themetype,null);
        //初始化listview控件
        initListDataView(view);

        //初始化数据
        initListData();
        //initListAdapter();
        return view;
    }

    private void initListDataView(View view) {
        mListview= (ListView) view.findViewById(R.id.theme_type_list);
    }

    private void initListData() {
        themeList=new ArrayList<>();

        Theme theme1=new Theme(1,"老屋新生演绎混搭","老房子就如一本典籍藏书，随着岁月的流逝，累积丰厚的篇章扉页，仿佛有说故事的能力，让人为之着迷。","http://o7ghiqnts.bkt.clouddn.com/themetype1.jpg");
        Theme theme2=new Theme(1,"老屋新生演绎混搭","老房子就如一本典籍藏书，随着岁月的流逝，累积丰厚的篇章扉页，仿佛有说故事的能力，让人为之着迷。","http://o7ghiqnts.bkt.clouddn.com/themetype1.jpg");
        Theme theme3=new Theme(1,"老屋新生演绎混搭","老房子就如一本典籍藏书，随着岁月的流逝，累积丰厚的篇章扉页，仿佛有说故事的能力，让人为之着迷。","http://o7ghiqnts.bkt.clouddn.com/themetype1.jpg");
        Theme theme4=new Theme(1,"老屋新生演绎混搭","老房子就如一本典籍藏书，随着岁月的流逝，累积丰厚的篇章扉页，仿佛有说故事的能力，让人为之着迷。","http://o7ghiqnts.bkt.clouddn.com/themetype1.jpg");
        themeList.add(theme1);
        themeList.add(theme2);
        themeList.add(theme3);
        themeList.add(theme4);



        mThemetypeAdpter=new ThemetypeAdpter(getContext(),themeList);
        mListview.setAdapter(mThemetypeAdpter);






    }
}

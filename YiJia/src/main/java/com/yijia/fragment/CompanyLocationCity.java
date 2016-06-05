package com.yijia.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yijia.adapter.CompanyScoreAdpter;
import com.yijia.adapter.CompanylocaAdpter;
import com.yijia.bean.Company;
import com.yijia.bean.TestData;
import com.yijia.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/31.
 */
public class CompanyLocationCity extends Fragment {
    ListView mListview;
    List<Company> companycitylist;
    CompanyScoreAdpter mCompanylocaAdpter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.companylocation,null);
        //初始化listview控件
        initListDataView(view);

        //初始化数据
        initListData();
        //initListAdapter();
        return view;
    }

    private void initListDataView(View view) {
        mListview= (ListView) view.findViewById(R.id.com_loc_list);
    }

    private void initListData() {
        companycitylist=new ArrayList<>();

        Company company1=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companytwo.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company2=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companytwo.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company3=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companytwo.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company4=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companytwo.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company5=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companytwo.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company6=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companytwo.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company7=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companytwo.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company8=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companytwo.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company9=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companytwo.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company10=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companytwo.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");



        companycitylist.add(company1);
        companycitylist.add(company2);
        companycitylist.add(company3);
        companycitylist.add(company4);
        companycitylist.add(company5);
        companycitylist.add(company6);
        companycitylist.add(company7);
        companycitylist.add(company8);
        companycitylist.add(company9);
        companycitylist.add(company10);



        mCompanylocaAdpter=new CompanyScoreAdpter(getContext(),companycitylist);
        mListview.setAdapter(mCompanylocaAdpter);






    }
}

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

import com.yijia.adapter.CompanyScoreAdpter;
import com.yijia.adapter.CompanylocaAdpter;
import com.yijia.bean.Company;
import com.yijia.bean.TestData;
import com.yijia.myapplication.CompanyDetailActivity;
import com.yijia.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/31.
 */
public class CompanyScoreFragnment extends Fragment {
    ListView mListview;
    List<Company> COmpanyList;
    CompanyScoreAdpter mCompanyScoreAdpter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.companyscore,null);
        //初始化listview控件
        initListDataView(view);

        //初始化数据
        initListData();
        //initListAdapter();
        return view;
    }
    private void initListDataView(View view) {
        mListview= (ListView) view.findViewById(R.id.com_score_list);
    }

    private void initListData() {
        COmpanyList=new ArrayList<>();

        Company company1=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companyone.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company2=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companyone.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company3=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companyone.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company4=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companyone.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company5=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companyone.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company6=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companyone.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company7=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companyone.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company8=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companyone.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company9=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companyone.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company10=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companyone.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company11=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companyone.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company12=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companyone.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
        Company company13=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companyone.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");


        COmpanyList.add(company1);
        COmpanyList.add(company2);
        COmpanyList.add(company3);
        COmpanyList.add(company4);
        COmpanyList.add(company5);
        COmpanyList.add(company6);
        COmpanyList.add(company7);
        COmpanyList.add(company8);
        COmpanyList.add(company9);
        COmpanyList.add(company10);
        COmpanyList.add(company11);
        COmpanyList.add(company12);
        COmpanyList.add(company13);


        mCompanyScoreAdpter=new CompanyScoreAdpter(getContext(),COmpanyList);
        mListview.setAdapter(mCompanyScoreAdpter);

mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(getContext(), CompanyDetailActivity.class);
        startActivity(intent);
    }
});




    }
}

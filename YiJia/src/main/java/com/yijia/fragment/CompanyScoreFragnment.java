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
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.yijia.adapter.CompanyScoreAdpter;
import com.yijia.adapter.CompanylocaAdpter;
import com.yijia.beans.Company;
import com.yijia.beans.Compdesign;
import com.yijia.beans.Compvertify;
import com.yijia.myapplication.CompanyDetailActivity;
import com.yijia.myapplication.R;
import com.yijia.utils.HttpUrl;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/31.
 */
public class CompanyScoreFragnment extends Fragment {
    ListView mListview;
    List<Company> COmpanyList=new ArrayList<>();
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
    //http://localhost:8080/YiJia/companyServlet2?test=selectbyscore
    //COMPANYSELECTBYSCORE
    private void initListData() {
        RequestParams params=new RequestParams(HttpUrl.COMPANYSELECTBYSCORE);
        Log.e("url",HttpUrl.COMPANYSELECTBYSCORE);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
                Type type=new TypeToken<List<Company>>(){}.getType();
                List<Company> list;
                list=gson.fromJson(result,type);
                Log.e("company",list.toString());
                for (Company company:list) {
                    int cid=company.getId();
                    String companyname=company.getCompanyname();
                    String compaddgeneral=company.getCompaddgeneral();
                    String compadddetail=company.getCompadddetail();
                    String email=company.getCompemail();
                    String compdescription=company.getCompdescription();
                    List<Compdesign> design=company.getCompdesign();
                    List<Compvertify> compvertifies=company.getCompvertify();
                   float score=company.getScore();
                    String tel=company.getComtel();
                    String logo=company.getLogoaddress();
                    int complainNum=company.getComplaintNum();
                    Company company1=new Company(cid,logo,companyname,score,tel,compaddgeneral,compadddetail,design,compvertifies,email,compdescription,complainNum);
                    COmpanyList.add(company1);
                    Log.e("company1",company1+"");
                }
                mCompanyScoreAdpter=new CompanyScoreAdpter(getContext(),COmpanyList);
                mListview.setAdapter(mCompanyScoreAdpter);
                mCompanyScoreAdpter .notifyDataSetChanged();
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
      //  COmpanyList=new ArrayList<>();

      /*  Company company1=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companyone.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
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
        COmpanyList.add(company13);*/

mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Gson gson=new Gson();
        Company company=COmpanyList.get(position);
        Log.e("comp-------",company.toString());
        String result=gson.toJson(company);
        Log.e("c-------",company.toString());
        Intent intent=new Intent(getContext(), CompanyDetailActivity.class);
        intent.putExtra("company",result);
        Log.e("result-------",result);
        startActivity(intent);
    }
});




    }
}

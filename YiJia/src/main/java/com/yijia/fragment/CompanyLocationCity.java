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
import android.widget.Toast;

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
public class CompanyLocationCity extends Fragment {
    ListView mListview;
    List<Company> companycitylist=new ArrayList<>();;
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
        initListener();
        return view;
    }


    private void initListDataView(View view) {
        mListview= (ListView) view.findViewById(R.id.com_loc_list);
    }
//http://localhost:8080/YiJia/companyServlet2?test=selectbyregion
    private void initListData() {
        RequestParams params=new RequestParams(HttpUrl.COMPANYSELECTBYREGION);
        Log.e("url-----------",params.toString());
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("kk------------",result);
                Gson gson=new Gson();
                Type type=new TypeToken<List<Company>>(){}.getType();
                List<Company> list;
                list=gson.fromJson(result,type);
                Log.e("list------------",list.size()+"");
                Log.e("company-----------",list.toString());
                for (Company company:list) {
                    int cid=company.getId();
                    String addgeneral=company.getCompaddgeneral();
                    String adddetail=company.getCompadddetail();
                    String companyname=company.getCompanyname();
                    Log.e("company1",companyname);
                    float score=company.getScore();
                    Log.e("company1",score+"");
                    String tel=company.getComtel();
                    Log.e("company1",tel);
                    List<Compdesign> compdesigns=company.getCompdesign();
                    List<Compvertify> compvertifies=company.getCompvertify();
                    String email=company.getCompemail();
                    String description=company.getCompdescription();
                    String logo=company.getLogoaddress();
                    Log.e("company1",logo);
                    int complainNum=company.getComplaintNum();
                    Company company1=new Company(cid,logo,companyname,score,tel,addgeneral,adddetail,compdesigns,compvertifies,email,description,complainNum);
                    companycitylist.add(company1);
                    Log.e("company1",company1+"");
                    Log.e("",companycitylist.size()+"");
                }
                mCompanylocaAdpter=new CompanyScoreAdpter(getContext(),companycitylist);
                mListview.setAdapter(mCompanylocaAdpter);
                mCompanylocaAdpter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("--------------",ex.getMessage());

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
       /* Company company1=new Company(1,"http://o7ghiqnts.bkt.clouddn.com/companytwo.jpg","苏州宏城基业装饰公司",9.53f,"05123344556");
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
        companycitylist.add(company10);*/
    }


    private void initListener() {
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Gson gson=new Gson();
                Company company=companycitylist.get(position);
                Log.e("comp-------",company.toString());
                String result=gson.toJson(company);
                Log.e("c-------",company.toString());
                Intent intent=new Intent(getActivity(),CompanyDetailActivity.class);
                intent.putExtra("company",result);
                Log.e("result-------",result);
                startActivity(intent);
            }
        });

    }
}

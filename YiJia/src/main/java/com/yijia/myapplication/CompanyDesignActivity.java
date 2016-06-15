package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yijia.adapter.DesigninspirateAdapter;
import com.yijia.beans.Compdesign;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CompanyDesignActivity extends AppCompatActivity {
    List<Compdesign> mCompdesignList=new ArrayList<>();
    DesigninspirateAdapter mAdapter;
    ListView mListView;
    //Company mCompany;
   //Compdesign compdesign;

    int cid;
    TextView design_title;
    TextView designer;
    TextView design_style;
    TextView design_squae;
    TextView design_price;
    TextView design_type;
    TextView design_buildaddress;
    TextView design_inspire;
    ImageView design_pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_design);
        initViews();
        initGson();
        //initData(mCompdesignList);
     //initdesignData(mCompdesignList);
        mListView= (ListView) findViewById(R.id.design_program);
       mAdapter=new DesigninspirateAdapter(CompanyDesignActivity.this,mCompdesignList);
        mListView.setAdapter(mAdapter);
    }


    private void initViews() {
        design_title= (TextView) findViewById(R.id.design_title);
         designer= (TextView) findViewById(R.id.designer);
        design_style =(TextView) findViewById(R.id.design_style);
        design_squae =(TextView) findViewById(R.id.design_square);
        design_price =(TextView) findViewById(R.id.design_price);
        design_type =(TextView) findViewById(R.id.design_type);
         design_buildaddress =(TextView) findViewById(R.id.design_buildname);
        design_inspire =(TextView) findViewById(R.id.design_inspirate);
        design_pic= (ImageView) findViewById(R.id.design_pic);
    }
    private void initGson() {
        Intent intent=getIntent();
        String designlist=intent.getStringExtra("designlist");
        Gson gson=new Gson();
        Type type=new TypeToken<List<Compdesign>>(){}.getType();
        List<Compdesign> compdesignList;
        compdesignList=gson.fromJson(designlist,type);
        Log.e("-----------",compdesignList.toString());
        for (Compdesign compdesign:compdesignList) {
            int id=compdesign.getId();
            int cid=compdesign.getCid();
            String design_title= compdesign.getDesign_title();
            String designer= compdesign.getDesigner();
            String design_style=compdesign.getDesign_style();
            double  design_squae=compdesign.getDesign_square();
            double design_price=compdesign.getDesign_price();
            String design_type=compdesign.getDesign_type();
            String design_buildaddress=compdesign.getDesign_buildaddress();
            String design_inspire=compdesign.getDesign_inspire();
            String design_pic=compdesign.getDesign_pic();
            Compdesign compdesign1=new Compdesign(id,cid,design_pic,design_title,designer,design_style,design_price,design_type,design_squae,design_buildaddress,design_inspire);
            mCompdesignList.add(compdesign1);
        }
    }

   /* private void initData() {
        mList=new ArrayList<>();
        Compdesign d1=new Compdesign("楼盘名称：小石城","设计者：默默","风格：新古典","面积：100平方米","预报价：8~10万","房型：小户型","楼盘地址：苏州吴中","设计灵感：***",R.drawable.coll_recommend);
        Compdesign d2=new Compdesign("楼盘名称：小石城","设计者：默默","风格：新古典","面积：100平方米","预报价：8~10万","房型：小户型","楼盘地址：苏州吴中","设计灵感：***",R.drawable.coll_recommend);
        Compdesign d3=new Compdesign("楼盘名称：小石城","设计者：默默","风格：新古典","面积：100平方米","预报价：8~10万","房型：小户型","楼盘地址：苏州吴中","设计灵感：***",R.drawable.coll_recommend);
        Compdesign d4=new Compdesign("楼盘名称：小石城","设计者：默默","风格：新古典","面积：100平方米","预报价：8~10万","房型：小户型","楼盘地址：苏州吴中","设计灵感：***",R.drawable.coll_recommend);
        mList.add(d1);
        mList.add(d2);
        mList.add(d3);
        mList.add(d4);
    }*/
}

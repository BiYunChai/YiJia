package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yijia.beans.Company;
import com.yijia.beans.Compdesign;
import com.yijia.beans.Compvertify;

import java.lang.reflect.Type;
import java.util.List;

public class CompanyDetailActivity extends AppCompatActivity {
LinearLayout company_design;
    LinearLayout company_infomation;
    LinearLayout company_certify;
    LinearLayout company_registinfo;
    Button applyfreedesign;
    Company mCompany;
    int cid;
    List<Compdesign> mCompdesigns;
    List<Compvertify> mCompvertifies;
    ImageView mImageViewlogo;
    TextView mTextViewcompname;
    TextView comp_score;
    TextView comp_tel;
    TextView comp_address;
    ImageView company_deigncase;
    TextView comp_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_detail);
        initViews();
        //接收gson数据
        initGson();
        initData();
        initListener();
    }



    private void initViews() {
        company_design= (LinearLayout) findViewById(R.id.company_design);
        company_infomation= (LinearLayout) findViewById(R.id.company_infomation);
        company_certify= (LinearLayout) findViewById(R.id.company_certify);
        company_registinfo= (LinearLayout) findViewById(R.id.company_registinfo);
        applyfreedesign= (Button) findViewById(R.id.applyfreedesign);
        mImageViewlogo= (ImageView) findViewById(R.id.comp_logo);
        mTextViewcompname= (TextView) findViewById(R.id.com_detailname);
        comp_score=(TextView) findViewById(R.id.score);
        comp_tel= (TextView) findViewById(R.id.companytel);
        comp_address= (TextView) findViewById(R.id.companydetailaddress);
        company_deigncase= (ImageView) findViewById(R.id.company_inspiration);
        comp_description= (TextView) findViewById(R.id.comp_description);
    }
    private void initGson() {

        Intent intent=getIntent();
        String company=intent.getStringExtra("company");
        Gson gson=new Gson();
        Type type=new TypeToken<Company>(){}.getType();
        mCompany=gson.fromJson(company,type);
        Log.e("-----------",mCompany.toString());
        mCompdesigns=mCompany.getCompdesign();

        // Log.e("mCompdesigns",mCompdesigns.toString());
        mCompvertifies=mCompany.getCompvertify();
        //Log.e("mCompvertifies",mCompvertifies.toString());

        cid=mCompany.getId();
        Log.e("cid",cid+"");
    }
    private void initData() {
        Glide.with(CompanyDetailActivity.this)
                .load(mCompany.getLogoaddress())
                .into(mImageViewlogo);
        mTextViewcompname.setText(mCompany.getCompanyname());
        comp_score.setText(mCompany.getScore()+"");
        comp_tel.setText(mCompany.getComtel());
        comp_address.setText(mCompany.getCompadddetail());
        comp_description.setText(mCompany.getCompdescription());
    }


    private void initListener() {
        company_design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson=new Gson();
                String designlist=gson.toJson(mCompdesigns);
                Intent intent=new Intent(CompanyDetailActivity.this,CompanyDesignActivity.class);
                intent.putExtra("designlist",designlist);
                startActivity(intent);
            }
        });
        company_infomation.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              //Gson gson=new Gson();
              // String description=gson.toJson(comp_description);
               String description1=mCompany.getCompdescription();
               Log.e("33333333333",description1);
               Intent intent=new Intent(CompanyDetailActivity.this,CompaninfoActivity.class);
              intent.putExtra("description",description1);
               startActivity(intent);
           }
       });
        company_certify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson=new Gson();
                String vertifylist=gson.toJson(mCompvertifies);
                Intent intent=new Intent(CompanyDetailActivity.this,CompanyCertifyActivity.class);
                intent.putExtra("vertifylist",vertifylist);
                startActivity(intent);
            }
        });
        company_registinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CompanyDetailActivity.this,CompanyRegistinfo.class);
                startActivity(intent);
            }
        });
        applyfreedesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CompanyDetailActivity.this,DesignApplyActivity.class);
                startActivity(intent);
            }
        });
    }
    public void back(View view) {
        finish();
    }
}

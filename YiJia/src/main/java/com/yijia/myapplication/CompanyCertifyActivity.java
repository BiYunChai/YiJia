package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yijia.adapter.CompCertifyAdapter;
import com.yijia.beans.Compdesign;
import com.yijia.beans.Compvertify;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CompanyCertifyActivity extends AppCompatActivity {
List<Compvertify> mcompvertifyList=new ArrayList<>();
    CompCertifyAdapter mAdapter;
    ListView mListView;
    ImageView mImageViewvertify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_certify);
        initGson();
        mListView= (ListView) findViewById(R.id.com_certifylistview);
        mImageViewvertify= (ImageView) findViewById(R.id.certifyPic);
        mAdapter=new CompCertifyAdapter(mcompvertifyList,CompanyCertifyActivity.this);
        mListView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }


    private void initGson() {
        Intent intent=getIntent();
        String vertifylist=intent.getStringExtra("vertifylist");
        Gson gson=new Gson();
        Type type=new TypeToken<List<Compvertify>>(){}.getType();
        List<Compvertify> compvertifyList;
        compvertifyList=gson.fromJson(vertifylist,type);
        Log.e("-----------",vertifylist.toString());
        for (Compvertify vertify:compvertifyList) {
            int id=vertify.getId();
            int cid=vertify.getCid();
            String vertifypic=vertify.getVertifyaddress();
            Compvertify compvertify=new Compvertify(id,cid,vertifypic);
            mcompvertifyList.add(compvertify);
        }
    }
        //mList=new ArrayList<>();
      /*  Compvertify certify1=new Compvertify("http://o7ghiqnts.bkt.clouddn.com/certify.png");
        Compvertify certify2=new Compvertify("http://o7ghiqnts.bkt.clouddn.com/certify2.jpg");
        Compvertify certify3=new Compvertify("http://o7ghiqnts.bkt.clouddn.com/certify.jpg");
        Compvertify certify4=new Compvertify("http://o7ghiqnts.bkt.clouddn.com/certify2.jpg");
        mList.add(certify1);
        mList.add(certify2);
        mList.add(certify3);
        mList.add(certify4);*/

}

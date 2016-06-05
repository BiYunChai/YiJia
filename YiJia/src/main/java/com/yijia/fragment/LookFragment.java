package com.yijia.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yijia.adapter.LookGridAdapter;
import com.yijia.adapter.LookListAdapter;
import com.yijia.bean.Good;
import com.yijia.myapplication.LookGoodsActivity;
import com.yijia.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/13.
 */
public class LookFragment extends Fragment {
    GridView mGridView;
    List<String> mlist=new ArrayList<>();
    LookGridAdapter mLookGridAdapter;
    PullToRefreshListView mListView;
    List<Good> mGoodlist=new ArrayList<>();

    LookListAdapter mLookListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.look,null);




        initListview(view);
        initListData();
        initListlistener();

        initGridData();
        initGridview(view);
        initGridlistener();

        mLookListAdapter=new LookListAdapter(getContext(),mGoodlist);
        mListView.setAdapter(mLookListAdapter);
        return view;
    }

    private void initListData() {

        Good good1=new Good("荷花型卧室水晶吊灯1","132","http://o7ghiqnts.bkt.clouddn.com/dengonejpg");
        Good good2=new Good("荷花型卧室水晶吊灯2","132","http://o7ghiqnts.bkt.clouddn.com/dengonejpg");
        Good good3=new Good("荷花型卧室水晶吊灯3","132","http://o7ghiqnts.bkt.clouddn.com/dengonejpg");
        Good good4=new Good("荷花型卧室水晶吊灯4","132","http://o7ghiqnts.bkt.clouddn.com/dengonejpg");
        Good good5=new Good("荷花型卧室水晶吊灯5","132","http://o7ghiqnts.bkt.clouddn.com/dengonejpg");
        Good good6=new Good("荷花型卧室水晶吊灯6","132","http://o7ghiqnts.bkt.clouddn.com/dengonejpg");
        mGoodlist.add(good1);
        mGoodlist.add(good2);
        mGoodlist.add(good3);
        mGoodlist.add(good4);
        mGoodlist.add(good5);
        mGoodlist.add(good6);




    }



    private void initListview(View view) {
        mListView= (PullToRefreshListView) view.findViewById(R.id.looklist);
    }

    private void initListlistener() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getContext(), LookGoodsActivity.class);
                intent.putExtra("id","1");
                startActivity(intent);
                Toast.makeText(getContext(),"选中了"+mGoodlist.get(position-1).getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initGridview(View view) {
        mGridView= (GridView) view.findViewById(R.id.look_classfiy);

        int size = mlist.size();
        int length = 100;
        //使用DisplayMetrics获取屏幕参数
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        int gridviewWidth = (int) (size * length * density);
        int itemWidth = (int) (length * density);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                gridviewWidth, LinearLayout.LayoutParams.MATCH_PARENT);
        mGridView.setLayoutParams(layoutParams); // 设置GirdView布局参数,横向布局的关键
        mGridView.setColumnWidth(itemWidth); // 设置列表项宽
        mGridView.setHorizontalSpacing(5); // 设置列表项水平间距
        mGridView.setStretchMode(GridView.NO_STRETCH);//不拉伸
        mGridView.setNumColumns(size); // 设置列数量=列表集合数
        mGridView.setVerticalScrollBarEnabled(false);//设置滚动条不显示

        mLookGridAdapter=new LookGridAdapter(getContext(),mlist);
        mGridView.setAdapter(mLookGridAdapter);
    }


    private void initGridData() {

        mlist.add("灯饰照明");
        mlist.add("卫浴用品");
        mlist.add("厨房用品");
        mlist.add("客卧用品");
        mlist.add("生活电器");
        mlist.add("墙面瓷砖");
        mlist.add("阳台用品");
        mlist.add("建材无全");


    }

    private void initGridlistener() {
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mGoodlist.clear();
                if(position==0){
                    initListData();
                }

                if(position==1) {
                    Good good1 = new Good("荷花型卧室水晶吊灯222", "132", "http://o7ghiqnts.bkt.clouddn.com/dengthree.jpg");
                    Good good2 = new Good("荷花型卧室水晶吊灯", "132", "http://o7ghiqnts.bkt.clouddn.com/dengthree.jpg");
                    Good good3 = new Good("荷花型卧室水晶吊灯3", "132","http://o7ghiqnts.bkt.clouddn.com/dengthree.jpg");
                    Good good4 = new Good("荷花型卧室水晶吊灯4", "132","http://o7ghiqnts.bkt.clouddn.com/dengthree.jpg");
                    Good good5 = new Good("荷花型卧室水晶吊灯5", "132","http://o7ghiqnts.bkt.clouddn.com/dengthree.jpg");
                    Good good6 = new Good("荷花型卧室水晶吊灯6", "132", "http://o7ghiqnts.bkt.clouddn.com/dengthree.jpg");
                    mGoodlist.add(good1);
                    mGoodlist.add(good2);
                    mGoodlist.add(good3);
                    mGoodlist.add(good4);
                    mGoodlist.add(good5);
                    mGoodlist.add(good6);
                }else{

                    Good good1=new Good("荷花型卧室水晶吊灯1","132","http://o7ghiqnts.bkt.clouddn.com/dengfour.jpg");
                    Good good2=new Good("荷花型卧室水晶吊灯111","132","http://o7ghiqnts.bkt.clouddn.com/dengfour.jpg");
                    Good good3=new Good("荷花型卧室水晶吊灯3","132","http://o7ghiqnts.bkt.clouddn.com/dengfour.jpg");
                    Good good4=new Good("荷花型卧室水晶吊灯4","132","http://o7ghiqnts.bkt.clouddn.com/dengfour.jpg");
                    Good good5=new Good("荷花型卧室水晶吊灯5","132","http://o7ghiqnts.bkt.clouddn.com/dengfour.jpg");
                    Good good6=new Good("荷花型卧室水晶吊灯6","132","http://o7ghiqnts.bkt.clouddn.com/dengfour.jpg");
                    mGoodlist.add(good1);
                    mGoodlist.add(good2);
                    mGoodlist.add(good3);
                    mGoodlist.add(good4);
                    mGoodlist.add(good5);
                    mGoodlist.add(good6);
                }
                mLookListAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(),"选中了"+position,Toast.LENGTH_SHORT).show();

            }
        });

    }



}

package com.yijia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yijia.beans.MyCollCompanyData;
import com.yijia.beans.MyCollRecData;
import com.yijia.myapplication.R;

import java.util.List;

/**
 * Created by laz on 2016/6/3.
 */
public class MyCollCompAdapter extends BaseAdapter {
    List<MyCollCompanyData> mList;
    Context mContext;
    LayoutInflater mInflater;

    public MyCollCompAdapter(Context context, List<MyCollCompanyData> list) {
        mContext = context;
        mList = list;
        mInflater=LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    class ViewHolder{
        ImageView comp_pic;
        TextView collcomp_name;
        TextView rate;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            //说明是第一次绘制满屏
            //找到每一行的布局
            convertView=mInflater.inflate(R.layout.coll_comp_item,null);
            viewHolder=new ViewHolder();
            //初始化当前行布局中的所有控件
            viewHolder.comp_pic= (ImageView) convertView.findViewById(R.id.comp_pic);
            viewHolder.collcomp_name= (TextView) convertView.findViewById(R.id.comp_topic);
            viewHolder.rate= (TextView) convertView.findViewById(R.id.comp_rate);
            //把当前的控件缓存到布局视图中
            convertView.setTag(viewHolder);
        }else {
            //说明开始上下滑动，后面的所有行的布局采用第一次绘制时的缓存布局
            viewHolder= (ViewHolder) convertView.getTag();
        }
        MyCollCompanyData myCollcompData=mList.get(position);
        viewHolder.comp_pic.setImageResource(myCollcompData.getCollcomp_pic());
        viewHolder.collcomp_name.setText(myCollcompData.getCollcomp_name());
        viewHolder.rate.setText(myCollcompData.getRate());
        return convertView;
    }
}

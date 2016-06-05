package com.yijia.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yijia.bean.Recommend;

import com.yijia.myapplication.R;


import java.util.List;


/**
 * Created by Administrator on 2016/5/25.
 */
public class HomeListAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    Context mContext;
    List<Recommend> list;

    public HomeListAdapter(Context mContext, List<Recommend> list) {
        this.mContext = mContext;
        this.list = list;
        mInflater=LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    //缓存布局中的控件
    class ViewHolder{
        TextView lable;
        TextView topic;
        TextView designer;
        TextView rectime;
        ImageView pic;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        //找到每一行的布局
        if (convertView == null){
            //说明是第一次绘制整屏列表，例如1-6行
            convertView =mInflater.inflate(R.layout.homelistitem,null);
            viewHolder = new ViewHolder();
            //初始化当前行布局中的所有控件
            viewHolder.lable= (TextView) convertView.findViewById(R.id.label);
            viewHolder.topic= (TextView) convertView.findViewById(R.id.topic);
            viewHolder.pic= (ImageView) convertView.findViewById(R.id.pic);
            viewHolder.designer= (TextView) convertView.findViewById(R.id.designer);
            viewHolder.rectime= (TextView) convertView.findViewById(R.id.rectime);
            //把当前的控件缓存到布局视图中
            convertView.setTag(viewHolder);

        } else {
            //说明开始上下滑动，后面的所有行布局采用第一次绘制时的缓存布局
            viewHolder = (ViewHolder) convertView.getTag();
        }

//
//        ImageView img;
        final Recommend recommend = list.get(position);
        //加载网络图片
        String imgUrl=recommend.getImgaddress();
        Glide.with(mContext)
                .load(imgUrl)
                .thumbnail(0.5f)
                .into(viewHolder.pic);

        //viewHolder.pic.setImageResource(R.drawable.homelistpic);
      //  viewHolder.pic.setImageDrawable();
        viewHolder.topic.setText(recommend.getTopic());
        viewHolder.designer.setText(recommend.getDesigner());
        viewHolder.rectime.setText(recommend.getRectime()+"");

        return convertView;
    }

}

package com.yijia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.yijia.bean.Good;

import com.yijia.myapplication.R;

import java.util.List;

/**
 * Created by Administrator on 2016/6/2.
 */
public class LookListAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    Context mContext;
    List<Good> mlist;

    public LookListAdapter(Context context,List<Good> mlist) {
        this.mContext=context;
        this.mlist = mlist;
        mInflater=LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    class ViewHolder{
        TextView name;
        TextView price;
        ImageView pic;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        //找到每一行的布局
        if (convertView == null){
            //说明是第一次绘制整屏列表，例如1-6行
            convertView =mInflater.inflate(R.layout.look_list_item,null);
            viewHolder = new ViewHolder();
            //初始化当前行布局中的所有控件
            viewHolder.name= (TextView) convertView.findViewById(R.id.goodsname);
            viewHolder.price= (TextView) convertView.findViewById(R.id.goodsprice);
            viewHolder.pic= (ImageView) convertView.findViewById(R.id.goodspic);

            //把当前的控件缓存到布局视图中
            convertView.setTag(viewHolder);

        } else {
            //说明开始上下滑动，后面的所有行布局采用第一次绘制时的缓存布局
            viewHolder = (ViewHolder) convertView.getTag();
        }

//
//        ImageView img;
        final Good good = mlist.get(position);
        //加载网络图片
        String imgUrl=good.getPic();
        Glide.with(mContext)
                .load(imgUrl)
                .thumbnail(0.5f)
                .into(viewHolder.pic);

        //viewHolder.pic.setImageResource(R.drawable.deng3);
        //  viewHolder.pic.setImageDrawable();
        viewHolder.name.setText(good.getName());
        viewHolder.price.setText(good.getPrice());


        return convertView;
    }
}

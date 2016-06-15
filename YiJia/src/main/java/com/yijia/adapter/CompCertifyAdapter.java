package com.yijia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yijia.beans.Compvertify;
import com.yijia.myapplication.R;

import java.util.List;

/**
 * Created by laz on 2016/6/9.
 */
public class CompCertifyAdapter extends BaseAdapter {
    List<Compvertify> mList;
    Context mContext;
    LayoutInflater mInflater;

    public CompCertifyAdapter(List<Compvertify> list, Context context) {
        mList = list;
        mContext = context;
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
       ImageView certifypic;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            //说明是第一次绘制满屏
            //找到每一行的布局
            convertView=mInflater.inflate(R.layout.com_certify_item,null);
            viewHolder=new ViewHolder();
            //初始化当前行布局中的所有控件
            viewHolder.certifypic= (ImageView) convertView.findViewById(R.id.certifyPic);

            //把当前的控件缓存到布局视图中
            convertView.setTag(viewHolder);
        }else {
            //说明开始上下滑动，后面的所有行的布局采用第一次绘制时的缓存布局...
            viewHolder= (ViewHolder) convertView.getTag();
        }
        Compvertify companyCertify=mList.get(position);
        //加载网络图片
        Glide.with(mContext)
                .load(companyCertify.getVertifyaddress())
                .into(viewHolder.certifypic);
        return convertView;
    }
}
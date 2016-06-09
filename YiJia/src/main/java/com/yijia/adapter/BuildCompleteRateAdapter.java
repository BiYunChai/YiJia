package com.yijia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yijia.beans.BuildStageCompleteRate;
import com.yijia.myapplication.R;

import java.util.List;

/**
 * Created by laz on 2016/6/9.
 */
public class BuildCompleteRateAdapter extends BaseAdapter {
    List<BuildStageCompleteRate> mList;
    Context mContext;
    LayoutInflater mInflater;

    public BuildCompleteRateAdapter(List<BuildStageCompleteRate> list, Context context) {
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
    //缓存布局中的控件
    class ViewHolder{
        ImageView BuildStageCompletePic;
        TextView BuildStageCompleteContent;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        //找到每一行的布局
        if (convertView == null){
            //说明是第一次绘制整屏列表，例如1-6行
            convertView =mInflater.inflate(R.layout.buildcompleterate_item,null);
            viewHolder = new ViewHolder();
            //初始化当前行布局中的所有控件
            viewHolder.BuildStageCompletePic= (ImageView) convertView.findViewById(R.id.BuildStageCompletePic);
            viewHolder.BuildStageCompleteContent= (TextView) convertView.findViewById(R.id.BuildStageCompleteContent);
            //把当前的控件缓存到布局视图中
            convertView.setTag(viewHolder);

        } else {
            //说明开始上下滑动，后面的所有行布局采用第一次绘制时的缓存布局
            viewHolder = (ViewHolder) convertView.getTag();
        }

//        ImageView img;
         BuildStageCompleteRate buildStageCompleteRate = mList.get(position);
       /* //加载网络图片
        Glide.with(mContext)
                .load("http://o7ghiqnts.bkt.clouddn.com/waterelecRate")
                .into(viewHolder.BuildStageCompletePic);*/
        viewHolder.BuildStageCompletePic.setImageResource(buildStageCompleteRate.getBuildStageCompletePic());

        viewHolder.BuildStageCompleteContent.setText(buildStageCompleteRate.getBuildStageCompleteContent());
        return convertView;
    }

}

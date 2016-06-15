package com.yijia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yijia.bean.step;
import com.yijia.myapplication.R;

import java.util.List;

/**
 * Created by laz on 2016/5/27.
 */
public class MyBuildStageDetailAdagpter extends BaseAdapter {
    List<step> mList;
    Context mContext;
    LayoutInflater mInflater;

    public MyBuildStageDetailAdagpter(List<step> list, Context context) {
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
        TextView stagename;
        TextView stagedetailinfo;
        TextView mTextstatu;
        ImageView ifcomplete;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            //说明是第一次绘制满屏
            //找到每一行的布局
            convertView=mInflater.inflate(R.layout.build_stage_item,null);
            viewHolder=new ViewHolder();
            //初始化当前行布局中的所有控件
            viewHolder.stagename= (TextView) convertView.findViewById(R.id.build_stagename);
            viewHolder.stagedetailinfo= (TextView) convertView.findViewById(R.id.stage_detailinfo);
            viewHolder.mTextstatu= (TextView) convertView.findViewById(R.id.stagestartdate);
            viewHolder.ifcomplete= (ImageView) convertView.findViewById(R.id.ifcomplete);
            //把当前的控件缓存到布局视图中
            convertView.setTag(viewHolder);
        }else {
            //说明开始上下滑动，后面的所有行的布局采用第一次绘制时的缓存布局
            viewHolder= (ViewHolder) convertView.getTag();
        }
        step step1=mList.get(position);
        viewHolder.stagename.setText(step1.getStepname());
        viewHolder.stagedetailinfo.setText(step1.getStepcontent());
        viewHolder.mTextstatu.setText(step1.getStatu());
        if(step1.getStatu().equals("完成")){
            viewHolder.ifcomplete.setImageResource(R.mipmap.complete);
        }
        else {
            viewHolder.ifcomplete.setImageResource(R.mipmap.uncomplete);
        }

        return convertView;
    }
}

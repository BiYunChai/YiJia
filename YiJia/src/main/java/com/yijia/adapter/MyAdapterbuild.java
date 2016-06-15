package com.yijia.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yijia.bean.Build;
import com.yijia.beans.MyBuild;
import com.yijia.myapplication.R;

import java.util.List;

/**
 * Created by laz on 2016/5/23.
 */
public class MyAdapterbuild extends BaseAdapter {
    List<Build> mList;
    Context mContext;
    LayoutInflater mInflater;

    public MyAdapterbuild(List<Build> list, Context context) {
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
        TextView textView_build;
        TextView textView_date;
    }
    /**
     * 指定列表中每一行的布局，并且为每一行中布局的控件赋初值
     * @param position 当前绘制的是第几行界面，从0开始
     * @param convertView 缓存视图的一个类
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            //说明是第一次绘制满屏
            //找到每一行的布局
            convertView=mInflater.inflate(R.layout.item,null);
            viewHolder=new ViewHolder();
            //初始化当前行布局中的所有控件
           viewHolder.textView_build= (TextView) convertView.findViewById(R.id.textview_build);
           viewHolder.textView_date= (TextView) convertView.findViewById(R.id.textview_date);
            //把当前的控件缓存到布局视图中
            convertView.setTag(viewHolder);
        }else {
            //说明开始上下滑动，后面的所有行的布局采用第一次绘制时的缓存布局...
      viewHolder= (ViewHolder) convertView.getTag();
        }
        Build myBuild=mList.get(position);
        viewHolder.textView_build.setText(myBuild.getBuildname());
        viewHolder.textView_date.setText("2016-05-05");
        Log.e("cby-MyAdapterbuild",myBuild.getBuildname());
        return convertView;
    }
}

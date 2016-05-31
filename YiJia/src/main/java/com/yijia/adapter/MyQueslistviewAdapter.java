package com.yijia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yijia.beans.MyBuild;
import com.yijia.beans.MyQuestionData;
import com.yijia.myapplication.R;

import java.util.List;

/**
 * Created by laz on 2016/5/27.
 */
public class MyQueslistviewAdapter extends BaseAdapter {
    List<MyQuestionData> mList;
    Context mContext;
    LayoutInflater mInflater;

    public MyQueslistviewAdapter(List<MyQuestionData> list, Context context) {
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
        ImageView usertouxiang;
        TextView username;
        TextView questextview;
        TextView datetextview;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            //说明是第一次绘制满屏
            //找到每一行的布局
            convertView=mInflater.inflate(R.layout.itemquestion,null);
            viewHolder=new ViewHolder();
            //初始化当前行布局中的所有控件
            viewHolder.usertouxiang= (ImageView) convertView.findViewById(R.id.usertouxiang);
            viewHolder.username= (TextView) convertView.findViewById(R.id.username);
            viewHolder.questextview= (TextView) convertView.findViewById(R.id.quescontent);
            viewHolder.datetextview= (TextView) convertView.findViewById(R.id.quesdate);
            //把当前的控件缓存到布局视图中
            convertView.setTag(viewHolder);
        }else {
            //说明开始上下滑动，后面的所有行的布局采用第一次绘制时的缓存布局
            viewHolder= (ViewHolder) convertView.getTag();
        }
        MyQuestionData myQuestionData=mList.get(position);
        viewHolder.usertouxiang.setImageResource(myQuestionData.getUserpic());
        viewHolder.username.setText(myQuestionData.getUsername());
        viewHolder.questextview.setText(myQuestionData.getQuestext());
        viewHolder.datetextview.setText(myQuestionData.getDate());
        return convertView;
    }
}

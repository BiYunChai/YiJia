package com.yijia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yijia.bean.Knowledge;
import com.yijia.myapplication.R;

import java.util.List;

/**
 * Created by Administrator on 2016/6/1.
 */
public class KnowledgeAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    Context mContext;
    List<Knowledge> list;

    public KnowledgeAdapter(Context mContext, List<Knowledge> list) {
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
        TextView title;
        TextView content;
        ImageView knowledgepic;
        TextView ktime;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        //找到每一行的布局
        if (convertView == null){
            //说明是第一次绘制整屏列表，例如1-6行
            convertView =mInflater.inflate(R.layout.knowledgeitem,null);
            viewHolder = new ViewHolder();
            //初始化当前行布局中的所有控件
            viewHolder.ktime= (TextView) convertView.findViewById(R.id.time);
            viewHolder.title= (TextView) convertView.findViewById(R.id.title);
            viewHolder.knowledgepic= (ImageView) convertView.findViewById(R.id.knowledgepic);
            viewHolder.content= (TextView) convertView.findViewById(R.id.content);
            //把当前的控件缓存到布局视图中
            convertView.setTag(viewHolder);

        } else {
            //说明开始上下滑动，后面的所有行布局采用第一次绘制时的缓存布局
            viewHolder = (ViewHolder) convertView.getTag();
        }

//
//        ImageView img;
        final Knowledge knowledge = list.get(position);
        //加载网络图片
        Glide.with(mContext)
                .load(knowledge.getKnowledgepic())
                .into(viewHolder.knowledgepic);
        viewHolder.title.setText(knowledge.getTitle());
        viewHolder.content.setText(knowledge.getContent());
        viewHolder.ktime.setText(knowledge.getKtime()+"");

        return convertView;
    }

}
package com.yijia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yijia.bean.TestData;
import com.yijia.bean.Theme;
import com.yijia.myapplication.R;

import java.util.List;

/**
 * Created by Administrator on 2016/5/31.
 */
public class ThemetypeAdpter extends BaseAdapter {
    LayoutInflater mInflater;
    Context mContext;
    List<Theme> list;

    public ThemetypeAdpter(Context mContext, List<Theme> list) {
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
        TextView decription;

        ImageView pic;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        //找到每一行的布局
        if (convertView == null){
            //说明是第一次绘制整屏列表，例如1-6行
            convertView =mInflater.inflate(R.layout.themetypeitem,null);
            viewHolder = new ViewHolder();
            //初始化当前行布局中的所有控件
            viewHolder.title= (TextView) convertView.findViewById(R.id.title);
            viewHolder.decription= (TextView) convertView.findViewById(R.id.decription);
            viewHolder.pic= (ImageView) convertView.findViewById(R.id.pic);

            //把当前的控件缓存到布局视图中
            convertView.setTag(viewHolder);

        } else {
            //说明开始上下滑动，后面的所有行布局采用第一次绘制时的缓存布局
            viewHolder = (ViewHolder) convertView.getTag();
        }

//
//        ImageView img;
        final Theme theme = list.get(position);
        //加载网络图片
        Glide.with(mContext)
                .load(theme.getPic())
                .into(viewHolder.pic);


        //viewHolder.pic.setImageResource(R.drawable.pic1);
        //  viewHolder.pic.setImageDrawable();
        viewHolder.title.setText(theme.getTitle());
        viewHolder.decription.setText(theme.getDescription());


        return convertView;
    }

}

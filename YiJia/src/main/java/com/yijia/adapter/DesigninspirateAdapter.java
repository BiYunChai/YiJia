package com.yijia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yijia.beans.DesignData;
import com.yijia.myapplication.R;

import java.util.List;

/**
 * Created by laz on 2016/6/8.
 */
public class DesigninspirateAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    Context mContext;
    List<DesignData> list;

    public DesigninspirateAdapter(Context context, List<DesignData> list) {
        mContext = context;
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
    class ViewHolder{
        TextView design_title;
        TextView designer;
        TextView design_style;
        TextView design_squae;
        TextView design_price;
        TextView design_type;
        TextView design_buildaddress;
        TextView design_inspire;
        ImageView design_pic;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            //说明是第一次绘制满屏
            //找到每一行的布局
            convertView=mInflater.inflate(R.layout.design_program_item,null);
            viewHolder=new ViewHolder();
            //初始化当前行布局中的所有控件
            viewHolder.design_title= (TextView) convertView.findViewById(R.id.design_title);
            viewHolder.designer= (TextView) convertView.findViewById(R.id.designer);
            viewHolder.design_style= (TextView) convertView.findViewById(R.id.design_style);
            viewHolder.design_squae= (TextView) convertView.findViewById(R.id.design_square);
            viewHolder.design_price= (TextView) convertView.findViewById(R.id.design_price);
            viewHolder.design_type= (TextView) convertView.findViewById(R.id.design_type);
            viewHolder.design_buildaddress= (TextView) convertView.findViewById(R.id.design_buildname);
            viewHolder.design_inspire= (TextView) convertView.findViewById(R.id.design_inspirate);
            viewHolder.design_pic= (ImageView) convertView.findViewById(R.id.design_pic);
            //把当前的控件缓存到布局视图中
            convertView.setTag(viewHolder);
        }else {
            //说明开始上下滑动，后面的所有行的布局采用第一次绘制时的缓存布局...
            viewHolder= (ViewHolder) convertView.getTag();
        }
        DesignData designData=list.get(position);
        viewHolder.design_title.setText(designData.getDesign_title());
        viewHolder.designer.setText(designData.getDesigner());
        viewHolder.design_style.setText(designData.getDesign_style());
        viewHolder.design_squae.setText(designData.getDesign_square());
        viewHolder.design_price.setText(designData.getDesign_price());
        viewHolder.design_type.setText(designData.getDesign_type());
        viewHolder.design_buildaddress.setText(designData.getDesign_buildaddress());
        viewHolder.design_inspire.setText(designData.getDesign_inspire());
        viewHolder.design_pic.setImageResource(designData.getDesign_pic());

        return convertView;
    }
}

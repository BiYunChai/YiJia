package com.yijia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yijia.bean.GoodsDetail;
import com.yijia.bean.Recommend;
import com.yijia.myapplication.R;

import java.util.List;

/**
 * Created by Administrator on 2016/6/3.
 */
public class GoodsDetailAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    Context mContext;
    List<GoodsDetail> list;

    public GoodsDetailAdapter(Context mContext, List<GoodsDetail> list) {
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

    class ViewHolder{

        ImageView pic;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null){

            convertView =mInflater.inflate(R.layout.goodsdetailitem,null);
            viewHolder = new ViewHolder();


            viewHolder.pic= (ImageView) convertView.findViewById(R.id.goodsdetailpic);


            convertView.setTag(viewHolder);

        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        final GoodsDetail goodsDetail = list.get(position);
        //加载网络图片
        String imgUrl=goodsDetail.getDatailURL();
        Glide.with(mContext)
                .load(imgUrl)
                .thumbnail(0.5f)
                .into(viewHolder.pic);
        return convertView;
    }

}


package com.yijia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yijia.bean.Theme;
import com.yijia.myapplication.R;

import java.util.List;

/**
 * Created by Administrator on 2016/6/11.
 */
public class NewThemeAdapter extends BaseAdapter{
    LayoutInflater mInflater;
    Context mContext;
    List<Theme> list;

    public NewThemeAdapter(Context mContext, List<Theme> list) {
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
        TextView title;
        TextView decription;

        ImageView pic;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null){

            convertView =mInflater.inflate(R.layout.newlthemelistitem,null);
            viewHolder = new ViewHolder();
            viewHolder.title= (TextView) convertView.findViewById(R.id.newtitle);
            viewHolder.decription= (TextView) convertView.findViewById(R.id.newdecription);
            viewHolder.pic= (ImageView) convertView.findViewById(R.id.newpic);
            convertView.setTag(viewHolder);

        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }


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

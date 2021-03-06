package com.yijia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yijia.bean.Post_comment;
import com.yijia.myapplication.R;

import java.util.List;

/**
 * Created by Administrator on 2016/6/7.
 */
public class Post_CommentAdapter extends BaseAdapter{
    List<Post_comment> mlist;
    LayoutInflater mInflater;
    Context mContext;

    public Post_CommentAdapter(Context context,List<Post_comment> mlist) {
        this.mContext=context;
        this.mlist = mlist;
        mInflater=LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder{
        TextView mComment_name;
        TextView mComment_content;
        TextView mComment_time;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        //找到每一行的布局
        if (convertView == null){
            //说明是第一次绘制整屏列表，例如1-6行
            convertView =mInflater.inflate(R.layout.forum_postcomment_item,null);
            viewHolder = new ViewHolder();
            //初始化当前行布局中的所有控件
            viewHolder.mComment_name= (TextView) convertView.findViewById(R.id.commentuser);
            viewHolder.mComment_content= (TextView) convertView.findViewById(R.id.comment_content);
            viewHolder.mComment_time= (TextView) convertView.findViewById(R.id.comment_time);

            //把当前的控件缓存到布局视图中
            convertView.setTag(viewHolder);

        } else {
            //说明开始上下滑动，后面的所有行布局采用第一次绘制时的缓存布局
            viewHolder = (ViewHolder) convertView.getTag();
        }


        final Post_comment post_comment = mlist.get(position);
        viewHolder.mComment_name.setText(post_comment.getComm_username());
        viewHolder.mComment_content.setText(post_comment.getComm_content());
        viewHolder.mComment_time.setText(post_comment.getDate());

        return convertView;
    }
}

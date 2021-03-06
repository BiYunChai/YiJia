package com.yijia.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.w4lle.library.NineGridAdapter;
import com.w4lle.library.NineGridlayout;
import com.yijia.bean.Post;
import com.yijia.bean.Postimg;
import com.yijia.myapplication.R;
import com.yijia.myapplication.forum_commentActivity;

import java.util.List;

/**
 * Created by Administrator on 2016/6/6.
 */
public class ForumCommentHeader_list_Adapter extends BaseAdapter {
    LayoutInflater mInflater;
    Context mContext;
    List<Post> mlist;
    private PicAdapter mPicAdapter;
    private boolean forum_flag=false;
    private boolean commentlayout=false;
    ImageView mforum_favour;
    ImageButton mButtonforum_comment;
    public ForumCommentHeader_list_Adapter(Context mContext, List<Post> list) {

        this.mContext = mContext;

        this.mlist = list;
        mInflater=LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        Log.e("frumcomment_postsize",mlist.size()+"");

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
        ImageView userphoto;
        TextView usernickname;
        TextView postcontent;
        TextView time;
        NineGridlayout mNineGridlayout;


    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        List<Postimg> imglist=mlist.get(position).getPostimgs();



        if (convertView == null){

            convertView =mInflater.inflate(R.layout.forumcomment_header_item,null);
            viewHolder = new ViewHolder();

            viewHolder.userphoto= (ImageView) convertView.findViewById(R.id.forumcomment_detail_userimg);
            viewHolder.usernickname= (TextView) convertView.findViewById(R.id.forumcomment_detail_username);
            viewHolder.postcontent= (TextView) convertView.findViewById(R.id.commentpost_detail_content);
            viewHolder.time= (TextView) convertView.findViewById(R.id.commentpost_detail_time);
            viewHolder.mNineGridlayout= (NineGridlayout) convertView.findViewById(R.id.forumcomment_detail_pic);


            convertView.setTag(viewHolder);

        } else {
            //说明开始上下滑动，后面的所有行布局采用第一次绘制时的缓存布局
            viewHolder = (ViewHolder) convertView.getTag();
        }

//
//

         final Post post=mlist.get(position);

//        Log.e("url",post.getUserphoto());
        Glide.with(mContext)
                .load(post.getUserphoto())
                .into(viewHolder.userphoto);
        viewHolder.usernickname.setText(post.getUsername());
        viewHolder.postcontent.setText(post.getContent());
        viewHolder.time.setText(post.getDate());
        if (imglist.isEmpty()) {
            viewHolder.mNineGridlayout.setVisibility(View.GONE);
        } else {
            viewHolder.mNineGridlayout.setVisibility(View.VISIBLE);
            handlerOneImage(viewHolder, imglist);
        }






        return convertView;
    }

    private void handlerOneImage(ViewHolder viewHolder, List<Postimg> image) {
        mPicAdapter = new PicAdapter(mContext, image);
        viewHolder.mNineGridlayout.setAdapter(mPicAdapter);
        viewHolder.mNineGridlayout.setOnItemClickListerner(new NineGridlayout.OnItemClickListerner() {
            @Override
            public void onItemClick(View view, int position) {
                //do some thing
               Log.e("onItemClick : " , position+"");
            }
        });
    }

    class PicAdapter extends NineGridAdapter {

        public PicAdapter(Context context, List list) {
            super(context, list);
        }

        @Override
        public int getCount() {
            return (list == null) ? 0 : list.size();
        }

        @Override
        public String getUrl(int position) {
            return getItem(position) == null ? null : ((Postimg)getItem(position)).getPicurl();
        }

        @Override
        public Object getItem(int position) {
            return (list == null) ? null : list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int i, View view) {
            ImageView iv = null;
            if (view != null && view instanceof ImageView) {
                iv = (ImageView) view;
            } else {
                iv = new ImageView(context);
            }
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iv.setBackgroundColor(context.getResources().getColor((android.R.color.transparent)));
            String url = getUrl(i);
            Log.e("test",url);
            Glide.with(mContext)
                    .load(getUrl(i))
                    .into(iv);

            if (!TextUtils.isEmpty(url)) {
                iv.setTag(url);
            }
            return iv;
        }
    }
}

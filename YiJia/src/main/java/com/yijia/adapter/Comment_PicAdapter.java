package com.yijia.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.w4lle.library.NineGridAdapter;
import com.yijia.bean.Postimg;

import java.util.List;

/**
 * Created by Administrator on 2016/6/7.
 */
public class Comment_PicAdapter  extends NineGridAdapter{
    private Context mContext;
    private List<Postimg> image;


    public Comment_PicAdapter(Context context, List list) {
        super(context, list);
        this.mContext=context;
        this.image=list;
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
            // Picasso.with(context).load(getUrl(i)).placeholder(new ColorDrawable(Color.parseColor("#f5f5f5"))).into(iv);
            if (!TextUtils.isEmpty(url)) {
                iv.setTag(url);
            }
            return iv;
        }

}

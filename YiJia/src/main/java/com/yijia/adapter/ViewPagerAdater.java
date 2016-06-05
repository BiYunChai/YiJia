package com.yijia.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2016/5/25.
 * 首页轮播图适配器
 */
public class ViewPagerAdater extends PagerAdapter {
    private List<ImageView> images;
    public ViewPagerAdater(List<ImageView> images){
        this.images=images;

    }
    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public void destroyItem(ViewGroup view, int position, Object object) {
        // TODO Auto-generated method stub

        view.removeView(images.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        // TODO Auto-generated method stub
        view.addView(images.get(position));
        return images.get(position);
    }
}

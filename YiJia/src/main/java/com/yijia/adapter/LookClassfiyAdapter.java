package com.yijia.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/6/2.
 */
public class LookClassfiyAdapter extends PagerAdapter {
    private List<TextView> classfiyList;
    public LookClassfiyAdapter(List<TextView> classfiyList){
        this.classfiyList=classfiyList;

    }
    @Override
    public int getCount() {
        return classfiyList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public void destroyItem(ViewGroup view, int position, Object object) {
        // TODO Auto-generated method stub

        view.removeView(classfiyList.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        // TODO Auto-generated method stub
        view.addView(classfiyList.get(position));
        return classfiyList.get(position);
    }
}


package com.yijia.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2016/5/31.
 * 禁止viewpager左右切换
 */
public class MyViewPager extends ViewPager {
    private boolean isCanScroll = false;
    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewPager(Context context) {
        super(context);
    }
    public void setScanScroll(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if(isCanScroll){
            return super.onInterceptTouchEvent(arg0);
        }else{
            //false  不能左右滑动
            return false;
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        // TODO Auto-generated method stub
        if (isCanScroll) {
            return super.onTouchEvent(arg0);
        } else {
            return false;
        }

    }

}

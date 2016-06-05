package com.yijia.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yijia.adapter.HomeListAdapter;
import com.yijia.adapter.ViewPagerAdater;

import com.yijia.bean.Recommend;

import com.yijia.myapplication.BookActivity;
import com.yijia.myapplication.CalcuatorActivity;
import com.yijia.myapplication.CalendarActivity;
import com.yijia.myapplication.CompanyActivity;
import com.yijia.myapplication.DesignApplyActivity;
import com.yijia.myapplication.PicDetailActivity;
import com.yijia.myapplication.R;
import com.yijia.myapplication.SafeActivity;
import com.yijia.myapplication.ServiceActivity;
import com.yijia.myapplication.ThemeActivity;
import com.yijia.utils.HttpUrl;
import com.yijia.utils.ImgURL;


import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/5/13.
 */
public class HomeFragment extends Fragment{
    /**
     *  轮播图部分
     */
    private static final int INT = 0;

    private static final String TAG="homefragment出错了。。。";
    private static final String TAG2 = "刷新失败";
    //listview与ArrayList相差1，addheader后差2
    private static final int DIFFER = 2;

    private ViewPager mViewPaper;
    private List<ImageView> images;
    private List<View> dots;
    private int currentItem;
    //记录上一次点的位置
    private int oldPosition = 0;
    //存放图片的id
    private String[] imageIds = new String[]{ImgURL.ADONE,ImgURL.ADTWO,ImgURL.ADTHREE,ImgURL.ADFOUR,ImgURL.ADFIVE};

    private ViewPagerAdater adater;
    private ScheduledExecutorService scheduledExecutorService;
    /**
     * ListView部分
     */
    private String homelisturl=HttpUrl.HOME_LIST_URL;
    List<Recommend> mRecoList=new ArrayList<>();
    //List<Recommend> mLoadListData;
    HomeListAdapter mHomeListAdapter;
    PullToRefreshListView mListView;

    ImageView mDesignView;
    ImageView mSafeView;
    ImageView mCompsnyView;
    ImageView mCalcuatorView;
    ImageView mbookView;
    ImageView mThemeView;
    ImageView mCalendarView;
    ImageView mServiceView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home,null);
        View viewheader=inflater.inflate(R.layout.homehead,null);
        /**
         * 轮播图部分
         */
        //初始化轮播图控件
        initlunbopicview(viewheader);
        //初始化轮播图数据
        initlunbopicData(viewheader);
        //setadapter
        initlunboAdapter();
        //设置监听
        initlunboLishener();
        /**
         * listview部分
         */
        //初始化listview控件
        initListDataView(view);
        //初始化功能部件
        initFunctionView(viewheader);
        //功能事件监听
        initFunctionListen();
        //添加头部
        initListHeader(viewheader);
        //初始化数据
        initListData();
     //   initListAdapter();

        return view;
    }




    /**
     *
     * 轮播图部分
     */

    private void initlunbopicview(View view) {
        mViewPaper= (ViewPager) view.findViewById(R.id.vp);
    }
    private void initlunbopicData(View view) {
        //显示的图片
        images = new ArrayList<>();


        for(int i = 0; i < imageIds.length; i++){
            ImageView imageView = new ImageView(getContext());
            Glide.with(getContext())
                    .load(imageIds[i])
                    .thumbnail(0.5f)
                    .into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
           images.add(imageView);
        }
        //显示的小点
        dots = new ArrayList<>();
        dots.add(view.findViewById(R.id.dot_0));
        dots.add(view.findViewById(R.id.dot_1));
        dots.add(view.findViewById(R.id.dot_2));
        dots.add(view.findViewById(R.id.dot_3));
        dots.add(view.findViewById(R.id.dot_4));

    }
    private void initlunboAdapter()
    {
        adater=new ViewPagerAdater(images);
        mViewPaper.setAdapter(adater);
    }
    private void initlunboLishener() {
        mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageSelected(int position) {


                dots.get(position).setBackgroundResource(R.mipmap.dot_focused);
                dots.get(oldPosition).setBackgroundResource(R.mipmap.dot_normal);

                oldPosition = position;
                currentItem = position;


            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });


    }
    /**
     * 利用线程池定时执行动画轮播
     * command：执行线程
     * initialDelay：初始化延时
     * period：前一次执行结束到下一次执行开始的间隔时间（间隔执行延迟时间）
     * unit：计时单位
     */
    @Override
    public void onStart() {
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPageTask(),
                3,
                3,
                TimeUnit.SECONDS);
    }
    /**
     * 图片轮播任务
     *
     *
     */
    private class ViewPageTask implements Runnable{

        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            mHandler.sendEmptyMessage(INT);
        }
    }

    /**
     * 接收子线程传递过来的数据
     */
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg)
        {
            int what=msg.what;
            switch (what){
                case  INT:
                    mViewPaper.setCurrentItem(currentItem,false);
            }

        }

    };

    @Override
    public void onStop() {
        super.onStop();
        if(scheduledExecutorService != null){
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }
    }


    /**
     * listview部分
     *
     *
     */

    private void initListDataView(View view) {
        mListView= (PullToRefreshListView) view.findViewById(R.id.homelistview_pulltorefresh);
    }
    private void initListHeader(View viewheader) {


        //pulltorefresh没有addHeaderView方法 ，但内部有listview
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT);
        viewheader.setLayoutParams(layoutParams);
        ListView lv=mListView.getRefreshableView();

        lv.addHeaderView(viewheader);
    }
    private void initFunctionView(View viewheader){
        mDesignView= (ImageView) viewheader.findViewById(R.id.homestyledesign);
        mSafeView= (ImageView) viewheader.findViewById(R.id.safe);
        mCompsnyView= (ImageView) viewheader.findViewById(R.id.company);
        mCalcuatorView= (ImageView) viewheader.findViewById(R.id.calcuator);
        mbookView= (ImageView) viewheader.findViewById(R.id.book);
        mThemeView= (ImageView) viewheader.findViewById(R.id.thene);
        mCalendarView= (ImageView) viewheader.findViewById(R.id.calendar);
        mServiceView= (ImageView) viewheader.findViewById(R.id.service);




    }
    //设置监听
    public void initFunctionListen(){
        //户型设计
        mDesignView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(),DesignApplyActivity.class);
                startActivity(intent);
                //intent.setClassName(, DesignApplyActivity.class);
            }
        });
        //装修保障
        mSafeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), SafeActivity.class);
                startActivity(intent);
                //Toast.makeText(getContext(),"单击了",Toast.LENGTH_LONG).show();
            }
        });
        //装修公司
        mCompsnyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), CompanyActivity.class);
                startActivity(intent);
            }
        });
        //计算器
        mCalcuatorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), CalcuatorActivity.class);
                startActivity(intent);
                //Toast.makeText(getContext(),"单击了",Toast.LENGTH_LONG).show();
            }
        });
        //装修知识
        mbookView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), BookActivity.class);
                startActivity(intent);
                //Toast.makeText(getContext(),"单击了",Toast.LENGTH_LONG).show();
            }
        });
        //精品专题
        mThemeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), ThemeActivity.class);
                startActivity(intent);
            }
        });
        //日历
        mCalendarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), CalendarActivity.class);
                startActivity(intent);
            }
        });
        //客服
        mServiceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), ServiceActivity.class);
                startActivity(intent);
            }
        });



    }


    public void initListData(){
        RequestParams params=new RequestParams(HttpUrl.HOME_LIST_URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //访问网络成功
               // Gson gson=new Gson();
                Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
                //

                Type type=new TypeToken<List<Recommend>>(){}.getType();
                List<Recommend> recoList;
                //接受网络数据
                recoList=gson.fromJson(result.toString(),type);
                for (Recommend recommend :recoList) {
                    int id=recommend.getId();
                    String imgaddress=recommend.getImgaddress();
                    String topic=recommend.getTopic();
                    String designer=recommend.getDesigner();
                    Date rectime=recommend.getRectime();
                    Recommend reco=new Recommend(id,imgaddress,topic,designer,rectime);
                    mRecoList.add(reco);
                }

                //网络请求是异步操作，保证请求完成后再设置适配器

                mHomeListAdapter=new HomeListAdapter(getContext(),mRecoList);
                mListView.setAdapter(mHomeListAdapter);


                //设置上拉加载下拉刷新组件和事件监听
                //设置刷新模式为BOTH才可以上拉和下拉都能起作用,必须写在前面
                mListView.setMode(PullToRefreshBase.Mode.BOTH);
                //设置刷新时头部的状态
                initRefreshListView();
                //设置上拉和下拉时候的监听器
                mListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                    //下拉时
                    @Override
                    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                        new RefreshDataAsyncTask(HomeFragment.this).execute();//执行下载数据
                    }
                    @Override
                    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                        new LoadDataAsyncTask(HomeFragment.this).execute();
                    }
                });
                //list点击事件监听
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //测试
                       /* Recommend recommend=mRecoList.get(position-DIFFER);
                        Log.e("listview下标",recommend.getId()+"");
                        Toast.makeText(getContext(),"单击了数据库中pic_id为"+recommend.getId()+"的数据",Toast.LENGTH_LONG).show();*/
                        Intent intent=new Intent(getActivity(), PicDetailActivity.class);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.d(TAG,ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }




    //模拟数据
    //刷新数据，暂不能用
    private void refreshData() {
       //刷新加载最新数据
        //暂不能使用
       /* RequestParams params=new RequestParams(HttpUrl.HOME_LIST_URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //访问网络成功
                // Gson gson=new Gson();
                Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
                Type type=new TypeToken<List<Recommend>>(){}.getType();
                List<Recommend> recoList;
                //接受网络数据
                recoList=gson.fromJson(result.toString(),type);
                //每次刷新时从第0条加入
                int i=0;
                for (Recommend recommend :recoList) {
                    String imgaddress=recommend.getImgaddress();
                    String topic=recommend.getTopic();
                    String designer=recommend.getDesigner();
                    Date rectime=recommend.getRectime();

                    Recommend reco=new Recommend(imgaddress,topic+"刷新",designer,rectime);

                    mRecoList.add(i,reco);
                    i=i+1;
                }

                //网络请求是异步操作，保证请求完成后再设置适配器

                mHomeListAdapter=new HomeListAdapter(getContext(),mRecoList);
                mListView.setAdapter(mHomeListAdapter);


                //设置上拉加载下拉刷新组件和事件监听
                //设置刷新模式为BOTH才可以上拉和下拉都能起作用,必须写在前面
                mListView.setMode(PullToRefreshBase.Mode.BOTH);
                //设置刷新时头部的状态
                initRefreshListView();
                //设置上拉和下拉时候的监听器
                mListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                    //下拉时
                    @Override
                    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                        new RefreshDataAsyncTask(HomeFragment.this).execute();//执行下载数据
                    }
                    @Override
                    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                        new LoadDataAsyncTask(HomeFragment.this).execute();
                    }
                });
                //list点击事件监听
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getContext(),"单击了"+(position)+"行",Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.d(TAG,ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
*/
    }
    //加载数据
    int page=1;
    public void loadData() {

        page=page+1;
        RequestParams params=new RequestParams(HttpUrl.HomeListLoad(page));
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                // Gson gson=new Gson();
                Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

                Type type=new TypeToken<List<Recommend>>(){}.getType();
                List<Recommend> recoList;
                recoList=gson.fromJson(result.toString(),type);
                for (Recommend recommend :recoList) {
                    int id=recommend.getId();
                    String imgaddress=recommend.getImgaddress();
                    String topic=recommend.getTopic();
                    String designer=recommend.getDesigner();
                    Date rectime=recommend.getRectime();
                    Recommend reco=new Recommend(id,imgaddress,topic+"新",designer,rectime);
                    mRecoList.add(reco);
                }




            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.d(TAG2,ex.getMessage());
            }


            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }
    static class RefreshDataAsyncTask extends AsyncTask<Void, Void, String> {//定义返回值的类型
      //后台处理
      private HomeFragment homeFragment;

      public RefreshDataAsyncTask(HomeFragment homeFragment) {
          this.homeFragment = homeFragment;
      }
      @Override
      protected String doInBackground(Void... params) {
          //用一个线程来模拟刷新
          try {
              Thread.sleep(2000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          //加载数据
          homeFragment.refreshData();
          return "success";
      }

      //  onPostExecute（）是对返回的值进行操作
      @Override
      protected void onPostExecute(String s) {
          super.onPostExecute(s);
          if (s.equals("success")) {
              homeFragment.mHomeListAdapter.notifyDataSetChanged();//通知数据集改变,界面刷新
              homeFragment.mListView.onRefreshComplete();//表示刷新完成
          }
      }
  }



    static class LoadDataAsyncTask extends AsyncTask<Void, Void, String> {//定义返回值的类型
        //后台处理
        private HomeFragment homeFragment;
        //

        public LoadDataAsyncTask(HomeFragment homeFragment) {
            this.homeFragment = homeFragment;
        }
        @Override
        protected String doInBackground(Void... params) {
            //用一个线程来模拟刷新
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //加载数据
            homeFragment.loadData();
            return "success";
        }

        //  onPostExecute（）是对返回的值进行操作
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s.equals("success")) {
                //

                homeFragment.mHomeListAdapter.notifyDataSetChanged();//通知数据集改变,界面刷新

                homeFragment.mListView.onRefreshComplete();//表示刷新完成

            }
        }
    }

    public void initRefreshListView() {
        ILoadingLayout startLabels = mListView.getLoadingLayoutProxy(true, false);
        startLabels.setPullLabel("下拉刷新");
        startLabels.setRefreshingLabel("正在拉");
        startLabels.setReleaseLabel("放开刷新");
        ILoadingLayout endLabels = mListView.getLoadingLayoutProxy(false, true);
        endLabels.setPullLabel("上拉加载");
        endLabels.setRefreshingLabel("正在载入...");
        endLabels.setReleaseLabel("放开加载...");
    }

}

package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yijia.adapter.NewThemeAdapter;
import com.yijia.bean.RecommendDetail;
import com.yijia.bean.Theme;
import com.yijia.bean.ThemePicDetail;
import com.yijia.utils.HttpUrl;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NewThemeActivity extends AppCompatActivity {

    NewThemeAdapter mNewThemeAdapter;
    PullToRefreshListView mPullToRefreshListView;
    Spinner typeSpinner;
    Spinner houSpinner;
    List<Theme> mList=new ArrayList<>();
    ArrayAdapter<String>  typeAdapter;
    ArrayAdapter<String>  houseAdapter;
    private String[] type={"风格","全部","现代","欧式","田园","古典","混搭"};
    private String[] house={"户型","不限","一居","三居","小户型","公寓","别墅"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_theme);
        initview();
        initData();
        initListener();
        initListListener();
    }

    private void initListListener() {
        mPullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Gson gson=new Gson();
                List<ThemePicDetail> themePicDetails=mList.get(position-1).getmThemePicDetailList();
                String result=gson.toJson(themePicDetails);
                Intent intent=new Intent(NewThemeActivity.this, ThemeDatailActivity.class);
                intent.putExtra("themedetail",result);
                startActivity(intent);
            }
        });
    }


    private void initview() {
        typeSpinner= (Spinner) findViewById(R.id.typespinner);
        houSpinner= (Spinner) findViewById(R.id.housespinner);
        mPullToRefreshListView= (PullToRefreshListView) findViewById(R.id.newthemelistview);
        typeAdapter=new ArrayAdapter<String>(NewThemeActivity.this,android.R.layout.simple_list_item_1,type);
        houseAdapter=new ArrayAdapter<String>(NewThemeActivity.this,android.R.layout.simple_list_item_1,house);
        typeSpinner.setAdapter(typeAdapter);
        typeSpinner.setSelection(0,true);
        houSpinner.setAdapter(houseAdapter);
        houSpinner.setSelection(0,true);
    }
    private void initData() {
        RequestParams params=new RequestParams(HttpUrl.THEMEALL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Log.e("yun--",result);
                Gson gson=new Gson();
                Type type=new TypeToken<List<Theme>>(){}.getType();
                List<Theme> themelist;
                themelist=gson.fromJson(result,type);
                Log.e("yun",themelist.toString());
                for (Theme theme :themelist) {
                     int id= theme.getId();
                    String title=theme.getTitle();
                    String description=theme.getDescription();
                    String mainpic=theme.getPic();
                    List<ThemePicDetail> mThemePicDetails=theme.getmThemePicDetailList();
                    Theme theme1=new Theme(id,title,description,mainpic,mThemePicDetails);
                    mList.add(theme1);
                    Log.e("yun","添加数据");
                }
                mNewThemeAdapter=new NewThemeAdapter(NewThemeActivity.this,mList);
                mPullToRefreshListView.setAdapter(mNewThemeAdapter);
                mNewThemeAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
    private void changeData(){
        RequestParams params=new RequestParams(HttpUrl.THEMEALL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                mList.clear();
                Log.e("yun--",result);
                Gson gson=new Gson();
                Type type=new TypeToken<List<Theme>>(){}.getType();
                List<Theme> themelist;
                themelist=gson.fromJson(result,type);
                Log.e("yun",themelist.toString());
                for (Theme theme :themelist) {
                    int id= theme.getId();
                    String title=theme.getTitle();
                    String description=theme.getDescription();
                    String mainpic=theme.getPic();
                    List<ThemePicDetail> mThemePicDetails=theme.getmThemePicDetailList();
                    Theme theme1=new Theme(id,title,description,mainpic,mThemePicDetails);
                    mList.add(theme1);
                    Log.e("yun","添加数据");
                }
                mNewThemeAdapter=new NewThemeAdapter(NewThemeActivity.this,mList);
                mPullToRefreshListView.setAdapter(mNewThemeAdapter);
                mNewThemeAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }
    private void initListener() {

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selecttype=type[position];
                String kind="type";
                Toast.makeText(NewThemeActivity.this,"点击了"+selecttype,Toast.LENGTH_SHORT).show();
                if(selecttype.equals("全部")){
                   changeData();

                }
                changeData(HttpUrl.THEME_SELECTHOUSE,kind,selecttype);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        houSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selecthouse=house[position];
                String kind="house";
                Toast.makeText(NewThemeActivity.this,"点击了"+selecthouse,Toast.LENGTH_SHORT).show();
                if(selecthouse.equals("不限")){
                    initData();

                }
                changeData(HttpUrl.THEME_SELECTTYPE,kind,selecthouse);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void changeData(String url,String kind,String str) {

        RequestParams params=new RequestParams(url);

        params.addQueryStringParameter(kind,str);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                mList.clear();

                Gson gson=new Gson();
                Type type=new TypeToken<List<Theme>>(){}.getType();
                List<Theme> themelist;
                themelist=gson.fromJson(result,type);

                for (Theme theme :themelist) {
                    int id= theme.getId();
                    String title=theme.getTitle();
                    String description=theme.getDescription();
                    String mainpic=theme.getPic();
                    List<ThemePicDetail> mThemePicDetails=theme.getmThemePicDetailList();
                    Theme theme1=new Theme(id,title,description,mainpic,mThemePicDetails);
                    mList.add(theme1);

                }
                mNewThemeAdapter=new NewThemeAdapter(NewThemeActivity.this,mList);
                mPullToRefreshListView.setAdapter(mNewThemeAdapter);
                mNewThemeAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }





    public void backhome(View view) {
        finish();
    }
}

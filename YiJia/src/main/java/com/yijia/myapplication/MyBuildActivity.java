package com.yijia.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yijia.adapter.MyAdapterbuild;
import com.yijia.bean.Build;
import com.yijia.bean.step;
import com.yijia.utils.HttpUrl;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MyBuildActivity extends AppCompatActivity {
   private static final String LOGIN = "login";
    List<Build> mList=new ArrayList<>();
    MyAdapterbuild mAdapterbuild;
    ListView mListView;
    SharedPreferences mSharedPreferenceslogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.build);

        initview();
        initData();
        initlistener();



    }
    private void initlistener() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //parent代表整个listView,view表示当前行的视图，position表示用户单击了哪一行
                List<step> steps=mList.get(position).getSteps();

                Log.e("build",steps.toString());
                Intent intent=new Intent(MyBuildActivity.this,BuildStageActivity.class);
                Gson gson=new Gson();
                String result=gson.toJson(steps);
                intent.putExtra("build",result);
                startActivity(intent);
                //Toast.makeText(MyBuildActivity.this, "点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initview() {
        mListView= (ListView) findViewById(R.id.listview_build);
        mSharedPreferenceslogin=getSharedPreferences(LOGIN,MODE_PRIVATE);



    }
    private void initData() {
        Log.e("----------------","进入initData");
        boolean islogin=mSharedPreferenceslogin.getBoolean("islogin",false);
        Log.e("islogin","ok");
        if(!islogin){
          //Toast.makeText(MyBuildActivity.this, "还没有登录哦", Toast.LENGTH_SHORT).show();
        }
        else{
            //String username=mSharedPreferenceslogin.getString("username","error");
            String username=mSharedPreferenceslogin.getString("username","error");
            //String username="13140904592";
            RequestParams params=new RequestParams(HttpUrl.SEARCHBUILDING);
            params.addQueryStringParameter("username",username);
            x.http().get(params, new Callback.CommonCallback<String>() {

                @Override
                public void onSuccess(String result) {
                    Log.e("result",result);
                    Gson gson =new Gson();
                    Type type=new TypeToken<List<Build>>(){}.getType();
                    List<Build> buildList=gson.fromJson(result,type);
                    for (Build build:buildList) {
                        String name=build.getBuildname();
                        int id=build.getId();
                        List<step> steps=build.getSteps();
                        Build build1=new Build(id,name,steps);
                        mList.add(build1);
                    }
                    mAdapterbuild=new MyAdapterbuild(mList,MyBuildActivity.this);
                    mListView.setAdapter(mAdapterbuild);
                    Log.e("cby-initData",mList.toString());


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
       /* mList=new ArrayList<>();
        MyBuild b1=new MyBuild("我的新家1","2016-01-01");
        MyBuild b2=new MyBuild("我的新家2","2016-01-20");
        MyBuild b3=new MyBuild("我的新家3","2016-02-01");
        MyBuild b4=new MyBuild("我的新家4","2016-03-01");
        MyBuild b5=new MyBuild("我的新家5","2016-04-01");
        MyBuild b6=new MyBuild("我的新家6","2016-05-01");
        mList.add(b1);
        mList.add(b2);
        mList.add(b3);
        mList.add(b4);
        mList.add(b5);
        mList.add(b6);*/
   }

    public void backME(View view) {
        finish();
    }
}

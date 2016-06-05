package com.yijia.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * Created by Administrator on 2016/5/21 0021.
 */
public class WelcomeAty extends Activity {

    private boolean isfirstIn = false;
    private static final  int TIME = 2000;
    private static final  int GO_Home = 1000;
    private static final  int GO_GUID = 1001;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case GO_Home:
                    goHome();
                break;

                case GO_GUID:
                    goGuide();
                break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        init();
    }

    private  void init(){
        SharedPreferences preferences = getSharedPreferences("hyq",MODE_PRIVATE);
        isfirstIn = preferences.getBoolean("isfirstIn",true);
        if (!isfirstIn){
            handler.sendEmptyMessageDelayed(GO_Home,TIME);
        }else {
            handler.sendEmptyMessageDelayed(GO_GUID,TIME);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isfirstIn",false);
            editor.commit();

        }
    }
    private void goHome(){
        Intent intent = new Intent(WelcomeAty.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void goGuide(){
        Intent intent = new Intent(WelcomeAty.this,Guide.class);
        startActivity(intent);
        finish();
    }
}

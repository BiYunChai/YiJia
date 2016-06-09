package com.yijia.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

import java.util.Random;
import android.support.v7.app.AppCompatActivity;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;
/*
* 初始化SMSSDK
* 创建手机号注册页面
* 获取注册界面信息
* 提交验证信息
* 验证成功，显示成功
* */

public class RegisterActivity extends AppCompatActivity {
    Button getphonevertify;
    String APPKEY="138975429bd81";
    String APPSECRET="2591c2545fead72e26f8ea5471811029";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        /**
         *1，初始化SMSSDK
         * public static void initSDK(Context context,java.lang.String appkey,java.lang.String appSecrect,boolean warnOnReadContact)
         * @param context:上下文
         * @param appkey：我们在mob.com创建应用时候生成APP Key
         * @param appSecret：我们在mob.com创建应用时候生成APP Secret
         * @param warnOnReadContact: 是否警告在读取联系人
         */
        SMSSDK.initSDK(this,APPKEY,APPSECRET,true);
        getphonevertify= (Button) findViewById(R.id.getphonevertify);
        //设置点击事件
        getphonevertify.setOnClickListener(new View.OnClickListener() {
            //注册手机号
            @Override
            public void onClick(View v) {
                //创建手机号注册界面
                RegisterPage registerPage=new RegisterPage();
                //获取注册界面信息
                registerPage.setRegisterCallback(new EventHandler(){
                    //事件完成后调用
                    @Override
                    public void afterEvent(int event, int result, Object data) {
                       //判断是否已经完成
                        if (result==SMSSDK.RESULT_COMPLETE){
                            //获取数据data
                            HashMap<String,Object> maps= (HashMap<String, Object>) data;
                            //国家信息
                            String country= (String) maps.get("country");
                            //手机号信息
                            String phone= (String) maps.get("phone");
                            //提交验证信息
                            submitUserinfo(country,phone);
                        }
                    }
                });
                //验证成功，显示成功
                registerPage.show(RegisterActivity.this);
            }
        });
    }
//提交用户信息
    private void submitUserinfo(String country, String phone) {
        Random r=new Random();
        String uid=Math.abs(r.nextInt())+"";
        String nickname="YIJIA";
        SMSSDK.submitUserInfo(uid,nickname,null,country,phone);
    }

    public void back(View view) {
        finish();
    }
}

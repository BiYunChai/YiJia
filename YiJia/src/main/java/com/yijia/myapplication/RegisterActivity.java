package com.yijia.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Type;
import java.util.HashMap;

import java.util.List;
import java.util.Random;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yijia.bean.Recommend;
import com.yijia.fragment.HomeFragment;
import com.yijia.utils.HttpUrl;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

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
    EditText mPhoneEditText;
    EditText mPasswrodEditText;
    Button mRegisterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        initview();
        userRegister();
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

    private void userRegister() {
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=mPhoneEditText.getText().toString();
                String passwrod=mPasswrodEditText.getText().toString();
                RequestParams params=new RequestParams(HttpUrl.REGISTERURL);
                params.addBodyParameter("username",username);
                params.addBodyParameter("passwrod",passwrod);
                Log.e("username",username);
                Log.e("passwrod",passwrod);
                Log.e("url",params.toString());
                x.http().post(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if(result.equals("该用户已存在")){
                            Toast.makeText(RegisterActivity.this,"该账号已注册",Toast.LENGTH_LONG).show();

                        }
                        else{
                            Intent intent=new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);
                            Log.e("ok",result);}

                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("错误原因：", ex.getMessage() );
                        Toast.makeText(RegisterActivity.this,"无法访问网络，请稍后再试",Toast.LENGTH_LONG).show();



                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });


            }
        });
    }

    private void initview() {
        mPhoneEditText= (EditText) findViewById(R.id.phoneNum);
        mPasswrodEditText= (EditText) findViewById(R.id.register_password);
        mRegisterButton= (Button) findViewById(R.id.register_button);
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

   /* public void getUserRegisterInfo() {
        String username=mPhoneEditText.getText().toString();
        String passwrod=mPasswrodEditText.getText().toString();
        RequestParams params=new RequestParams(HttpUrl.REGISTERURL);
        params.addBodyParameter("username",username);
        params.addBodyParameter("passwrod",passwrod);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_LONG).show();
                Log.e("ok",result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(RegisterActivity.this,"该账号已注册",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }*/
}

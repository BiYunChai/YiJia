package com.yijia.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yijia.utils.HttpUrl;
import com.yijia.utils.ImgURL;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

import static com.mob.tools.utils.R.getStringRes;

public class RegisteActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String REGISTER = "register";
    private static final String LOGIN = "login";
    private EditText phone;
    private EditText cord;
    private EditText password;
    private TextView now;
    private Button getCord;
    private Button saveCord;
    private String iPhone;
    private String iCord;
    private int time = 60;
    private boolean flag = true;
    String APPKEY="138975429bd81";
    String APPSECRET="2591c2545fead72e26f8ea5471811029";

    //偏好设置相关
    SharedPreferences mSharedPreferences;
    SharedPreferences mSharedPreferenceslogin;
    SharedPreferences.Editor mEditor,mloginEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.register);
        initview();
        userRegister();

        SMSSDK.initSDK(this,APPKEY,APPSECRET,true);
        EventHandler eh=new EventHandler(){

            @Override
            public void afterEvent(int event, int result, Object data) {

                Message msg = new Message();
                msg.arg1 = event;
                msg.arg2 = result;
                msg.obj = data;
                handler.sendMessage(msg);
            }

        };
        SMSSDK.registerEventHandler(eh);
    }

    private void initview() {
        phone = (EditText) findViewById(R.id.phone);
        cord = (EditText) findViewById(R.id.cord);
        password= (EditText) findViewById(R.id.register_password);
        now = (TextView) findViewById(R.id.now);
        getCord = (Button) findViewById(R.id.getcord);
        saveCord = (Button) findViewById(R.id.savecord);
        getCord.setOnClickListener(this);
       saveCord.setOnClickListener(this);

        mSharedPreferences=getSharedPreferences(REGISTER,MODE_PRIVATE);
        mSharedPreferenceslogin=getSharedPreferences(LOGIN,MODE_PRIVATE);
        mEditor=mSharedPreferences.edit();
        mloginEditor=mSharedPreferenceslogin.edit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getcord:
                if(!TextUtils.isEmpty(phone.getText().toString().trim())){
                    if(phone.getText().toString().trim().length()==11){
                        iPhone = phone.getText().toString().trim();
                        SMSSDK.getVerificationCode("86",iPhone);
                        cord.requestFocus();
                        getCord.setVisibility(View.GONE);
                    }else{
                        Toast.makeText(RegisteActivity.this, "请输入完整电话号码", Toast.LENGTH_LONG).show();
                        phone.requestFocus();
                    }
                }else{
                    Toast.makeText(RegisteActivity.this, "请输入您的电话号码", Toast.LENGTH_LONG).show();
                    phone.requestFocus();
                }
                break;

            case R.id.savecord:
                if(!TextUtils.isEmpty(cord.getText().toString().trim())){
                    if(cord.getText().toString().trim().length()==4){
                        iCord = cord.getText().toString().trim();
                        SMSSDK.submitVerificationCode("86", iPhone, iCord);
                        flag = false;
                    }else{

                        Toast.makeText(RegisteActivity.this, "请输入完整验证码", Toast.LENGTH_LONG).show();
                        cord.requestFocus();
                    }
                }else{
                    Toast.makeText(RegisteActivity.this, "请输入验证码", Toast.LENGTH_LONG).show();
                    cord.requestFocus();
                }
                break;

            default:
                break;
        }
    }
    //验证码送成功后提示文字
    private void reminderText() {
        now.setVisibility(View.VISIBLE);
        handlerText.sendEmptyMessageDelayed(1, 1000);
    }

    Handler handlerText =new Handler(){
        public void handleMessage(Message msg) {
            if(msg.what==1){
                if(time>0){
                    now.setText("验证码已发送"+time+"秒");
                    time--;
                    handlerText.sendEmptyMessageDelayed(1, 1000);
                }else{
                    now.setText("提示信息");
                    time = 60;
                    now.setVisibility(View.GONE);
                    getCord.setVisibility(View.VISIBLE);
                }
            }else{
                cord.setText("");
                now.setText("提示信息");
                time = 60;
                now.setVisibility(View.GONE);
                getCord.setVisibility(View.VISIBLE);
            }
        };
    };
    Handler handler=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            int event = msg.arg1;
            int result = msg.arg2;
            Object data = msg.obj;
            Log.e("event", "event="+event);
            if (result == SMSSDK.RESULT_COMPLETE) {
                //短信注册成功后，返回MainActivity,然后提示新好友
                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {//提交验证码成功,验证通过
                    Toast.makeText(getApplicationContext(), "验证码校验及注册成功", Toast.LENGTH_SHORT).show();
                    handlerText.sendEmptyMessage(2);
                    Intent intent=new Intent(RegisteActivity.this,MainActivity.class);
                    startActivity(intent);

                } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){//服务器验证码发送成功
                    reminderText();
                    Toast.makeText(getApplicationContext(), "验证码已经发送", Toast.LENGTH_SHORT).show();
                }else if (event ==SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){//返回支持发送验证码的国家列表
                    Toast.makeText(getApplicationContext(), "获取国家列表成功", Toast.LENGTH_SHORT).show();
                }
            } else {
                if(flag){
                    getCord.setVisibility(View.VISIBLE);
                    Toast.makeText(RegisteActivity.this, "验证码获取失败，请重新获取", Toast.LENGTH_SHORT).show();
                    phone.requestFocus();
                }else{
                    ((Throwable) data).printStackTrace();
                    int resId = getStringRes(RegisteActivity.this, "smssdk_network_error");
                    Toast.makeText(RegisteActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                    cord.selectAll();
                    if (resId > 0) {
                        Toast.makeText(RegisteActivity.this, resId, Toast.LENGTH_SHORT).show();
                    }
                }

            }

        }

    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterAllEventHandler();
    }

    private void userRegister() {
        saveCord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username=phone.getText().toString();
                final String passwrod=password.getText().toString();
                //获取输入信息后输入框清空，并是光标停留在用户名处（用户名框获取焦点）
                phone.setText("");
                password.setText("");
                cord.setText("");
                phone.requestFocus();

                //访问网络
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
                            Toast.makeText(RegisteActivity.this,"该账号已注册",Toast.LENGTH_LONG).show();

                        }
                        else{

                            Intent intent=new Intent(RegisteActivity.this, MainActivity.class);
                            Toast.makeText(RegisteActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                            Log.e("ok",result);
                            //注册信息存入偏好设置
                            mEditor.putString("username",username);
                            mEditor.putString("password",passwrod);
                            mEditor.putString("nickname","佳宝宝");
                            mEditor.putString("phone",null);
                            mEditor.putString("sex",null);
                            mEditor.putString("email",null);
                            mEditor.putString("addgeneral",null);
                            mEditor.putString("adddetail",null);
                            mEditor.putBoolean("isregister",true);
                            mEditor.putString("userphoto", ImgURL.DefaultUserPhoto);

                            mEditor.commit();
                            //写入到登录信息
                            mloginEditor.putString("username",username);
                            mloginEditor.putString("password",passwrod);
                            mloginEditor.putString("nickname","佳宝宝");
                            mloginEditor.putString("userphoto", ImgURL.DefaultUserPhoto);
                            mloginEditor.putBoolean("islogin",true);
                            mEditor.putString("phone",null);
                            mEditor.putString("sex",null);
                            mEditor.putString("email",null);
                            mEditor.putString("addgeneral",null);
                            mEditor.putString("adddetail",null);

                            mloginEditor.commit();



                        }

                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("错误原因：", ex.getMessage() );
                        Toast.makeText(RegisteActivity.this,"无法访问网络，请稍后再试",Toast.LENGTH_LONG).show();



                    }

                    @Override
                    public void onCancelled(Callback.CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });


            }
        });
    }

}

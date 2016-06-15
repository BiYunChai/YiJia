package com.yijia.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yijia.utils.HttpUrl;
import com.yijia.utils.ImgURL;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;

public class LoginActivity extends AppCompatActivity {
    private static final String REGISTER = "register";
    private static final String LOGIN = "login";

    Button mRegisterButton;
    Button mforget_passwordButton;
    Button login_button;
    ImageView mImageView;
    String url;
    EditText usernameText;
    EditText passwordText;
    SharedPreferences mSharedPreferences;
    SharedPreferences mSharedPreferenceslogin;

    SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initViews();
        initListeners();
        initData();

    }



    private void initData() {
        url= ImgURL.DefaultUserPhoto;
        Glide.with(LoginActivity.this).load(url).into(mImageView);
    }

    private void initViews() {
        mImageView= (ImageView) findViewById(R.id.me_setting_userpic);
        mRegisterButton= (Button) findViewById(R.id.login_page_register);
        mforget_passwordButton= (Button) findViewById(R.id.forget_password);
        login_button= (Button) findViewById(R.id.login_button);

        usernameText= (EditText) findViewById(R.id.username_editText);
        passwordText= (EditText) findViewById(R.id.password_editText);

        mSharedPreferenceslogin=getSharedPreferences(LOGIN,MODE_PRIVATE);

        mEditor=mSharedPreferenceslogin.edit();
        boolean islogin=mSharedPreferenceslogin.getBoolean("islogin",true);


        if(islogin==false){
            mEditor.putBoolean("islogin",true);
            mEditor.commit();
        }



    }

    private void initListeners() {
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisteActivity.class);
                startActivity(intent);
            }
        });
        mforget_passwordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();
                //访问网络
                RequestParams params = new RequestParams(HttpUrl.USERLOGIN);
                params.addBodyParameter("username", username);
                params.addBodyParameter("password", password);
                Log.e("yun-----------", "访问网络");
                x.http().post(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<String>() {
                        }.getType();
                        String result2 = gson.fromJson(result, type);
                        if (result2.equals("登录成功")) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);

                        } else if (result2.equals("密码错误")) {
                            Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(LoginActivity.this, "用户不存在", Toast.LENGTH_LONG).show();
                        }

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
        });
    }

}

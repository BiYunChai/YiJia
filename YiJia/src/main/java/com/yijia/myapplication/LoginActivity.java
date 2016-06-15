package com.yijia.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yijia.utils.ImgURL;

public class LoginActivity extends AppCompatActivity {
    private static final String LOGIN="login";

    Button mRegisterButton;
    Button mforget_passwordButton;
    Button login_button;
    ImageView mImageView;
    String url;

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
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}

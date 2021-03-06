package com.yijia.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yijia.utils.HttpUrl;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;

public class ChangeNicknameActivity extends AppCompatActivity {
     EditText mEditText;
    Button mSavenicknameButton;
    private static final String REGISTER = "register";
    private static final String LOGIN = "login";
    SharedPreferences mSharedPreferences;
    SharedPreferences mSharedPreferenceslogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_nickname);
        initView();
        initoriginData();
        initListener();
    }

    private void initView() {
        mEditText= (EditText) findViewById(R.id.me_changenickname_edit);
        mSavenicknameButton= (Button) findViewById(R.id.savenickname);
        mSharedPreferences=getSharedPreferences(REGISTER,MODE_PRIVATE);
        mSharedPreferenceslogin=getSharedPreferences(LOGIN,MODE_PRIVATE);
    }

    private void initoriginData() {
        Intent intent=getIntent();
        String nickname=intent.getStringExtra("nickname");
        mEditText.setText(nickname);

    }
    private void initListener() {
        mSavenicknameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            String afterModifyNick=mEditText.getText().toString();
                if (afterModifyNick==null){
                    Toast.makeText(ChangeNicknameActivity.this, "昵称为空", Toast.LENGTH_SHORT).show();
                }

              /*  AlertDialog.Builder builder=new AlertDialog.Builder(ChangeNicknameActivity.this);
                builder.setMessage("修改昵称成功").create().show();*/
                RequestParams params=new RequestParams(HttpUrl.UPDATEUSERINFO);

                params.addBodyParameter("username","");
                params.addBodyParameter("nickname","");
                params.addBodyParameter("phone","");
                params.addBodyParameter("email","");
                params.addBodyParameter("sex","");
                params.addBodyParameter("heading","");
                params.addBodyParameter("adddetail","");
                x.http().post(params, new Callback.CommonCallback<String>() {

                    @Override
                    public void onSuccess(String result) {
                        Gson gson=new Gson();
                        Type type=new TypeToken<String>(){}.getType();
                        String result2=gson.fromJson(result,type);
                        if (result2.equals("修改用户数据成功")){
                            onBackPressed();
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

    public void back(View view) {
        finish();
    }
}

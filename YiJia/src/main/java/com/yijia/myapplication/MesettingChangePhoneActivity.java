package com.yijia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class MesettingChangePhoneActivity extends AppCompatActivity {
    EditText mEditText;
    Button msavephoneButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesetting_change_phone);

        initView();
        initoriginData();
        initListener();
    }


    private void initView() {
        mEditText= (EditText) findViewById(R.id.me_changephone_edit);
        msavephoneButton= (Button) findViewById(R.id.savephone);
    }

    private void initoriginData() {
        Intent intent=getIntent();
        String phone=intent.getStringExtra("phone");
        mEditText.setText(phone);
    }
    private void initListener() {
        msavephoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String afterModifyNick=mEditText.getText().toString();
                if (afterModifyNick==null){
                    Toast.makeText(MesettingChangePhoneActivity.this, "昵称为空", Toast.LENGTH_SHORT).show();
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

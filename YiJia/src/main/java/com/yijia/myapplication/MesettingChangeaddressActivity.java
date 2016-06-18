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

public class MesettingChangeaddressActivity extends AppCompatActivity {
    EditText mEditText;
    Button msaveaddressButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesetting_changeaddress);
        initView();
        initoriginData();
        initListener();
    }


    private void initoriginData() {
        Intent intent=getIntent();
        String address=intent.getStringExtra("adddetail");
        mEditText.setText(address);
    }

    private void initView() {
        mEditText= (EditText) findViewById(R.id.me_changeaddress_edit);
        msaveaddressButton= (Button) findViewById(R.id.saveemail);
    }

   private void initListener() {
        msaveaddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String afterModifyNick=mEditText.getText().toString();
                if (afterModifyNick==null){
                    Toast.makeText(MesettingChangeaddressActivity.this, "昵称为空", Toast.LENGTH_SHORT).show();
                }

              /*  AlertDialog.Builder builder=new AlertDialog.Builder(ChangeNicknameActivity.this);
                builder.setMessage("修改昵称成功").create().show();*/
                RequestParams params=new RequestParams(HttpUrl.UPDATEUSERINFO);

                params.addBodyParameter("username","默认");
                params.addBodyParameter("nickname","默认");
                params.addBodyParameter("phone","默认");
                params.addBodyParameter("email","默认");
                params.addBodyParameter("sex","默认");
                params.addBodyParameter("heading","默认");
                params.addBodyParameter("adddetail","默认");
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

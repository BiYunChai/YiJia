package com.yijia.myapplication;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yijia.utils.HttpUrl;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;


public class DesignApplyActivity extends AppCompatActivity {
    private static final String REGISTER = "register";
    private static final String LOGIN = "login";
    ImageView mBackImg;
    EditText applynameEditText;
    EditText applytelEditText;
    Spinner areaSpinner;
    EditText detailaddresss;
    Button applybutton;
    ArrayAdapter<String> areaAdapter;
    SharedPreferences mSharedPreferences;
    SharedPreferences mSharedPreferenceslogin;
    String  spinnerStr="";
    String name="";
    String tel="";
    String datailaddress="";
    private String[] area={"金阊区","沧浪区","吴中区","平江区","工业园区","相城区","虎丘区","高新区"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_apply);
        initview();
        initAdapter();

        initspinnerListener();
        apply();
    }

    private void initAdapter() {
        areaAdapter=new ArrayAdapter<String>(DesignApplyActivity.this,android.R.layout.simple_list_item_1,area);
        areaSpinner.setAdapter(areaAdapter);
        areaSpinner.setSelection(0,true);
    }


    private void initData() {
        spinnerStr= (String) areaSpinner.getSelectedItem();
        name=applynameEditText.getText().toString();
        tel=applytelEditText.getText().toString();
        datailaddress=detailaddresss.getText().toString();

    }

    private void apply() {
        Log.e("yun-----------","apply");
        applybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
                applyData(spinnerStr);


            }
        });

    }


    private void initview() {
        mBackImg= (ImageView) findViewById(R.id.back);
        applybutton= (Button) findViewById(R.id.applydesignbutton);
        applynameEditText= (EditText) findViewById(R.id.appilname);
        applytelEditText= (EditText) findViewById(R.id.applytel);
        areaSpinner= (Spinner) findViewById(R.id.areaaddress);
        detailaddresss= (EditText) findViewById(R.id.addressdetail);
        mSharedPreferences=getSharedPreferences(REGISTER,MODE_PRIVATE);
        mSharedPreferenceslogin=getSharedPreferences(LOGIN,MODE_PRIVATE);



    }
    private void applyData(String areaaddress) {
        Log.e("yun--name","开始调用applyData");
        Log.e("yun--name",name);
        Log.e("yun--name",tel);
        Log.e("yun--name",spinnerStr);
        Log.e("yun--name",datailaddress);


        boolean isregister=mSharedPreferences.getBoolean("isregister",false);

        boolean islogin=mSharedPreferenceslogin.getBoolean("islogin",false);
        if(isregister){
            if(islogin){
                String username=mSharedPreferenceslogin.getString("username","12345678901");
                Log.e("yun--name","-------------------------");
                Log.e("yun--name",username);
                Log.e("yun--name",name);

                Log.e("yun--name",tel);
                Log.e("yun--name",spinnerStr);
                Log.e("yun--name",datailaddress);
                //访问网络
                RequestParams params=new RequestParams(HttpUrl.APPLYDESIGN);
                params.addBodyParameter("username",username);
                params.addBodyParameter("name",name);
                params.addBodyParameter("tel",tel);
                params.addBodyParameter("areaaddress",spinnerStr);
                params.addBodyParameter("detailaddress",datailaddress);



                Log.e("yun-----------","访问网络");
                x.http().post(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson=new Gson();
                        Type type=new TypeToken<String>(){}.getType();
                        String result2=gson.fromJson(result,type);
                        if(result2.equals("ok")){
                            Toast.makeText(DesignApplyActivity.this,"申请成功，客服将于24小时内联系您！",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(DesignApplyActivity.this,MyBuildActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(DesignApplyActivity.this,"申请失败，请查看您的信息是否正确",Toast.LENGTH_LONG).show();

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
            else{
                Toast.makeText(DesignApplyActivity.this,"还没有登录呦，快去登录吧",Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(DesignApplyActivity.this,"还没有注册呦，快去注册吧",Toast.LENGTH_LONG).show();
        }

    }

    private void initspinnerListener() {
        Log.e("yun-----------","开始调用initspinnerListener");

        areaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String areaaddress;
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                areaaddress=area[position];
                //applyData(areaaddress);
                Log.e("yun-----------","initspinnerListener");
                spinnerStr=areaaddress;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }



    public void backhome(View view) {

        finish();
    }
}

package com.yijia.fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yijia.myapplication.LoginActivity;
import com.yijia.myapplication.MyBuildActivity;
import com.yijia.myapplication.MyPostActivity;
import com.yijia.myapplication.MyCollActivity;
import com.yijia.myapplication.R;
import com.yijia.myapplication.SettingActivity;
import com.yijia.utils.ImgURL;

/**
 * Created by Administrator on 2016/5/13.
 */
public class MeFragment extends Fragment {
    private static final String LOGIN = "login";
    LinearLayout gongdi,tiezi,store,setting;
    ImageView backgroud;
    Button mButton;
    View view;
    ImageView mImageView;
    TextView mTextView;
    TextView mWelcomeText;
    Button mLOginandRegisterButton;
    SharedPreferences mSharedPreferences;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.me, null);
        initViews();
        Glide.with(getContext())
                .load(ImgURL.BACKGROUD)
                .into(backgroud);
        setUserInfo();

        gongdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MyBuildActivity.class);
                startActivity(intent);
            }
        });


        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), SettingActivity.class);
                startActivity(intent);
            }
        });


        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MyCollActivity.class);
                startActivity(intent);
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                Intent intent=new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                }
        });

       tiezi.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               Intent intent=new Intent(getContext(),MyPostActivity.class);
               startActivity(intent);
           }
       });
        return view;
    }



    private void initViews() {

        mImageView= (ImageView) view.findViewById(R.id.me_userdefaultphoto);
        mTextView= (TextView)view.findViewById(R.id.me_userdefaultname);
        mWelcomeText= (TextView)view.findViewById(R.id.welcometext);
        mLOginandRegisterButton= (Button) view.findViewById(R.id.LoginAndRegister);


        gongdi= (LinearLayout) view.findViewById(R.id.building);
        tiezi= (LinearLayout) view.findViewById(R.id.post);
        store= (LinearLayout) view.findViewById(R.id.store);
        setting= (LinearLayout) view.findViewById(R.id.setting);
        mButton= (Button) view.findViewById(R.id.LoginAndRegister);
        backgroud= (ImageView) view.findViewById(R.id.backgroud);

        mSharedPreferences=getContext().getSharedPreferences(LOGIN,0);

    }
    private void setUserInfo() {
       boolean islogin= mSharedPreferences.getBoolean("islogin",false);
        String userphoto=mSharedPreferences.getString("userphoto", ImgURL.UserPhoto);
        String username=mSharedPreferences.getString("username","用户名");
        //判断是否登录
        if(islogin){
            mImageView.setVisibility(View.VISIBLE);
            Glide.with(getContext())
                    .load(userphoto)
                    .into(mImageView);
            mTextView.setVisibility(View.VISIBLE);
            mTextView.setText(username);
            mWelcomeText.setVisibility(View.GONE);
            mLOginandRegisterButton.setVisibility(View.GONE);
            Log.e("yun","设置默认头像成功");

        }else{
            mImageView.setVisibility(View.GONE);
            mTextView.setVisibility(View.GONE);
            mWelcomeText.setVisibility(View.VISIBLE);
            mLOginandRegisterButton.setVisibility(View.VISIBLE);
            Log.e("yun","恢复未登录状态");
        }
    }

}

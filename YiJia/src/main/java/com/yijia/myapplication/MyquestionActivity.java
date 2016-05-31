package com.yijia.myapplication;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.yijia.adapter.MyQuestionAdapter;
import com.yijia.fragment.MyRaiseQuesFragment;
import com.yijia.fragment.MyReplyQuesFragment;
import java.util.ArrayList;
import java.util.List;

public class MyquestionActivity extends AppCompatActivity {
    RadioGroup mRadioGroupques;
    List<Fragment> mFragmentList;
    MyRaiseQuesFragment mRaiseQuesFragment;
    MyReplyQuesFragment mReplyQuesFragment;
    FragmentManager mFragmentManager;
    ViewPager mViewPagerques;
    MyQuestionAdapter mQuestionAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myquestion);
        initViews();
        initData();
        initListener();
    }

    private void initViews() {
        mViewPagerques= (ViewPager) findViewById(R.id.viewpagerques);
        mRadioGroupques= (RadioGroup) findViewById(R.id.raiseandrelyquestion);
    }

    private void initData() {
        mFragmentList=new ArrayList<>();
        mRaiseQuesFragment=new MyRaiseQuesFragment();
        mReplyQuesFragment=new MyReplyQuesFragment();
        mFragmentList.add(mRaiseQuesFragment);
        mFragmentList.add(mReplyQuesFragment);
       mFragmentManager=getSupportFragmentManager();
        mQuestionAdapter=new MyQuestionAdapter(mFragmentManager,mFragmentList);
        mViewPagerques.setAdapter(mQuestionAdapter);
    }

    private void initListener() {
        mRadioGroupques.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetViewPager2(checkedId);
            }
        });
        mViewPagerques.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
              //根据当前位置默认默认选中单选按钮
                resetRadioButton2(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    private void resetViewPager2(int checkedId) {

        switch (checkedId){
            case R.id.myRaise:
                mViewPagerques.setCurrentItem(0);
                break;
            case R.id.myReply:
                mViewPagerques.setCurrentItem(1);
                break;
        }
    }
    private void resetRadioButton2(int position) {

        RadioButton radioButton= (RadioButton) mRadioGroupques.getChildAt(position);
        radioButton.setChecked(true);

    }

}

package com.yijia.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.yijia.adapter.KnowledgeAdapter;
import com.yijia.bean.Knowledge;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity {
    ImageView mBackImg;
    ListView mListView;
    KnowledgeAdapter mKnowledgeAdapter;
    List<Knowledge> mlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.knowledge);
        initview();
        initData();
    }



    private void initview() {
        mBackImg= (ImageView) findViewById(R.id.back);
        mListView= (ListView) findViewById(R.id.knowlistview);

    }
    private void initData() {
        mlist=new ArrayList<>();
        Knowledge k1=new Knowledge("青花饰品 家居软装中一只会说话的精灵","青花饰品是当前流行的时尚元素，在国际时尚界，青花饰品一直都是高贵与品位的象征，像一些小挂件、杯具、花瓶等，在我们的家居装饰中也可以作为很好的软装饰品。它并不奢华，但从里而外透露着一种气度，美丽自认而然就显示出来。","2016-05-05");
        Knowledge k2=new Knowledge("青花饰品 家居软装中一只会说话的精灵","青花饰品是当前流行的时尚元素，在国际时尚界，青花饰品一直都是高贵与品位的象征，像一些小挂件、杯具、花瓶等，在我们的家居装饰中也可以作为很好的软装饰品。它并不奢华，但从里而外透露着一种气度，美丽自认而然就显示出来。","2016-05-05");
        Knowledge k3=new Knowledge("青花饰品 家居软装中一只会说话的精灵","青花饰品是当前流行的时尚元素，在国际时尚界，青花饰品一直都是高贵与品位的象征，像一些小挂件、杯具、花瓶等，在我们的家居装饰中也可以作为很好的软装饰品。它并不奢华，但从里而外透露着一种气度，美丽自认而然就显示出来。","2016-05-05");
        Knowledge k4=new Knowledge("青花饰品 家居软装中一只会说话的精灵","青花饰品是当前流行的时尚元素，在国际时尚界，青花饰品一直都是高贵与品位的象征，像一些小挂件、杯具、花瓶等，在我们的家居装饰中也可以作为很好的软装饰品。它并不奢华，但从里而外透露着一种气度，美丽自认而然就显示出来。","2016-05-05");
        Knowledge k5=new Knowledge("青花饰品 家居软装中一只会说话的精灵","青花饰品是当前流行的时尚元素，在国际时尚界，青花饰品一直都是高贵与品位的象征，像一些小挂件、杯具、花瓶等，在我们的家居装饰中也可以作为很好的软装饰品。它并不奢华，但从里而外透露着一种气度，美丽自认而然就显示出来。","2016-05-05");
        Knowledge k6=new Knowledge("青花饰品 家居软装中一只会说话的精灵","青花饰品是当前流行的时尚元素，在国际时尚界，青花饰品一直都是高贵与品位的象征，像一些小挂件、杯具、花瓶等，在我们的家居装饰中也可以作为很好的软装饰品。它并不奢华，但从里而外透露着一种气度，美丽自认而然就显示出来。","2016-05-05");
        Knowledge k7=new Knowledge("青花饰品 家居软装中一只会说话的精灵","青花饰品是当前流行的时尚元素，在国际时尚界，青花饰品一直都是高贵与品位的象征，像一些小挂件、杯具、花瓶等，在我们的家居装饰中也可以作为很好的软装饰品。它并不奢华，但从里而外透露着一种气度，美丽自认而然就显示出来。","2016-05-05");
        Knowledge k8=new Knowledge("青花饰品 家居软装中一只会说话的精灵","青花饰品是当前流行的时尚元素，在国际时尚界，青花饰品一直都是高贵与品位的象征，像一些小挂件、杯具、花瓶等，在我们的家居装饰中也可以作为很好的软装饰品。它并不奢华，但从里而外透露着一种气度，美丽自认而然就显示出来。","2016-05-05");
        Knowledge k9=new Knowledge("青花饰品 家居软装中一只会说话的精灵","青花饰品是当前流行的时尚元素，在国际时尚界，青花饰品一直都是高贵与品位的象征，像一些小挂件、杯具、花瓶等，在我们的家居装饰中也可以作为很好的软装饰品。它并不奢华，但从里而外透露着一种气度，美丽自认而然就显示出来。","2016-05-05");
        Knowledge k10=new Knowledge("青花饰品 家居软装中一只会说话的精灵","青花饰品是当前流行的时尚元素，在国际时尚界，青花饰品一直都是高贵与品位的象征，像一些小挂件、杯具、花瓶等，在我们的家居装饰中也可以作为很好的软装饰品。它并不奢华，但从里而外透露着一种气度，美丽自认而然就显示出来。","2016-05-05");
        Knowledge k11=new Knowledge("青花饰品 家居软装中一只会说话的精灵","青花饰品是当前流行的时尚元素，在国际时尚界，青花饰品一直都是高贵与品位的象征，像一些小挂件、杯具、花瓶等，在我们的家居装饰中也可以作为很好的软装饰品。它并不奢华，但从里而外透露着一种气度，美丽自认而然就显示出来。","2016-05-05");
        Knowledge k12=new Knowledge("青花饰品 家居软装中一只会说话的精灵","青花饰品是当前流行的时尚元素，在国际时尚界，青花饰品一直都是高贵与品位的象征，像一些小挂件、杯具、花瓶等，在我们的家居装饰中也可以作为很好的软装饰品。它并不奢华，但从里而外透露着一种气度，美丽自认而然就显示出来。","2016-05-05");


        mlist.add(k1);
        mlist.add(k2);
        mlist.add(k3);
        mlist.add(k4);
        mlist.add(k5);
        mlist.add(k6);
        mlist.add(k7);
        mlist.add(k8);
        mlist.add(k9);
        mlist.add(k10);
        mlist.add(k11);

        mlist.add(k12);



        mKnowledgeAdapter=new KnowledgeAdapter(BookActivity.this,mlist);
        mListView.setAdapter(mKnowledgeAdapter);


    }

    public void backhome(View view) {
        /*Intent intent=new Intent(DesignApplyActivity.this, HomeFragment.class);
        startActivity(intent);*/
        finish();
    }
}

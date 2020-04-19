package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import android.graphics.Color;
        import android.net.Uri;
        import android.os.Bundle;

        import androidx.appcompat.app.AppCompatDialogFragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import com.google.android.gms.appindexing.Action;
        import com.google.android.gms.appindexing.AppIndex;
        import com.google.android.gms.common.api.GoogleApiClient;

        import java.util.AbstractList;
        import java.util.ArrayList;
        import java.util.List;

public class PagerActivity extends BaseActivity {
    ViewPager pager;
    private List<MyFragment> list;
    private String data[] = {"第一页", "第二页", "第三页"};
    private LinearLayout layout;
    private TextView textView[];
    private ViewPager view_pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        //初始化Fragment数组
        pager = (ViewPager) this.findViewById(R.id.pager);
        list = new ArrayList<MyFragment>();
        list.add(new MyFragment());
        list.add(new MyFragment());
        list.add(new MyFragment());
        MyAdapter adapter=new MyAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(adapter);




        LinearLayout layout = (LinearLayout) this.findViewById(R.id.layout);
        //获取LinearLayout容器
        final int num = layout.getChildCount();
        //获取容器的子控件个数
        textView = new TextView[num];
        //实例化标题数组
        for (int i = 0; i < num; i++) {
            textView[i] = (TextView) layout.getChildAt(i);
            textView[i].setText(data[i]);
            textView[i].setTag(i);//设置标识
            textView[i].setBackgroundColor(Color.GRAY);

            textView[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int item = (Integer) view.getTag();
                    pager.setCurrentItem(item);
                    for (int i1 = 0; i1 < num; i1++) {
                        textView[i1].setBackgroundColor(Color.GRAY);
                    }
                    textView[item].setBackgroundColor(Color.YELLOW);
                }
            });
            textView[i].setEnabled(true);
        }
        textView[0].setBackgroundColor(Color.YELLOW);


        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override

            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class MyAdapter extends FragmentPagerAdapter
    {
        private List<MyFragment> fragments;
        private FragmentManager fm;

        public MyAdapter(FragmentManager fm, List<MyFragment> fragmentList) {
            super(fm);
            this.fragments=fragmentList;
            this.fm=fm;
        }
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }
        @Override
        public int getCount() {
            return fragments.size();
        }
    }
    public void select() {
    }
}
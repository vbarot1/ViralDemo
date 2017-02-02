package com.example.dinesh.viraldemo;

//import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dinesh.viraldemo.Fragment.ContentFragment;
import com.example.dinesh.viraldemo.Fragment.HistoryFragment;
import com.example.dinesh.viraldemo.Fragment.Login;
import com.example.dinesh.viraldemo.adapter.ViewPagerAdapter;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();

    //fragmentList.add(new)
    //private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        init();
    }

    private void init() {
        viewPager = (ViewPager)findViewById(R.id.view_pager);


        fragmentList.add(new ContentFragment());
        fragmentList.add(new HistoryFragment());
        fragmentList.add(new Login());

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);
//                tabLayout = (TabLayout)findViewById(R.id.tab_layout);
//       tabLayout.setupWithViewPager(viewPager);


    }
}

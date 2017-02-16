package com.example.dinesh.viraldemo;

//import android.support.design.widget.TabLayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.dinesh.viraldemo.Fragment.ContentFragment;
import com.example.dinesh.viraldemo.Fragment.HistoryFragment;
import com.example.dinesh.viraldemo.Fragment.Login;
import com.example.dinesh.viraldemo.adapter.ViewPagerAdapter;
import com.example.dinesh.viraldemo.bean.Book;
import com.example.dinesh.viraldemo.util.UtilLog;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    private TabLayout tabLayout;
    //private ListView listView;
    /*private ArrayList<String> listResult;
    private android.view.View ViewHeader;*/

    //fragmentList.add(new)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // listResult = new ArrayList<String>();
        setContentView(R.layout.activity_view_pager);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String message = intent.getStringExtra("key");
        int number = bundle.getInt("Integer", 0);
        int fakeNumber = bundle.getInt("fake", 0);
        Book book = (Book) bundle.getSerializable("book");

        UtilLog.logD("ViewPagerActivity" ," value is" + message);
        UtilLog.logD("ViewPagerActivity", "number is" + number);
        UtilLog.logD("ViewPagerActivity", "fake number is" + String.valueOf(fakeNumber));
        UtilLog.logD("ViewPagerActivity", "book author is: " + book.getAuthor());
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void init() {
        viewPager = (ViewPager)findViewById(R.id.view_pager);

        fragmentList.add(new ContentFragment());
        fragmentList.add(new HistoryFragment());
        fragmentList.add(new Login());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
//        getLayoutInflater().inflate(R.layout.list_view_header, null);

  //      ListViewAdapter listViewAdapter = new ListViewAdapter(this, listResult);
        //listView.addHeaderView(ViewHeader);




//how to do uTilLog and Base Activity and breakpoint
        //how to do application



        viewPager.setAdapter(viewPagerAdapter);
          tabLayout = (TabLayout)findViewById(R.id.tab_layout);
       tabLayout.setupWithViewPager(viewPager);


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("message", "ViewPager");
        setResult(RESULT_OK,intent);
        super.onBackPressed();
    }
}

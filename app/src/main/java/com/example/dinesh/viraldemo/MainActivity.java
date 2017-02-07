package com.example.dinesh.viraldemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.dinesh.viraldemo.util.UtilLog;

public class MainActivity extends BaseActivity {

    private ImageButton bt1;
    private ImageButton bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
    }

    private void initialView() {

        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt3 = (ImageButton) findViewById(R.id.bt3);

    }



    private void initialListener()  {
//bt1.setOnClickListener(new View.OnClickListener() {
        //@Override
        //public void onClick (View v) {

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Toast.makeText(view.getContext(), "Button2 was clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(view.getContext(),ViewPagerActivity.class);
                startActivity(intent);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toActivity(ListViewActivity.class);
/*
                Intent intent = new Intent(view.getContext(), ListViewActivity.class);
                startActivity(intent);
*/
            }
        });
    }

    public void onClick(View view) {
        //Toast.makeText(this,"listView was clicked at position: ",Toast.LENGTH_LONG).show();
        toastLong("Button2 was clicked");
        //key = your class name
        UtilLog.logD("testD", "Toast");
        //Log.e("testE", "Toast");
        //Log.i("testI", "Toast");
        //Log.v("testI", "Toast");
        //Log.w("testI", "Toast");

    }


}

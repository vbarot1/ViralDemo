package com.example.dinesh.viraldemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.dinesh.viraldemo.bean.Book;
import com.example.dinesh.viraldemo.util.UtilLog;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private ImageButton bt1;
    private ImageButton bt3;

    @OnClick(R.id.bt2)
    public void button2Click() {
        Intent intent = new Intent(this, DialogActivity.class);
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        toastShort("onStart");
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
                intent.putExtra("key", "value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer", 12345);
                Book book = new Book();
                book.setName("Android");
                book.setAuthor("Viral");
                bundle.putSerializable("book", book);
                intent.putExtras(bundle);
                startActivityForResult(intent,1); //can pass infomration through intent

            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ListViewActivity.class);
                startActivityForResult(intent, 3);
/*
                Intent intent = new Intent(view.getContext(), ListViewActivity.class);
                startActivity(intent);
*/
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                String message = data.getStringExtra("message");
                toastShort(message);
                break;
            case 2:
                toastShort("Dialog");
                break;
            case 3:
                toastShort("Custom");
                break;
            default:
        }
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

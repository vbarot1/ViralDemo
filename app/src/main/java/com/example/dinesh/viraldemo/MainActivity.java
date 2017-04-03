package com.example.dinesh.viraldemo;


        import butterknife.OnClick;
        import android.animation.ObjectAnimator;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.GestureDetector;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.FrameLayout;
        import android.widget.ImageButton;
        import android.widget.LinearLayout;
        import android.widget.Toast;
        import com.example.dinesh.viraldemo.bean.Book;
        import com.example.dinesh.viraldemo.util.UtilLog;
        import butterknife.BindView;
        import butterknife.ButterKnife;
        import butterknife.OnClick;

public class MainActivity extends BaseActivity implements View.OnTouchListener{
    private ImageButton bt1;
    private ImageButton bt3;
    private ImageButton bt4;
    private GestureDetector mGestureDetector;
    int INCR = 0;

    @BindView(R.id.frameLayout)
    FrameLayout frameLayout;

    @BindView(R.id.DemoActs)
    LinearLayout linearLayout;

    @OnClick (R.id.custom_bt)
    public void toCustomDialog() {

        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, CustomDialog.class);
       /* intent.putExtra("Message","Double");
        intent.putExtras(bundle);*/
        startActivityForResult(intent, 2);

    }

    @OnClick(R.id.bt2)
    public void button2Click(){
        Intent intent = new Intent(this, DialogActivity.class);
        startActivityForResult(intent, 2);
//toActivity(DialogActivity.class);
    }

    @OnClick(R.id.main_timer_bt)
    public void buttonTimerClick(){
        Intent intent = new Intent(this, TimerActivity.class);
        startActivity(intent);
//toActivity(DialogActivity.class);
    }

    @OnClick(R.id.main_animation_bt)
    public void buttonAnimationClick(){
        Intent intent = new Intent(this, AnimationActivity.class);
        startActivity(intent);
//toActivity(DialogActivity.class);
    }

    @OnClick(R.id.viewPager_Act1)
    public void viewPagerActivity(){
        Intent intent = new Intent(this,ViewPagerActivity.class);
        intent.putExtra("key","value");
        Bundle bundle = new Bundle();
        bundle.putInt("Integer", 12345);
        Book book = new Book();
        book.setName("Android");
        book.setAuthor("ViralB");
        bundle.putSerializable("book", book);
        intent.putExtras(bundle);
        startActivityForResult(intent, 1);
    }

    @OnClick(R.id.dialog_Act2)
    public void dialogActivity(){
        toActivity(DialogActivity.class);
    }

    @OnClick(R.id.listView_Act3)
    public void listViewActivity(){
        toActivity(ListViewActivity.class);
    }

    @OnClick(R.id.animation_Act4)
    public void animationActivity(){
        toActivity(AnimationActivity.class);
    }

    @OnClick(R.id.animator_Act5)
    public void animatorActivity(){
        toActivity(AnimatorActivity.class);
    }

    @OnClick(R.id.timer_Act6)
    public void timerActivity(){
        toActivity(TimerActivity.class);
    }

    @OnClick(R.id.ABT)
    public void aActivity(){
        toActivity(ActivityA.class);
    }

    @OnClick(R.id.BBT)
    public void bActivity(){
        toActivity(ActivityB.class);
    }

    @OnClick(R.id.CBT)
    public void cActivity(){
        toActivity(ActivityC.class);
    }
    @OnClick(R.id.DBT)
    public void dActivity(){
        toActivity(ActivityD.class);
    }


    @OnClick(R.id.bt_hw4)
    public void move(){
        if(INCR==0){
            ObjectAnimator animator = ObjectAnimator.ofFloat(linearLayout, "translationX", 0, 950, 950,950,950); //translationY
            animator.setDuration(1000);
            animator.start();
            INCR ++;
        }
        else{
            ObjectAnimator animator = ObjectAnimator.ofFloat(linearLayout, "translationX", 950, 0, 0,0,0); //translationY
            animator.setDuration(1000);
            animator.start();
            INCR = 0;
        }
    }

    @OnClick(R.id.animator_bt)
    public void buttonAnimatorClick(){
        Intent intent = new Intent(this, AnimatorActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
        ButterKnife.bind(this);
        mGestureDetector=new GestureDetector(this,new SimpleGestureListener());
        frameLayout.setOnTouchListener(this);
    }

    private void initialView(){
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt3 = (ImageButton) findViewById(R.id.bt3);
        bt4 = (ImageButton) findViewById(R.id.bt4);

    }
    private void initialListener(){
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Button1 was clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(),ViewPagerActivity.class);
                intent.putExtra("key","value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer", 12345);
                Book book = new Book();
                book.setName("BOOKNAME");
                book.setAuthor("ViralB");
                bundle.putSerializable("book", book);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),ListViewActivity.class);
                startActivityForResult(intent, 3);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),ActivityA.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                String message = data.getStringExtra("message");
                toastShort(message);
                break;
            case 2:
                toastShort("Dialog");
                break;
            case 3:
                toastShort("ListView");
                break;
            default:
        }
    }


    public void onClick(View v){
        toastLong("Button2 was clicked");
        UtilLog.logD("testD","Toast");
    }

    @Override
    protected void onStart() {
        toastShort("onStart");
        super.onStart();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }


    private class SimpleGestureListener extends GestureDetector.SimpleOnGestureListener{
        public boolean onDown(MotionEvent e){
            UtilLog.logD("MyGesture","onDown");
            return true;
        }
        public void onShowPress(MotionEvent e){
            UtilLog.logD("MyGesture","onShowPress");
        }
        public void onLongPress(MotionEvent e){
            UtilLog.logD("MyGesture","onLongPress");
        }
        public boolean onSingleTapUp(MotionEvent e){
            UtilLog.logD("MyGesture","onSingleTapUp");
            return true;
        }
        public boolean onSingleTapConfirmed(MotionEvent e)
        {
            UtilLog.logD("MyGesture","onSingleTapConfirmed");
            if(INCR == 1){
                ObjectAnimator animator = ObjectAnimator.ofFloat(linearLayout, "translationX", 950, 0, 0,0,0); //translationY
                animator.setDuration(1000);
                animator.start();
                INCR = 0;
            }
            return true;
        }
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,float distanceY){
            UtilLog.logD("MyGesture","onScroll:"+(e2.getX()-e1.getX())+" "+distanceX);
            return true;
        }
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){

            if(INCR == 0){
                ObjectAnimator animator = ObjectAnimator.ofFloat(linearLayout, "translationX", 0, 950, 950,950,950); //translationY
                animator.setDuration(1000);
                animator.start();

                INCR ++;
            }
            else{
                ObjectAnimator animator = ObjectAnimator.ofFloat(linearLayout, "translationX", 950, 0, 0,0,0); //translationY
                animator.setDuration(1000);
                animator.start();
                INCR = 0;
            }
            return true;
        }
        public boolean onDoubleTap(MotionEvent e){
            return true;
        }
        public boolean onDoubleTapEvent(MotionEvent e){
            return true;
        }

    }
}

package com.example.rochesterdemo2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;


import com.example.rochesterdemo2.dialog.CustomDialog;
import com.example.rochesterdemo2.util.UtilLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements View.OnTouchListener{

    private ImageButton bt1;
    private ImageButton bt2;
    private ImageButton bt3;
    private ImageButton b4x;
    private GestureDetector mGestureDetector;

    @BindView(R.id.main_fl) FrameLayout fl;

    private CustomDialog.ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener {
        void onClickListener();
    }

    int choice = 0;
    @OnClick(R.id.quiz4)
    public void toQuiz4() {
        final String[] items = {"Dialog View", "List View"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Quiz 4");
        builder.setSingleChoiceItems(items, choice, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choice = which;
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (choice == 0) {
                    button2Click();
                } else if (choice == 1) {
                    button3Click();
                } else {
                    dialog.dismiss();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toActivity(ViewPagerActivity.class);
            }
        });
        builder.show();
    }

    @OnClick(R.id.main_timer_bt)
    public void toTimer() { toActivity(TimerActivity.class); }

    @OnClick(R.id.main_anim_bt)
    public void toAnimation() {
        toActivity(AnimationActivity.class);
    }

    @OnClick(R.id.main_anim_bt)
    public void toAnimator() {
        toActivity(AnimatorActivity.class);
    }

    @OnClick(R.id.bt2)
    public void button2Click(){
        toActivity(DialogActivity.class);
    }

    @OnClick(R.id.bt3)
    public void button3Click() { toActivity((ListViewActivity.class));}

    @OnClick(R.id.b4x)
    public void button4Click() {
        Intent intent = new Intent(this, ActivityA.class);
        startActivityForResult(intent, 4);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
        ButterKnife.bind(this);
        mGestureDetector = new GestureDetector(this, new simpleGestureListener());
        fl.setOnTouchListener(this);
    }

    private void initialView() {
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt2 = (ImageButton) findViewById(R.id.bt2);
        bt3 = (ImageButton) findViewById(R.id.bt3);
    }

    private void initialListener() {
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Button1 Was Clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(),ViewPagerActivity.class);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //toActivity(ListViewActivity.class);
//                Intent intent = new Intent(v.getContext(),ListViewActivity.class);
//                startActivity(intent);
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
            case 4:
                toastShort("LaunchExample");
                break;
            default:
        }
    }

    public void onClick(View v) {
        // Toast.makeText(this, "Button2 was clicked", Toast.LENGTH_LONG).show();
        toastLong("Button2 was clicked");
        UtilLog.logD("testD", "Toast");
        // Log.d("testD", "Toast");
        // Log.e("testE", "Toast");
        // Log.i("testI", "Toast");
        // Log.v("testE", "Toast");
        // Log.w("testI", "Toast");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent e) {
            //UtilLog.logD("MyGesture", "onDown");
            toastShort("onDown");
            return true;
        }

        public void onShowPress(MotionEvent e) {
            //UtilLog.logD("MyGesture", "onShowPress");
            toastShort("onShowPress");
        }

        public void onLongPress(MotionEvent e) {
            UtilLog.logD("MyGesture", "onLongPress");
            toastShort("onLongPress");

        }

        public boolean onSingleTapUp(MotionEvent e) {
            //UtilLog.logD("MyGesture", "onSingleTapUp");
            //toastShort("onSingleTapUp");
            return false;
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            UtilLog.logD("MyGesture", "onScroll:" + (e2.getY() - e1.getY()) + "  " + distanceX);
            toastShort("onScroll");
            return true;
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            //toastShort("onFling");
            return true;
        }

        public boolean onDoubleTap(MotionEvent e) {
            //toastShort("onDoubleTap");
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent e) {
            //toastShort("onDoubleTapEvent");
            return true;
        }
    }
}

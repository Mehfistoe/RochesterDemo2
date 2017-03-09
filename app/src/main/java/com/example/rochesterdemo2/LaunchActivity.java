package com.example.rochesterdemo2;

import android.os.Bundle;
import android.widget.ImageButton;

import butterknife.OnClick;

public class LaunchActivity extends BaseActivity {

    private ImageButton bt1;
    private ImageButton bt3;
    private ImageButton b5x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        // ButterKnife.bind(this);
    }

    @OnClick(R.id.b1x)
    public void button1xClick() {
        //Intent intent = new Intent(this, DialogActivity.class);
        //startActivityForResult(intent, 2);
    }

    @OnClick(R.id.b2x)
    public void button2xClick() {
        //Intent intent = new Intent(this, LaunchActivity.class);
        //startActivityForResult(intent, 4);
    }

    @OnClick(R.id.b3x)
    public void button3xClick() {
        //Intent intent = new Intent(this, DialogActivity.class);
        //startActivityForResult(intent, 2);
    }

    @OnClick(R.id.b4x)
    public void button4xClick() {
        //Intent intent = new Intent(this, LaunchActivity.class);
        //startActivityForResult(intent, 4);
    }

}

package com.example.lenovo.zidingyiviewtuozhuai;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by KING on 2017/8/10 22:03
 * 邮箱:992767879@qq.com
 */

public class MyView extends ImageView {

    private float x,y,rawX,rawY;
    private int a;
    private int b;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                     x = getX();
                     y = getY();
                     rawX = event.getRawX();
                     rawY = event.getRawY();
                    a= (int) ((rawY-y)-getTop());
                    b=(int)((rawX-x)-getLeft());
                    break;
                case MotionEvent.ACTION_MOVE:
                    int left = (int) ((rawX - x)-b);
                    int top = (int) ((rawY - y)-a);
                    int i = left + getWidth();
                    int i1 = top + getHeight();
                    setFrame(left,top,i,i1);
                    rawX = event.getRawX();
                    rawY = event.getRawY();
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
        return true;
    }
}

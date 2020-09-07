package com.uni.weimar.misproject;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyRecyclerView extends androidx.recyclerview.widget.RecyclerView {
    public MyRecyclerView(@NonNull Context context) {
        super(context);
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
//    public MyRecyclerView(@NonNull Context context) {
//        super(context);
//    }
    final ScaleGestureDetector mScaleDetector = new ScaleGestureDetector(this.getContext(), new ScaleGestureDetector.OnScaleGestureListener() {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            Log.d("Scaling", "onScale: "+scaleFactor);
            if (scaleFactor > 1) {
//                    scaleText.setText("Zooming Out");
//                    line.setVisibility(View.VISIBLE);
            } else {
//                    scaleText.setText("Zooming In");
            }
            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
//            View child = MyRecyclerView.findChildViewUnder(scaleGestureDetector.getFocusX(), );
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            Log.d("Scaling", "onScale: b");
        }
    });

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        this.mScaleDetector.onTouchEvent(e);
        return super.onTouchEvent(e);
    }
}

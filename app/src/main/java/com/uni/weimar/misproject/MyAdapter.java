package com.uni.weimar.misproject;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

interface isExpandabale{
    public void expand();
}

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder implements isExpandabale{
        // each data item is just a string in this case
        public View textView;
        public View line;
        private ScaleGestureDetector mScaleDetector;

        public void expand(){
//            this.textView.setT("GG");
            line.setVisibility(View.VISIBLE);
        }

        public MyViewHolder(View v) {
            super(v);
            textView = v;
            mScaleDetector = new ScaleGestureDetector(v.getContext(), new ScaleGestureDetector.OnScaleGestureListener() {
                @Override
                public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                    float scaleFactor = scaleGestureDetector.getScaleFactor();
                    Log.d("Scaling", "onScale: "+scaleFactor);
                    if (scaleFactor > 1) {
//                    scaleText.setText("Zooming Out");
                        line.setVisibility(View.VISIBLE);
                    } else {
//                    scaleText.setText("Zooming In");
                    }
                    return true;
                }

                @Override
                public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                    return true;
                }

                @Override
                public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                    Log.d("Scaling", "onScale: b");
                }
            });
            this.line = (View) v.findViewById(R.id.line);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (line.getVisibility() == View.INVISIBLE)
                        line.setVisibility(View.VISIBLE);
                    else line.setVisibility(View.INVISIBLE);
                }
            });
            v.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
//                    Log.d("TOUCH", "onTouch: ");
                    mScaleDetector.onTouchEvent(motionEvent);
                    return true;
                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        holder.textView.setText(mDataset[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
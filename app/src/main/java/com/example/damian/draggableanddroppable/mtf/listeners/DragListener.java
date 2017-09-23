package com.example.damian.draggableanddroppable.mtf.listeners;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.damian.draggableanddroppable.mtf.adapter.MtfAdapter;


/**
 * Created by damian on 8/9/17.
 * This makes a view listen to dragEvents . For any view that doesnt want to listen to dropEvent just pass in false to the ctor;
 * You can also set this with the help of the public setter.
 * By default all views attached to this DragListener are Droppable.
 */

public class DragListener implements View.OnDragListener {

    /*if droppable is set the view is droppable ... ie it listens to dropEvent*/
    private boolean droppable;
    private RecyclerView.Adapter adapter;
    /* cant use getAdapterPosition at the time of making since the view hasnt been painted yet.. hence it returns -1... will have to use the ref
    * of the obj...*/
    private int viewHolderPosition;
    private MtfAdapter.MtfViewHolder viewHolder;
    //private PairMaker pairMaker;


    public DragListener(boolean droppable,  RecyclerView.Adapter mtf, MtfAdapter.MtfViewHolder viewHolder){
        this.droppable=droppable;
        this.adapter=mtf;
        this.viewHolder=viewHolder;
        log("received "+droppable);
    }


    public void setDroppable(boolean droppable){
        this.droppable=droppable;
    }

    @Override
    public boolean onDrag(View viewDroppedUpon , DragEvent de){
        /* handling dragEvents here */

        switch (de.getAction()){

            case DragEvent.ACTION_DRAG_STARTED:
                log("StartingDrag"+DragEvent.ACTION_DRAG_STARTED);
                return true;

            case DragEvent.ACTION_DRAG_ENDED:
                log("Ending Drag"+DragEvent.ACTION_DRAG_ENDED);
                return true;

            case DragEvent.ACTION_DRAG_ENTERED:
                log("Drag entered "+DragEvent.ACTION_DRAG_ENTERED);
                return true;

            case DragEvent.ACTION_DRAG_EXITED:
                log("Drag ended "+DragEvent.ACTION_DRAG_ENDED);

                return true;

            case DragEvent.ACTION_DRAG_LOCATION:
                log("Drag location "+DragEvent.ACTION_DRAG_LOCATION);
                return true;

            case DragEvent.ACTION_DROP:
                if(droppable) {
                    log("Action dropped " + DragEvent.ACTION_DROP);
                /* the dragged view ... */
                   // View v = (View) de.getLocalState();

                /* make it invisible where it was*/
                    /*v.setVisibility(View.INVISIBLE);
                    TextView dropTarget = (TextView) view;
                    TextView dropped = (TextView) v;

                    dropTarget.setText(dropped.getText());
                    dropTarget.setTypeface(Typeface.DEFAULT_BOLD);*/
                    View dropped=(View)de.getLocalState();

                    log("viewDroppedUpon tag "+viewDroppedUpon.getTag());
                    log("dropped tag "+dropped.getTag());

                    if(this.adapter instanceof PairMaker)
                        ((PairMaker) this.adapter).makePairs(viewDroppedUpon,dropped,this.viewHolder.getAdapterPosition());


                    /* TODO to make it dropable again*/

                    this.droppable=false;
                }return this.droppable;
        }



        return false;
    }


    private void log(String x){
        Log.i("DragListener",x);
    }

}

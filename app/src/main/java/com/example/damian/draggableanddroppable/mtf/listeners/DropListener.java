package com.example.damian.draggableanddroppable.mtf.listeners;

import android.graphics.Typeface;
import android.os.Handler;
import android.support.v4.provider.DocumentFile;
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
 * By default all views attached to this DropListener are Droppable.
 */

public class DropListener implements View.OnDragListener {

    /*if droppable is set the view is droppable ... ie it listens to dropEvent*/
    private boolean droppable;
    private MtfAdapter adapter,otherAdapter;
    /* cant use getAdapterPosition at the time of making since the view hasnt been painted yet.. hence it returns -1... will have to use the ref
    * of the obj...*/
    private int viewHolderPosition;
    private MtfAdapter.MtfViewHolder viewHolder;
    private static boolean hasReallyDropped=false;
    private Remover remover;

    //private PairMaker pairMaker;


    public DropListener(boolean droppable,  MtfAdapter mtf, MtfAdapter.MtfViewHolder viewHolder,Remover remover){
        this.droppable=droppable;
        log("ctor droplistener "+droppable);
        this.adapter=mtf;
        this.viewHolder=viewHolder;
        log("received "+droppable);
        this.remover=remover;

    }



    @Override
    public boolean onDrag(View viewDroppedUpon , DragEvent de){
        /* handling dragEvents here */


        log("adapter pos"+this.viewHolder.getAdapterPosition());
        switch (de.getAction()){

            case DragEvent.ACTION_DRAG_STARTED:
                //log("StartingDrag"+DragEvent.ACTION_DRAG_STARTED);
                return true;

            case DragEvent.ACTION_DRAG_ENDED:
                //log("Ending Drag"+DragEvent.ACTION_DRAG_ENDED);
                return true;

            case DragEvent.ACTION_DRAG_ENTERED:
                //log("Drag entered "+DragEvent.ACTION_DRAG_ENTERED);
                return true;

            case DragEvent.ACTION_DRAG_EXITED:
                //log("Drag ended "+DragEvent.ACTION_DRAG_ENDED);

                return true;

            case DragEvent.ACTION_DRAG_LOCATION:
                //log("Drag location "+DragEvent.ACTION_DRAG_LOCATION);
                return true;

            case DragEvent.ACTION_DROP:
                //log("droppable is "+this.droppable);

                if(droppable) {
                    log("Action dropped " + DragEvent.ACTION_DROP);

                    View dropped=(View)de.getLocalState();


                    log("viewDroppedUpon tag "+viewDroppedUpon.getTag());
                    log("dropped tag "+dropped.getTag());
                    int pos=this.viewHolder.getAdapterPosition();
                    DropListener.hasReallyDropped=true;
                        ((PairMaker) this.adapter).makePairs(viewDroppedUpon,dropped,pos);

                    if(this.remover!=null)
                        this.remover.removeItem(LongPressListener.getPosition());



                }


                return this.droppable;
        }



        return false;
    }


    @Override
    public void finalize()throws Throwable{
        super.finalize();


    }

    private void log(String x){
        Log.d("DropListener",x);
    }

}

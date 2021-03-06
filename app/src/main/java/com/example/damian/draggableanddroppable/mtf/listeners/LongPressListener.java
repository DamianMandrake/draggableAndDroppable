package com.example.damian.draggableanddroppable.mtf.listeners;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.os.Build;
import android.util.Log;
import android.view.View;

import com.example.damian.draggableanddroppable.mtf.adapter.MtfAdapter;

/**
 * Created by damian on 8/9/17.
 */

public class LongPressListener implements View.OnLongClickListener,TouchConstants {

    private static final String TAG="LongPress";
    private boolean triggerDrag;
    private MtfAdapter.MtfViewHolder mtfViewHolder;
    private MtfAdapter mtfAdapter;
    private static int position=-1;

    public LongPressListener(boolean triggerDrag, MtfAdapter adapter, MtfAdapter.MtfViewHolder mtfViewHolder){
        this.triggerDrag=triggerDrag;
        this.mtfAdapter=adapter;
        this.mtfViewHolder=mtfViewHolder;
    }

    public void setTriggerDrag(boolean b){
        this.triggerDrag=b;
    }

    public static int getPosition(){
        return LongPressListener.position;
    }
    //suppressing warnings
    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public boolean onLongClick(View view){

        Log.d(TAG,"longClick"+this.triggerDrag);
                if(this.triggerDrag) {
              /* setting up drag here */
                    ClipData clipData = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

              /* since startDragAndDrop has been added in 24 and startDrag existed before it */
                    if (Build.VERSION.SDK_INT >= TouchConstants.NOUGAT)
                        view.startDragAndDrop(clipData, shadowBuilder, view, 0);
                    else
                        view.startDrag(clipData, shadowBuilder, view, 0);

                    LongPressListener.position=this.mtfViewHolder.getAdapterPosition();


                }
        return this.triggerDrag;



    }
}
interface TouchConstants{
    public final static int NOUGAT=24;
    /*to be used only when implementing a custom MotionEvent*/
    public final static long LONGPRESS_THRESHOLD=1000L;
}

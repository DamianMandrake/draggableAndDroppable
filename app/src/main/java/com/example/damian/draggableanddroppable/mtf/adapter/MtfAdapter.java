package com.example.damian.draggableanddroppable.mtf.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.damian.draggableanddroppable.mtf.listeners.DragListener;
import com.example.damian.draggableanddroppable.mtf.listeners.LongPressListener;
import com.example.damian.draggableanddroppable.mtf.listeners.PairMaker;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by damian on 23/9/17.
 */

public abstract class MtfAdapter extends RecyclerView.Adapter<MtfAdapter.MtfViewHolder> implements PairMaker {

    /* to be used for watching List items ie whenever the drop event is fired ... To be extended by the  draggable adapter only...*/
    /* will need a reference of the other adapter. */
    private static final String TAG="MtfAdapter";
    private ArrayList<Object> mainData,tempData;
    private JSONObject jsonObject;
    public MtfAdapter(final ArrayList data){
        this.tempData=new ArrayList();
        this.jsonObject=new JSONObject();
        this.tempData.addAll(data);
        this.mainData=data;


    }
    private void resetArrayList(){
        this.tempData.clear();
        this.tempData.addAll(this.mainData);
    }

    //overriding method of PairMaker
    @Override
    public void makePairs(View dest, View source,int pos){
        Log.d(TAG,"in makePairs");
        try {
            this.jsonObject.put(dest.getTag().toString(), source.getTag().toString());
            this.tempData.remove(pos);
            this.notifyDataSetChanged();
        }catch (JSONException js){
            js.printStackTrace();
        }
    }

    /* to be used by base class ... */
    final public Object getElementAt(int index){
        return this.tempData.get(index);
    }
    @Override
    final public int getItemCount(){
        return this.tempData.size();
    }




    /**
     * Created by damian on 18/9/17.
     */

    public static abstract class MtfViewHolder extends RecyclerView.ViewHolder{
        private View view;
        private final static String TAG="MtfViewHolder";
        public MtfViewHolder(View view,RecyclerView.Adapter adapter){
            this(view,false,adapter);
        }

        /* If is isDraggable is true a LongPressListener is attatched to the viewHolder. The LongPressListener gives a call to startDrag
        * thus making it draggable. The viewHolder is attatched to a dragListener by defualt so that it can be dropped*/
        public MtfViewHolder(View view,boolean isDroppable,RecyclerView.Adapter adapter){
            super(view);
            this.view=view;
            Log.d(TAG,"setting listeners");
            if(isDroppable)view.setOnDragListener(new DragListener(isDroppable,adapter,this));
            view.setOnLongClickListener(new LongPressListener(!isDroppable));

        }

        public final void setDragDropData(String x){
            this.view.setTag(x);

        }


    }








}

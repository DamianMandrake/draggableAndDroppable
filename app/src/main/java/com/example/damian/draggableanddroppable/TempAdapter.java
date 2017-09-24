package com.example.damian.draggableanddroppable;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.damian.draggableanddroppable.mtf.adapter.MtfAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by damian on 20/9/17.
 */

/*public class TempAdapter extends RecyclerView.Adapter<TempAdapter.TempViewHolder> {

    private ArrayList<String> arrayList;
    private LayoutInflater inflater;
    private int layoutid;
    private boolean isDroppable;
    public TempAdapter(Context context,ArrayList<String> data,int layout){
        this(context,data,layout,false);
    }
    public TempAdapter(Context context, ArrayList<String> data,int layout,boolean isDroppable){
        this.inflater=LayoutInflater.from(context);
        this.layoutid=layout;
        this.arrayList=data;
        this.isDroppable=isDroppable;
    }

    @Override
    public TempAdapter.TempViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=(View)this.inflater.inflate(this.layoutid,parent,false);
        return new TempViewHolder(view,this.isDroppable,this);
    }

    @Override
    public void onBindViewHolder(TempViewHolder holder, int position) {
        holder.textView.setText(this.arrayList.get(position));
        holder.setDragData(this.arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.arrayList.size();
    }

      static class TempViewHolder extends MtfAdapter.MtfViewHolder{
        private TextView textView;
        private ImageView imageView;
         public TempViewHolder(View view,boolean isDroppable,MtfAdapter adapter){
             super(view,isDroppable,adapter);
             textView=(TextView)view.findViewById(R.id.tv1);

         }
        /* necessary .... */
   /*     public void setDragData(String x){
            super.setDragDropData(x);
        }

    }
}*/

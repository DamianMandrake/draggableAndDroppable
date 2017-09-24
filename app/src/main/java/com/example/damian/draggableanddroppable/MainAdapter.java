package com.example.damian.draggableanddroppable;

/**
 * Created by damian on 23/9/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.damian.draggableanddroppable.mtf.adapter.MtfAdapter;
import com.example.damian.draggableanddroppable.mtf.listeners.Remover;

import java.util.ArrayList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by damian on 20/9/17.
 */

public class MainAdapter extends MtfAdapter {

    private ArrayList<String> arrayList;
    private LayoutInflater inflater;
    private int layoutid;
    private boolean isDroppable;
    private Remover remover;

    public MainAdapter(Context context, ArrayList<String> data,int layout,boolean isDroppable){
        super(data);
        this.inflater=LayoutInflater.from(context);
        this.layoutid=layout;
        this.arrayList=data;
        this.isDroppable=isDroppable;
    }
    public MainAdapter(Context context, ArrayList<String> data,int layout,boolean isDroppable,Remover remover ) {
        this(context,data,layout,isDroppable);
        this.remover=remover;
    }


        @Override
    public MainAdapter.TempViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=(View)this.inflater.inflate(this.layoutid,parent,false);
        return new TempViewHolder(view,this.isDroppable,this,remover);
    }

    @Override
    public void onBindViewHolder(MtfAdapter.MtfViewHolder holder, int position) {
        ((MainAdapter.TempViewHolder)holder).textView.setText(super.getElementAt(position).toString());
        ((MainAdapter.TempViewHolder)holder).setDragData(this.arrayList.get(position));
    }



    static class TempViewHolder extends MtfAdapter.MtfViewHolder {
        private TextView textView;
        private ImageView imageView;
        public TempViewHolder(View view,boolean isDroppable,MtfAdapter adapter,Remover remover){
            super(view,isDroppable,adapter,remover);
            textView=(TextView)view.findViewById(R.id.tv1);

        }
        /* necessary .... */
        public void setDragData(String x){
            super.setDragDropData(x);
        }

    }
}


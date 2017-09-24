package com.example.damian.draggableanddroppable.mtf;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.damian.draggableanddroppable.mtf.listeners.DropListener;
import com.example.damian.draggableanddroppable.mtf.listeners.LongPressListener;

/**
 * Created by damian on 17/9/17.
 *
 */

public class MTFView extends LinearLayout {
    private Context context;
    private RecyclerView questionRecycler,answerRecycler;
    private final String TAG="MTFView";
    private LinearLayout left,right;
    public MTFView(Context context){
        this(context,null);

    }
    public MTFView(Context context, AttributeSet attr){
        this(context,attr,0);
    }
    public MTFView(Context context,AttributeSet attr,int defStyle){
        super(context,attr,defStyle);
        this.context=context;
        Log.d(TAG,"CTOR");

        this.left=new LinearLayout(context);
        this.left.setLayoutParams(new RecyclerView.LayoutParams(250, ViewGroup.LayoutParams.MATCH_PARENT));

        this.right=new LinearLayout(context);
        this.left.setLayoutParams(new RecyclerView.LayoutParams(250, ViewGroup.LayoutParams.MATCH_PARENT));

        this.addView(left);
        this.addView(right);
        /* set custom attributes with TypedArrays*/
    }


    public void setQuestionRecycler(RecyclerView recyclerView){
        this.questionRecycler=recyclerView;
        this.questionRecycler.setLayoutManager(new LinearLayoutManager(this.context));
        //TODO ADD THE RECYLERVIEW TO THE MAINVIEW
        this.left.addView(this.questionRecycler);

    }

    public void setQuestionRecycler(RecyclerView recycler,RecyclerView.Adapter adapter){
        this.setQuestionRecycler(recycler);
        this.setQuestionAdapter(adapter);

    }

    public void setAnswerRecycler(RecyclerView recycler,RecyclerView.Adapter adapter){
        this.setAnswerRecycler(recycler);
        this.setAnswerAdapter(adapter);
    }


    public void setAnswerRecycler(RecyclerView recyclerView){
        this.answerRecycler=recyclerView;
        this.answerRecycler.setLayoutManager(new LinearLayoutManager(this.context));
        //TODO ADD THE RECYLERVIEW TO THE MAINVIEW
        this.right.addView(answerRecycler);
    }

    public void setAnswerAdapter(RecyclerView.Adapter adapter){
        this.answerRecycler.setAdapter(adapter);
        /* since */
        //this.answerRecycler.setOnLongClickListener(new LongPressListener());
        //this.answerRecycler.setOnDropListener(new DropListener());

    }

    public void setQuestionAdapter(RecyclerView.Adapter adapter){
        this.questionRecycler.setAdapter(adapter);
        /* this makes this recycler droppable only*/
        //this.questionRecycler.setLayoutManager(new LinearLayoutManager(this.context));
        //this.questionRecycler.setOnDropListener(new DropListener());
    }



}

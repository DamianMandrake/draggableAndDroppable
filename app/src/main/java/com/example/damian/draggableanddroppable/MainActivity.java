package com.example.damian.draggableanddroppable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.damian.draggableanddroppable.mtf.MTFView;
import com.example.damian.draggableanddroppable.mtf.listeners.DragListener;
import com.example.damian.draggableanddroppable.mtf.listeners.LongPressListener;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MTFView mtf=(MTFView)findViewById(R.id.mtf);
        RecyclerView recyclerView=new RecyclerView(this);
        ArrayList<String> q=new ArrayList<>(),b=new ArrayList<>();
        for(int i=0;i<10;i++) {
            q.add(i + " world ");
            b.add(i+" hello");
        }

        mtf.setQuestionRecycler(new RecyclerView(this),new TempAdapter(this,b,R.layout.viewholder,true));


        mtf.setAnswerRecycler(recyclerView,new MainAdapter(this,q,R.layout.viewholder,false));
    }

}

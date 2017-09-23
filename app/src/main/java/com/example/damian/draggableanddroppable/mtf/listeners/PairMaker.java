package com.example.damian.draggableanddroppable.mtf.listeners;

import android.view.View;

/**
 * Created by damian on 23/9/17.
 */

public interface PairMaker {
    //need source postion to delete the element from the list...
    public void makePairs(View dest,View source,int sourcePosition);
}

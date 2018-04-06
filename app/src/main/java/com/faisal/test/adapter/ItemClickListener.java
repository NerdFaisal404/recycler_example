package com.faisal.test.adapter;

import android.view.View;

public interface ItemClickListener<T>{
    void onItemClick(View view, T item);
}


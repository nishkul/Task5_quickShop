package com.android.task.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Manish on 19/4/17.
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * The constant TAG.
     */
    public static final String TAG=BaseActivity.class.getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAllMethod();
    }


    /**
     * Init all method.
     */
    protected  void initAllMethod(){
        initialingLayout();
        initialingMember();
        initialingData();
        initialingListener();
    }

    /**
     * Initialing layout.
     */
    protected abstract void initialingLayout();

    /**
     * Initialing member.
     */
    protected abstract void initialingMember();

    /**
     * Initialing data.
     */
    protected abstract void initialingData();

    /**
     * Initialing listener.
     */
    protected abstract void initialingListener();
}
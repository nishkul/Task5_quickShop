package com.android.task.ui;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.task.R;
import com.android.task.adaptor.ServiceRecycleAdaptor;
import com.android.task.ui.base.BaseActivity;

/**
 * Created by Manish on 20/4/17.
 */
public class ServiceListAcitivity extends BaseActivity {
    private RecyclerView mReycleview;


    @Override
    protected void initialingLayout() {
        setContentView(R.layout.common_list);
    }

    @Override
    protected void initialingMember() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
                mReycleview = (RecyclerView) findViewById(R.id.recyclerview);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.VISIBLE);
    }

    @Override
    protected void initialingData() {
        String[] categoryList = getResources().getStringArray(R.array.services_list);
        mReycleview.setHasFixedSize(true);
        mReycleview.setLayoutManager( new LinearLayoutManager(ServiceListAcitivity.this));
        ServiceRecycleAdaptor rcAdapter = new ServiceRecycleAdaptor(ServiceListAcitivity.this, categoryList);
        mReycleview.setAdapter(rcAdapter);
    }

    @Override
    protected void initialingListener() {

    }
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_chat) {
            return true;
        }   else
        if (id == R.id.action_User) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

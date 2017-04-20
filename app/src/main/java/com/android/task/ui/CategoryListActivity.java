package com.android.task.ui;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.task.R;
import com.android.task.adaptor.CategoryListRecycleAdaptor;
import com.android.task.ui.base.BaseActivity;

/**
 * Created by Manish on 20/4/17.
 */

public class CategoryListActivity extends BaseActivity {
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
    }

    @Override
    protected void initialingData() {
        String[] categoryList = getResources().getStringArray(R.array.category_list);
        mReycleview.setHasFixedSize(true);
        mReycleview.setLayoutManager(new LinearLayoutManager(CategoryListActivity.this));
        CategoryListRecycleAdaptor rcAdapter = new CategoryListRecycleAdaptor(CategoryListActivity.this, categoryList);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_chat) {
            startActivity(new Intent(CategoryListActivity.this, ChatListActivity.class));
            return true;
        } else if (id == R.id.action_User) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

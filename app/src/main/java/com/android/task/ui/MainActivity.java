package com.android.task.ui;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.task.R;
import com.android.task.adaptor.HomeScreenRecycleAdaptor;
import com.android.task.model.HomeModel;
import com.android.task.ui.base.BaseActivity;

import java.util.ArrayList;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private FloatingActionButton fab;
    private NavigationView navigationView;
    private RecyclerView mReycleview;
    private TypedArray navMenuIcons;
    private ArrayList<HomeModel> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    protected void initialingLayout() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initialingMember() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        mReycleview = (RecyclerView) findViewById(R.id.recyclerview);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);

    }

    @Override
    protected void initialingData() {
        String[] titles = getResources().getStringArray(R.array.home_screen_title);


        TypedArray navMenuIcons = getResources()
                .obtainTypedArray(R.array.home_screen_icon);
        nameList = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {

            HomeModel homeModel = new HomeModel();
            homeModel.setName(titles[i]);
            homeModel.setLogoi(navMenuIcons.getResourceId(i, 0));

            nameList.add(homeModel);
        }


        GridLayoutManager lLayout = new GridLayoutManager(MainActivity.this, 2);

        mReycleview.setHasFixedSize(true);
        mReycleview.setLayoutManager(lLayout);

        HomeScreenRecycleAdaptor rcAdapter = new HomeScreenRecycleAdaptor(MainActivity.this, nameList);
        mReycleview.setAdapter(rcAdapter);
    }

    @Override
    protected void initialingListener() {
        navigationView.setNavigationItemSelectedListener(this);
        fab.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_chat) {
            startActivity(new Intent(MainActivity.this, ChatListActivity.class));
            return true;
        } else if (id == R.id.action_User) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_about_us) {

        } else if (id == R.id.nav_contact_us) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                Snackbar.make(v, "Edit option in list", Snackbar.LENGTH_LONG)
                        .show();
                break;

        }
    }
}

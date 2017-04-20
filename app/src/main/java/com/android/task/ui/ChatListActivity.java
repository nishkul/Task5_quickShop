package com.android.task.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.android.task.R;
import com.android.task.adaptor.ChatRecycleAdaptor;
import com.android.task.model.ChatModel;
import com.android.task.ui.base.BaseActivity;
import java.util.ArrayList;

/**
 * Created by Manish on 20/4/17.
 */
public class ChatListActivity extends BaseActivity {
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

        ArrayList<ChatModel> chatModelArrayList = new ArrayList<>();
        chatModelArrayList.add(new ChatModel(1, "Global Electronics", "2 min ago", "Fine Sir will deliver sample on you registered ", false));
        chatModelArrayList.add(new ChatModel(2, "Krishna Lights Junction", "5 min ago", "Fine Sir will deliver sample on you registered ", false));
        chatModelArrayList.add(new ChatModel(0, "Patel Electronics", "10 min ago", "Thank you sir!", true));
        chatModelArrayList.add(new ChatModel(0, "Global Electronics", "30 min ago", "No problem sir will update soon ", false));
        chatModelArrayList.add(new ChatModel(9, "Eco Lighting Solution", "2 days ago", "Sorry sir ", false));
        chatModelArrayList.add(new ChatModel(0, "Bombay Electronics", "45 min ago", "How can i help you sir  ", false));
        chatModelArrayList.add(new ChatModel(0, "Grotal Lights & Products", "3 days ago", "welcome sir ", false));
        chatModelArrayList.add(new ChatModel(0, "Opera Solutions", "1 day ago", "Product is delivery ", false));
        chatModelArrayList.add(new ChatModel(0, "Oreva Electronics", "2 min ago", "Thank you sir! ", true));

        mReycleview.setLayoutManager(new LinearLayoutManager(ChatListActivity.this));
        ChatRecycleAdaptor rcAdapter = new ChatRecycleAdaptor(ChatListActivity.this, chatModelArrayList);
        mReycleview.setHasFixedSize(true);
        mReycleview.setAdapter(rcAdapter);
    }

    @Override
    protected void initialingListener() {

    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            return true;
        } else

            return super.onOptionsItemSelected(item);
    }
}

package com.android.task.adaptor;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.task.R;
import com.android.task.model.HomeModel;
import com.android.task.ui.CategoryListActivity;

import java.util.ArrayList;

/**
 * Created by Manish on 19/4/17.
 */
public class HomeScreenRecycleAdaptor extends RecyclerView.Adapter<HomeScreenRecycleAdaptor.ViewHolder> {
    /**
     * The Home model array list.
     */
    ArrayList<HomeModel> homeModelArrayList;
    private Activity activity;

    /**
     * Instantiates a new Home screen recycle adaptor.
     *
     * @param mainActivity the main activity
     * @param nameList     the name list
     */
    public HomeScreenRecycleAdaptor(Activity mainActivity, ArrayList<HomeModel> nameList) {
        this.activity = mainActivity;
        this.homeModelArrayList = nameList;
    }

    @Override
    public HomeScreenRecycleAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.homescreen_row_layout, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(HomeScreenRecycleAdaptor.ViewHolder holder, int position) {
         HomeModel model = (HomeModel) homeModelArrayList.get(position);
        if (model != null) {
            holder.mTitle.setText(model.getName().trim());
            holder.mLogo.setImageResource(model.getLogoi());
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.startActivity(new Intent(activity, CategoryListActivity.class));
                }
            });
        }

    }


    @Override
    public int getItemCount() {
        return homeModelArrayList.size();
    }

    /**
     * The type View holder.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        /**
         * The M title.
         */
        public TextView mTitle;
        private ImageView mLogo;
        private View view;

        /**
         * Instantiates a new View holder.
         *
         * @param v the v
         */
        public ViewHolder(View v) {
            super(v);
            this.view = v;
            mTitle = (TextView) v.findViewById(R.id.title_tv);
            mLogo = (ImageView) v.findViewById(R.id.logo_iv);

        }

    }
}

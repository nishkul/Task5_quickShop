package com.android.task.adaptor;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.task.R;
import com.android.task.ui.CategoryListActivity;
import com.android.task.ui.ServiceListAcitivity;

/**
 * Created by Manish on 20/4/17.
 */
public class CategoryListRecycleAdaptor extends RecyclerView.Adapter<CategoryListRecycleAdaptor.ViewHolder> {
    /**
     * The Category arry.
     */
    String[] categoryArry;
    private Activity activity;

    /**
     * Instantiates a new Category list recycle adaptor.
     *
     * @param categoryListActivity the category list activity
     * @param categoryList         the category list
     */
    public CategoryListRecycleAdaptor(CategoryListActivity categoryListActivity, String[] categoryList) {
        this.activity = categoryListActivity;
        this.categoryArry = categoryList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categorylist_row, parent, false);
        return new CategoryListRecycleAdaptor.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String model = categoryArry[position];
        if (model != null) {
            holder.mCategory.setText(model.trim());
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.startActivity(new Intent(activity, ServiceListAcitivity.class));
                }
            });
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return categoryArry.length;
    }

    /**
     * The type View holder.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        /**
         * The M category.
         */
        public TextView mCategory;
        private View view;

        /**
         * Instantiates a new View holder.
         *
         * @param v the v
         */
        public ViewHolder(View v) {
            super(v);
            this.view = v;
            mCategory = (TextView) v.findViewById(R.id.categoryLabel_tv);

        }
    }
}

package com.android.task.adaptor;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.task.R;
import com.android.task.ui.ServiceListAcitivity;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by Manish on 20/4/17.
 */
public class ServiceRecycleAdaptor extends RecyclerView.Adapter<ServiceRecycleAdaptor.ViewHolder> {
    /**
     * The Services arry.
     */
    String[] servicesArry;
    private Activity activity;


    /**
     * Instantiates a new Service recycle adaptor.
     *
     * @param serviceListAcitivity the service list acitivity
     * @param servicesList         the services list
     */
    public ServiceRecycleAdaptor(ServiceListAcitivity serviceListAcitivity, String[] servicesList) {
        this.activity = serviceListAcitivity;
        this.servicesArry = servicesList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.service_row, parent, false);
        return new ServiceRecycleAdaptor.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String model = servicesArry[position];
        if (model != null) {
            holder.mServiceLabel.setText(model.trim());
            holder.mDistance.setText(activity.getResources().getString(R.string.distance_away, String.valueOf(generateRamdomDistance())));

        }


    }

    private float generateRamdomDistance() {
        float start = 10;
        float end = 1;
        float random = new Random().nextFloat();
        float result = start + (random * (end - start));
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        float twoDigitsF = Float.valueOf(decimalFormat.format(result));

        return twoDigitsF;
    }


    @Override
    public int getItemCount() {
        return servicesArry.length;
    }

    /**
     * The type View holder.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        /**
         * The M service label.
         */
        public TextView mServiceLabel;
        /**
         * The M distance.
         */
        public TextView mDistance;
        private View view;

        /**
         * Instantiates a new View holder.
         *
         * @param v the v
         */
        public ViewHolder(View v) {
            super(v);
            this.view = v;
            mServiceLabel = (TextView) v.findViewById(R.id.service_tv);
            mDistance = (TextView) v.findViewById(R.id.distance_tv);

        }
    }
}

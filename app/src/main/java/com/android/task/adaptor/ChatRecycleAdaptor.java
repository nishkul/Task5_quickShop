package com.android.task.adaptor;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.task.R;
import com.android.task.model.ChatModel;

import java.util.ArrayList;

/**
 * Created by Manish on 20/4/17.
 */
public class ChatRecycleAdaptor extends RecyclerView.Adapter<ChatRecycleAdaptor.Viewholder> {
    /**
     * The Array list.
     */
    ArrayList<ChatModel> arrayList;
    private Activity mActivity;

    /**
     * Instantiates a new Chat recycle adaptor.
     *
     * @param mainActivity the main activity
     * @param nameList     the name list
     */
    public ChatRecycleAdaptor(Activity mainActivity, ArrayList<ChatModel> nameList) {
        this.mActivity = mainActivity;
        this.arrayList = nameList;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_row, parent, false);
        return new ChatRecycleAdaptor.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
         ChatModel model = (ChatModel) arrayList.get(position);
        if (model != null) {
            holder.mTitle.setText(model.getTitle().trim());
            holder.mMessage.setText(model.getMessage().trim());
            holder.mTime.setText(model.getTime().trim());
            if (model.getChatCount() > 0) {
                holder.mCount.setText(model.getChatCount() + "");
                holder.mTitle.setTextColor(mActivity.getResources().getColor(R.color.edit));
            } else {
                holder.mBdgeLayout.setVisibility(View.GONE);
            }
            if (model.isDone()) {
                holder.mHandShake.setImageResource(R.drawable.vc_handshake);
            } else {
                holder.mHandShake.setImageResource(R.drawable.vc_handshake_unfill);


                holder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View contentView = inflater.inflate(R.layout.done_dialog, null);
                        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
                        builder.setView(contentView);
                        Button yesBtn = (Button) contentView.findViewById(R.id.yes_btn);
                        Button noBtn = (Button) contentView.findViewById(R.id.no_btn);

                        final AlertDialog alertDialog = builder.create();
                        noBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialog.dismiss();

                            }
                        });

                        yesBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialog.cancel();
                            }
                        });
                        alertDialog.setCancelable(true);
                        alertDialog.show();

                    }
                });
            }


        }

    }


    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    /**
     * The type Viewholder.
     */
    public class Viewholder extends RecyclerView.ViewHolder {
        /**
         * The M title.
         */
        public TextView mTitle;
        /**
         * The M bdge layout.
         */
        public RelativeLayout mBdgeLayout;
        /**
         * The M message.
         */
        public TextView mMessage;
        /**
         * The M time.
         */
        public TextView mTime;
        /**
         * The M hand shake.
         */
        public ImageView mHandShake;
        /**
         * The M count.
         */
        public TextView mCount;
        private View view;

        /**
         * Instantiates a new Viewholder.
         *
         * @param v the v
         */
        public Viewholder(View v) {
            super(v);
            this.view = v;
            mTitle = (TextView) v.findViewById(R.id.title_tv);
            mBdgeLayout = (RelativeLayout) v.findViewById(R.id.badge_status_iv);
            mCount = (TextView) v.findViewById(R.id.count_tv);
            mMessage = (TextView) v.findViewById(R.id.message_tv);
            mTime = (TextView) v.findViewById(R.id.time_tv);
            mHandShake = (ImageView) v.findViewById(R.id.handshake_iv);

        }
    }
}

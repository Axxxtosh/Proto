package com.uriah.mmvm.bookmyticket;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ashet on 08-02-2018.
 */

public class OngoingAdapter extends RecyclerView.Adapter<OngoingAdapter.ViewHolder> {




    private Context ctx;
    public OngoingAdapter(Context ctx){

        this.ctx=ctx;



    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)

    {
        View v = LayoutInflater.from(ctx)
                .inflate(R.layout.row_ongoing_item, parent, false);
        return new OngoingAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ctx, DemoActivity1.class);
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

    {

        @BindView(R.id.book_btn)
        Button btn;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        public void onClick(View v) {


        }
    }

}



package com.liqian.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LinearRecyclerViewAdapter extends RecyclerView.Adapter<LinearRecyclerViewAdapter.LinearViewHolder> {

    private Context mContext;
    private List<String> list;

    public LinearRecyclerViewAdapter(Context context){
        this.mContext = context;

    }

    @NonNull
    @Override
    public LinearRecyclerViewAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.linear_layout, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearRecyclerViewAdapter.LinearViewHolder holder, int position) {
        holder.textView.setText("Liqian Yang");

    }


    @Override
    public int getItemCount() {
        return 60;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
        }
    }
}

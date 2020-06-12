package com.liqian.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class GridRecyclerViewAdapter extends RecyclerView.Adapter {

    private LayoutInflater layoutInflater;
    private ArrayList<HashMap<String,Object>> listItem;
    private MyItemClickListener myItemClickListener;

    public GridRecyclerViewAdapter(Context context, ArrayList<HashMap<String, Object>> listItem){
        this.listItem = listItem;
        layoutInflater = LayoutInflater.from(context);

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.grid_layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder vh = (ViewHolder) holder;
        vh.imageView.setImageResource((Integer) listItem.get(position).get("ItemImage"));

    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public void setOnItemClickListener(MyItemClickListener listener){
        myItemClickListener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ((myItemClickListener != null)){
                        myItemClickListener.onItemClick(v,getAdapterPosition());
                    }
                }
            });
        }

        public ImageView getImg(){
            return imageView;
        }


    }




}

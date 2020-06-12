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

public class StaggeredGridViewAdapter extends RecyclerView.Adapter {

    private LayoutInflater layoutInflater;
    private ArrayList<HashMap<String, Object>> itemList;
    private MyItemClickListener myItemClickListener;

    public StaggeredGridViewAdapter(Context context, ArrayList<HashMap<String, Object>> itemList){
        this.itemList = itemList;
        layoutInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.sg_layout,null));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;

        if (position % 2 == 0){
            vh.imageView.setImageResource((Integer) itemList.get(position).get("dolphin"));
        }else{
            vh.imageView.setImageResource((Integer) itemList.get(position).get("bear"));
        }





    }

    public void setOnItemClickListener(MyItemClickListener listener){
        myItemClickListener = listener;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgview_sg);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (myItemClickListener != null){
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

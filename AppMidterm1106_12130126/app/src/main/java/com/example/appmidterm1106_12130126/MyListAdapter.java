package com.example.appmidterm1106_12130126;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private List<MyListData> listData;
    private Context context;

    public MyListAdapter(List<MyListData> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(listData.get(position).getTitle());
        holder.imageView.setImageResource(listData.get(position).getImgId());


        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(context, SecondActivity.class);


            intent.putExtra("title", listData.get(position).getTitle());
            intent.putExtra("description", listData.get(position).getDescription());


            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.textView);
            this.imageView = itemView.findViewById(R.id.imageView);
        }
    }
}

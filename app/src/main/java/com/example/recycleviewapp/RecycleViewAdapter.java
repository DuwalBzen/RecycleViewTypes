package com.example.recycleviewapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    int lastPosition=-1;
    Context context;
    List<list_row_model> list_row_data;

    public RecycleViewAdapter(Context context, List list_row_models) {
        this.context = context;
        this.list_row_data = list_row_models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Animation animation = AnimationUtils.loadAnimation(context,
                (position > lastPosition) ? R.anim.recycleview_up_from_bottom
                        : R.anim.recycleview_down_from_top);
        holder.itemView.startAnimation(animation);
        lastPosition = position;

        list_row_model item=list_row_data.get(position);
        holder.row_image.setImageResource(item.getImage_id());

    }

    @Override
    public int getItemCount() {
        return list_row_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView row_image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            row_image=itemView.findViewById(R.id.rowlist_image_id);
        }

        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            list_row_model item=list_row_data.get(position);
            Intent sento_details=new Intent(context,DetailedActivity.class);
            sento_details.putExtra("ïmage_id",item.getImage_id());
            context.startActivity(sento_details);
        }
    }
}

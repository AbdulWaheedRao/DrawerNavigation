package com.example.navigationdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CategoryAdopter extends RecyclerView.Adapter<CategoryAdopter.ViewHolder> {
    Context context;
    List<CategoryModel> categoryModelList;

    public CategoryAdopter(Context context, List<CategoryModel> categoryModelList) {
        this.context = context;
        this.categoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(categoryModelList.get(position).getImag_url()).into(holder.ivDemo);
        holder.name.setText(categoryModelList.get(position).getName());
        holder.tvdes.setText(categoryModelList.get(position).getDescription());
        holder.tvdis.setText(categoryModelList.get(position).getDiscount());

    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivDemo;
        TextView name,tvdes,tvdis,tvper;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivDemo=itemView.findViewById(R.id.ivDemo);
            name=itemView.findViewById(R.id.name);
            tvdes=itemView.findViewById(R.id.tvdes);
            tvdis=itemView.findViewById(R.id.tvdis);
            tvper=itemView.findViewById(R.id.tvper);
        }
    }
}

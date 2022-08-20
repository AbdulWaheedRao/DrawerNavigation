package com.example.navigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PopularAdopter extends RecyclerView.Adapter<PopularAdopter.ViewHolder> {

    private Context context;
    private List<PopularModel> popularModelList;

    public PopularAdopter(Context context, List<PopularModel> popularModelList) {
        this.context = context;
        this.popularModelList = popularModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.papular_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(popularModelList.get(position).getImag_url()).into(holder.ivSale);
        holder.name.setText(popularModelList.get(position).getName());
        holder.rating.setText(popularModelList.get(position).getRating());
        holder.description.setText(popularModelList.get(position).getDescription());
        holder.discount.setText(popularModelList.get(position).getDiscount());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ViewAllActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("type",popularModelList.get(holder.getAdapterPosition()).getType());
               intent.putExtras(bundle);
               context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return popularModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivSale;
        TextView name, description, rating, discount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivSale = itemView.findViewById(R.id.ivSale);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            rating = itemView.findViewById(R.id.rating);
            discount = itemView.findViewById(R.id.discount);
        }
    }
}

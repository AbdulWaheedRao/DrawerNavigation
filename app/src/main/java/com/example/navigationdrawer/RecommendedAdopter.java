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

public class RecommendedAdopter extends RecyclerView.Adapter<RecommendedAdopter.ViewHolder> {
    Context context;
    List<RecommendedModel> recommendedModelList;

    public RecommendedAdopter(Context context, List<RecommendedModel> recommendedModelList) {
        this.context = context;
        this.recommendedModelList = recommendedModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recommended_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(recommendedModelList.get(position).getImag_url()).into(holder.ivSale);
        holder.name.setText(recommendedModelList.get(position).getName());
        holder.description.setText(recommendedModelList.get(position).getDescription());
        holder.rating.setText(recommendedModelList.get(position).getRating());

    }

    @Override
    public int getItemCount() {
        return recommendedModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivSale;
        TextView name, description, rating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivSale = itemView.findViewById(R.id.ivSale);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            rating = itemView.findViewById(R.id.rating);
        }
    }
}

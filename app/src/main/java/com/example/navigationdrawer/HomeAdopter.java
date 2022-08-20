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

public class HomeAdopter extends RecyclerView.Adapter<HomeAdopter.ViewHolder> {
    Context context;
    List<HomeModel> homeModelList;

    public HomeAdopter(Context context, List<HomeModel> homeModelList) {
        this.context = context;
        this.homeModelList = homeModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_cat,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).load(homeModelList.get(position).getImag_url()).into(holder.ivEgg);
        holder.tvEgg.setText(homeModelList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return homeModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivEgg;
        TextView tvEgg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivEgg=itemView.findViewById(R.id.ivEgg);
            tvEgg=itemView.findViewById(R.id.tvEgg);
        }
    }
}

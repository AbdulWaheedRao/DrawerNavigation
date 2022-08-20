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

public class ViewAllAdopter extends RecyclerView.Adapter<ViewAllAdopter.ViewHolder> {
    Context context;
    List<ViewAllModel> viewAllModelList;

    public ViewAllAdopter(Context context, List<ViewAllModel> viewAllModelList) {
        this.context = context;
        this.viewAllModelList = viewAllModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewall_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).load(viewAllModelList.get(position).getImag_url()).into(holder.ivview);
        holder.tvname.setText(viewAllModelList.get(position).getName());
        holder.tvdis.setText(viewAllModelList.get(position).getDescription());
        holder.tvprice.setText(Long.toString(viewAllModelList.get(position).getPrice()));
        holder.tvrating.setText(viewAllModelList.get(position).getRating());


    }

    @Override
    public int getItemCount() {

        return viewAllModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivview;
        TextView tvname,tvdis,tvprice,tvrating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivview=itemView.findViewById(R.id.ivview);

            tvname=itemView.findViewById(R.id.tvname);
            tvdis=itemView.findViewById(R.id.tvdis);
            tvprice=itemView.findViewById(R.id.tvprice);
            tvrating=itemView.findViewById(R.id.tvrating);

        }
    }
}

package com.si6a.kuyrakit;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.ClassViewHolder>{
    private ArrayList<ModelGunpla> dataGunpla;
    private Context ctx;

    public AdapterCard(ArrayList<ModelGunpla> dataGunpla, Context ctx) {
        this.dataGunpla = dataGunpla;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater .from(ctx).inflate(R.layout.item_card, parent, false);
        return new ClassViewHolder(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        ModelGunpla gunpla = dataGunpla.get(position);
        holder.tvGunpla.setText(gunpla.getGunpla());
        holder.tvDeskripsi.setText(gunpla.getDeskripsi());
        Glide
                .with(ctx)
                .load(gunpla.getFoto())
                .centerCrop()
                .into(holder.ivFoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String xGunpla, xDeskripsi, xFoto;

                xGunpla = gunpla.getGunpla();
                xDeskripsi = gunpla.getDeskripsi();
                xFoto = gunpla.getFoto();

                Intent kirim = new Intent(ctx, DetailActivity.class);
                kirim.putExtra("xGunpla", xGunpla);
                kirim.putExtra("xDeskripsi", xDeskripsi);
                kirim.putExtra("xFoto", xFoto);
                ctx.startActivity(kirim);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataGunpla.size();
    }

    public class ClassViewHolder extends RecyclerView.ViewHolder{
        TextView tvGunpla, tvDeskripsi;
        ImageView ivFoto;

        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            tvGunpla = itemView.findViewById(R.id.tv_gunpla);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi);
            ivFoto = itemView.findViewById(R.id.iv_foto);
        }
    }
}

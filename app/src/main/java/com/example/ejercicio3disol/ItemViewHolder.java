package com.example.ejercicio3disol;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder{

    protected ImageView imagen;
    protected androidx.appcompat.widget.Toolbar toolbar;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        imagen = itemView.findViewById(R.id.imageView);
        toolbar = itemView.findViewById(R.id.toolbar);
    }
}

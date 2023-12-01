package com.example.ejercicio3disol;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder>{

    private final Context context;

    private List<SolarImage> solarImages;

    private androidx.appcompat.widget.Toolbar toolbar;

    public ItemAdapter(Context context, List<SolarImage> solarImages) {
        this.context = context;
        this.solarImages = solarImages;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ItemViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        int imageId = solarImages.get(position).getImageResourceId();


        holder.imagen.setImageResource(imageId);

        Resources res = holder.itemView.getContext().getResources();
        String nombre = res.getResourceEntryName(solarImages.get(position).getImageResourceId());
        Toolbar toolbar =  holder.itemView.findViewById(R.id.toolbarCardView);
        toolbar.setTitle(solarImages.get(position).toString());

        toolbar.inflateMenu(R.menu.toolbarcardview);
        toolbar.setTitle(nombre);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {


                int itemId = menuItem.getItemId();
                if (itemId == R.id.copiar){
                    SolarImage copiedImage = solarImages.get(position);
                    solarImages.add(position, copiedImage); // Copiar el ítem
                    notifyItemInserted(position);
                    return true;
                }else if (itemId == R.id.borrar){
                    // Acción para eliminar el ítem
                    solarImages.remove(position);
                    notifyItemRemoved(position);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return solarImages != null ? solarImages.size() : 0;
    }
}

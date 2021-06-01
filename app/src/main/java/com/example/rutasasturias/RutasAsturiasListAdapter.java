package com.example.rutasasturias;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RutasAsturiasListAdapter extends RecyclerView.Adapter <RutasAsturiasHolder>
{
    private ArrayList<RutasAsturias> rutasAsturias = new ArrayList<>();


    public RutasAsturiasListAdapter(ArrayList<RutasAsturias> value)
    {
        rutasAsturias = new ArrayList<>();
        rutasAsturias=value;
    }

    @NonNull
    @Override
    public RutasAsturiasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new RutasAsturiasHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RutasAsturiasHolder holder, int position)
    {
        holder.card.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString(DetailFragment.N_RUTA, rutasAsturias.get(position).getNombre());
            Navigation.findNavController(v).navigate(R.id.action_lista3_to_detailFragment,bundle);

        });
        if(rutasAsturias == null) holder.bind(null);
        else holder.bind(rutasAsturias.get(position));
    }

    @Override
    public int getItemCount() {
        if(rutasAsturias != null)
        {
            return rutasAsturias.size();
        }
        return 1;
    }

    public void setRutasAsturias(ArrayList<RutasAsturias> rutasAsturias) {
        this.rutasAsturias = rutasAsturias;
    }
}
package com.example.rutasasturias;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RutasAsturiasHolder extends RecyclerView.ViewHolder implements View.OnClickListener, AdapterView.OnItemSelectedListener
{
    private TextView name;
    private TextView concejo;
    public CardView card;


    public RutasAsturiasHolder(@NonNull View view)
    {
        super(view);
        Log.d("Holder", "se creo");
        name = (TextView) itemView.findViewById(R.id.nombre);
        concejo = (TextView) itemView.findViewById(R.id.Concejo);
        card = (CardView) itemView.findViewById(R.id.cv);
    }

    public void bind(RutasAsturias ruta)
    {
        if(ruta !=null)
        {
            name.setText(ruta.getNombre());
            concejo.setText(ruta.getConcejos());
        }
    }

    @Override
    public void onClick(View v)
    {
        Log.d("Holder", "on click dentro");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        Log.d("Holder", "Item selected dentro");
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}

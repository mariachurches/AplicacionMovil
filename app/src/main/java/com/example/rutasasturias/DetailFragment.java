package com.example.rutasasturias;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    public static final String N_RUTA = "n_ruta";
    private static int seleccionada;
    private RecyclerView recyclerView;
    private RutasAsturiasListAdapter adaptee;
    private RutasAsturiasViewModel viewModel;
    private View view;
    private ImageView imageView;
    private TextView titulo;
    private TextView concejo;
    private TextView descripcion;
    private TextView zona;
    private TextView distancia;
    private TextView dificultad;
    private TextView codigo;
    private TextView tiemporecorrido;
    private TextView contactoTexto;
    private TextView tap;
    private TextView resumen;
    private TextView itinerario;
    private TextView tiporuta;
    private TextView distanciatramo;
    private TextView origenDestino;
    private RutasAsturias Mi_ruta;
    private String url;
    private int n_foto=0;
    private int n_foto_max=0;
    private String [] imagenes;





    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt(N_RUTA, seleccionada);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            seleccionada = getArguments().getInt(N_RUTA);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail, container, false);

        viewModel = new ViewModelProvider(this).get(RutasAsturiasViewModel.class);
        getItems();

        final Observer<ArrayList<RutasAsturias>> observer = new Observer<ArrayList<RutasAsturias>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<RutasAsturias> ruta)
            {
                Mi_ruta = viewModel.getRuta(seleccionada);
                putText();
                n_foto_max=Mi_ruta.getSlide().split(",").length;
                Log.d("URL","Foto maxima " + n_foto_max);
                imagenes =Mi_ruta.getSlide().split(",");
                url = "https://www.turismoasturias.es" + imagenes[0];
                Log.d("URL", url);
                new LoadImage(imageView).execute(url);
                adaptee = new RutasAsturiasListAdapter(viewModel.getRutas().getValue());
                viewModel.updateRutasAsturias();

            }
        };

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n_foto++;
                n_foto = (n_foto >= n_foto_max)?0:n_foto;
                Log.d("URL", "n_fotoooo" + n_foto);
                url = "https://www.turismoasturias.es" + imagenes[n_foto];
                Log.d("URL", url);
                new LoadImage(imageView).execute(url);
            }
        });
        viewModel.getRutas().observe(getViewLifecycleOwner(), observer);
        return view;
    }

    private void getItems()
    {
        zona = view.findViewById(R.id.zona);
        titulo = view.findViewById(R.id.titulo);
        concejo = view.findViewById(R.id.concejo);
        imageView = view.findViewById(R.id.imagen);
        distancia = view.findViewById(R.id.distancia);
        dificultad = view.findViewById(R.id.dificultad);
        tap = view.findViewById(R.id.tap);
        contactoTexto = view.findViewById(R.id.ContactoTexto);
        codigo = view.findViewById(R.id.codigo);
        tiemporecorrido = view.findViewById(R.id.TipoDeRecorrido);
        descripcion = view.findViewById(R.id.descripcion);
        resumen = view.findViewById(R.id.resumen);
        itinerario = view.findViewById(R.id.itinerario);
        tiporuta = view.findViewById(R.id.tiporuta);
        origenDestino = view.findViewById(R.id.OrigenDestino);
        distanciatramo = view.findViewById(R.id.DistanciaTramo);

    }
    private void putText()
    {
        titulo.setText(Mi_ruta.getNombre());
        concejo.setText(Mi_ruta.getConcejos());
        zona.setText(Mi_ruta.getZona());
        distancia.setText(Mi_ruta.getDistancia());
        dificultad.setText(Mi_ruta.getDificultad().toString());
        tap.setText(Mi_ruta.getTiempoAPie());
        contactoTexto.setText(Mi_ruta.getContactoTexto());
        codigo.setText(Mi_ruta.getCodigo());
        tiemporecorrido.setText(Mi_ruta.getTipoDeRecorrido());
        descripcion.setText(Mi_ruta.getDescripcionTramo());
        resumen.setText(Mi_ruta.getResumen());
        itinerario.setText(Mi_ruta.getItinerario());
        tiporuta.setText(Mi_ruta.getTipoRuta());
        origenDestino.setText(Mi_ruta.getOrigenDestino());
        distanciatramo.setText(Mi_ruta.getDistanciaTramo());
    }
}
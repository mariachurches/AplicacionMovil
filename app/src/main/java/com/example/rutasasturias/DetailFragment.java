package com.example.rutasasturias;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.text.BoringLayout;
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
    private static String seleccionada;
    private RecyclerView recyclerView;
    private RutasAsturiasListAdapter adaptee;
    private RutasAsturiasViewModel viewModel;
    private View view;
    private ImageView imageView;
    private ImageView fav;
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
    private boolean is_fav;
    private ArrayList<RutasAsturias> rutas;
    private Repository repository;
    private Ruta r;
    private boolean iniciada;

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
        args.putString(N_RUTA, seleccionada);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            seleccionada = getArguments().getString(N_RUTA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail, container, false);
        repository = new Repository(getActivity().getApplicationContext());

        viewModel = new ViewModelProvider(this).get(RutasAsturiasViewModel.class);
        getItems();
        is_fav = false; //Mirar si esta en la lista de favoritos

        final Observer<ArrayList<RutasAsturias>> observer = new Observer<ArrayList<RutasAsturias>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<RutasAsturias> ruta)
            {
                rutas = viewModel.getRutas().getValue();
                Mi_ruta = getRuta(seleccionada);
                putText();
                n_foto_max=Mi_ruta.getSlide().split(",").length;

                imagenes =Mi_ruta.getSlide().split(",");
                url = "https://www.turismoasturias.es" + imagenes[0];
                new LoadImage(imageView).execute(url);
                adaptee = new RutasAsturiasListAdapter(viewModel.getRutas().getValue());
                //viewModel.updateRutasAsturias();
            }
        };

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n_foto++;
                n_foto = (n_foto >= n_foto_max)?0:n_foto;
                url = "https://www.turismoasturias.es" + imagenes[n_foto];
                new LoadImage(imageView).execute(url);
            }
        });

        viewModel.getRutas().observe(getViewLifecycleOwner(), observer);

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                is_fav = !is_fav;
                putImageFav();
                rellenarRuta();
                if(is_fav) repository.meterRutaEnFavoritos(r);
                else repository.borrarRutadeFavoritos(r);
            }
        });
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
        fav = view.findViewById(R.id.imagenFav);

    }

    private void putImageFav()
    {
        if(is_fav) fav.setImageResource(R.drawable.button_icon);
        else fav.setImageResource(R.drawable.estrella1);
    }
    private void putText()
    {
        putImageFav();
        titulo.setText(" "+Mi_ruta.getNombre());
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

    private RutasAsturias getRuta(String nombre)
    {
        for(int i=0; i< rutas.size(); i++)
        {
            if(rutas.get(i).getNombre().equals(nombre)) return rutas.get(i);
        }
        return rutas.get(0);
    }

    private void rellenarRuta()
    {
        r = new Ruta();
        r.setAltitud(Mi_ruta.getAltitud());
        r.setCodigo(Mi_ruta.getCodigo());
        r.setConcejos(Mi_ruta.getConcejos());
        r.setContacto(Mi_ruta.getContacto());
        r.setContactoTexto(Mi_ruta.getContactoTexto());
        r.setDescripcionTramo(Mi_ruta.getDescripcionTramo());
        r.setDesnivel(Mi_ruta.getDesnivel());
        r.setDetalleImagen(Mi_ruta.getDetalleImagen());
        r.setResumen(Mi_ruta.getResumen());
        r.setNombre(Mi_ruta.getNombre());
        r.setDificultad(Mi_ruta.getDificultad());
        r.setCoordenadas(Mi_ruta.getCoordenadas());
        r.setDetalle(Mi_ruta.getDetalle());
        r.setDescripcionTramo(Mi_ruta.getDescripcionTramo());
        r.setDistanciaTramo(Mi_ruta.getDistanciaTramo());
        r.setFolleto(Mi_ruta.getFolletos());
        r.setFolletos(Mi_ruta.getFolletos());
        r.setGeolocalizacion(Mi_ruta.getGeolocalizacion());
        r.setInformacion(Mi_ruta.getInformacion());
        r.setItinerario(Mi_ruta.getItinerario());
        r.setTramos(Mi_ruta.getTramos());
        r.setInformacionTexto(Mi_ruta.getInformacionTexto());
        r.setObservaciones(Mi_ruta.getObservaciones());
        r.setOrigenDestino(Mi_ruta.getOrigenDestino());
        r.setPuntoDePartida(Mi_ruta.getPuntoDePartida());
        r.setTrazadoRuta(Mi_ruta.getTrazadoRuta());
        r.setTiempoAscension(Mi_ruta.getTiempoAscension());
        r.setTiempoBTT(Mi_ruta.getTiempoBTT());
        r.setTiempoCoche(Mi_ruta.getTiempoCoche());
        r.setPuntoDePartida(Mi_ruta.getPuntoDePartida());
        r.setTiempoViasVerdes(Mi_ruta.getTiempoViasVerdes());


    }
}
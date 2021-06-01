package com.example.rutasasturias;

import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapaFragment  extends Fragment {


    private RutasAsturiasViewModel viewModel;
    MapView mMapView;
    private GoogleMap googleMap;
    private boolean marcados;

    public MapaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MapaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MapaFragment newInstance(String param1, String param2) {
        MapaFragment fragment = new MapaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        marcados=false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mapa, container, false);
        viewModel = new ViewModelProvider(this).get(RutasAsturiasViewModel.class);

        mMapView = (MapView) view.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        final Observer<ArrayList<RutasAsturias>> observer = new Observer<ArrayList<RutasAsturias>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<RutasAsturias> ruta) {
                if (googleMap != null) {
                    for (RutasAsturias rutaItem : viewModel.getRutas().getValue()) {
                        String coor[] = rutaItem.getCoordenadas().split(",");
                        if (coor.length == 2) {
                            if (coor[0] != "" && coor[1] != "") {
                                try {
                                    LatLng rut = new LatLng(Double.parseDouble(coor[0]), Double.parseDouble(coor[1]));
                                    googleMap.addMarker(new MarkerOptions().position(rut).title(rutaItem.getNombre()).snippet(rutaItem.getConcejos()));
                                } catch (NumberFormatException e) {
                                    Log.d("MAPAFRAGMENT", "JSON con algunos campos mal");
                                }
                            }
                        }
                    }

                    LatLng coorAsturias = new LatLng(43.215983, (-05.834003));


                    // For zooming automatically to the location of the marker
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(coorAsturias).zoom(7).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
            }
        };
        viewModel.getRutas().observe(getViewLifecycleOwner(), observer);

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;
                if(!marcados)
                {
                    viewModel.updateRutasAsturias(false);
                }
            }
        });
        return view;
    }


}
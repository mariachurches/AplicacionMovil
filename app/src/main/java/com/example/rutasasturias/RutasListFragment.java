package com.example.rutasasturias;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Observable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RutasListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RutasListFragment extends Fragment {

    private View view;
    private boolean fav;
    private Button buttonFind;
    private Button buttonfilter;
    private Button buttonfavs;
    private RecyclerView recyclerView;
    private RutasAsturiasListAdapter adaptee;
    private LinearLayoutManager layoutManager;
    private RutasAsturiasViewModel viewModel;
    private Boolean control;

    public RutasListFragment() {
        // Required empty public constructor
        control =true;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment RutasListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RutasListFragment newInstance(String param1, String param2) {
        RutasListFragment fragment = new RutasListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fav=false;
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_lista, container, false);

        buttonFind = (Button) view.findViewById(R.id.JBBuscar);
        buttonFind.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_lista3_to_findFragment));

        buttonfilter = (Button) view.findViewById(R.id.JBFiltrar);
        buttonfilter.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_lista3_to_filterFragment));

        viewModel = new ViewModelProvider(this).get(RutasAsturiasViewModel.class);
        recyclerView = view.findViewById(R.id.recyclerview);

        adaptee = new RutasAsturiasListAdapter(viewModel.getRutas().getValue());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adaptee);

        buttonfavs = (Button) view.findViewById(R.id.JBFav);
        buttonfavs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                viewModel.ponerFavoritos();
            }
        });


        final Observer<ArrayList<RutasAsturias>> observer = new Observer<ArrayList<RutasAsturias>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<RutasAsturias> ruta)
            {
                if(getArguments() != null) {
                    if (getArguments().getBoolean("modificado") && getArguments().getString("clase") == "find" && control) {
                        adaptee.setRutasAsturias(viewModel.find(getArguments().getString("nombre"), getArguments().getString("tipo"), getArguments().getString("dificultad")).getValue());
                        control =false;
                        setArguments(null);
                    }else if(getArguments().getBoolean("modificado") && getArguments().getString("clase") == "filter")
                    {
                        adaptee.setRutasAsturias(viewModel.filter(getArguments().getString("nombre"), getArguments().getString("tipo"), getArguments().getString("dificultad")).getValue());
                        control =false;
                        setArguments(null);
                    }

                    else {
                        if(control) adaptee = new RutasAsturiasListAdapter(viewModel.getRutas().getValue());}
                }
                else{
                    if(control) adaptee = new RutasAsturiasListAdapter(viewModel.getRutas().getValue());
                }
                if(control){
                recyclerView.setAdapter(adaptee);
                viewModel.updateRutasAsturias(true);}

                recyclerView.setAdapter(adaptee);
            }
        };
        viewModel.getRutas().observe(getViewLifecycleOwner(), observer);

        return view;
    }

    //button1.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_hostFragment_to_lista32));

}
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
public class RutasListFragment extends Fragment implements Spinner.OnItemSelectedListener{

    private RecyclerView recyclerView;
    private RutasAsturiasListAdapter adaptee;
    private LinearLayoutManager layoutManager;
    private RutasAsturiasViewModel viewModel;
    private View view;
    private Spinner spinner;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RutasListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RutasListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RutasListFragment newInstance(String param1, String param2) {
        RutasListFragment fragment = new RutasListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_lista, container, false);

        spinner = (Spinner) view.findViewById(R.id.spinner2);
        Log.d("FRAGMENT ","nombre " + getResources().getStringArray(R.array.filtros)[0]);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.filtros));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        viewModel = new ViewModelProvider(this).get(RutasAsturiasViewModel.class);
        recyclerView = view.findViewById(R.id.recyclerview);

        final Observer<ArrayList<RutasAsturias>> observer = new Observer<ArrayList<RutasAsturias>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<RutasAsturias> ruta)
            {
                Log.d("DATACHANGE", "que tal estamos");
                adaptee = new RutasAsturiasListAdapter(viewModel.getRutas().getValue());
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adaptee);
                viewModel.updateRutasAsturias();
            }
        };
        viewModel.getRutas().observe(getViewLifecycleOwner(), observer);
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        TextView textView = view.findViewById(R.id.textView3);
        Toast.makeText(getActivity(), textView.getText().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }

    //button1.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_hostFragment_to_lista32));

}
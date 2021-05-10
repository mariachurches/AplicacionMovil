package com.example.rutasasturias;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link hostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class hostFragment extends Fragment {


    public hostFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment hostFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static hostFragment newInstance(String param1, String param2) {
        hostFragment fragment = new hostFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_host, container, false);
        Button button1, button2;
        button1 = (Button) v.findViewById(R.id.lista);
        button2 = (Button) v.findViewById(R.id.mapa);
        button1.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_hostFragment_to_lista32));
        button2.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_hostFragment_to_mapaFragment));

        return v;

    }

}
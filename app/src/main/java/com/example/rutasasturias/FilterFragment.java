package com.example.rutasasturias;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FilterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilterFragment extends Fragment {

    private View view;
    private Bundle args;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private TextView nombre;
    private RadioButton ida;
    private Button buttonfind;
    private RadioButton idayV;
    private Button buttonCancel;
    private Button buttonVolver;
    private static FilterFragment fragment;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FilterFragment() {
        // Required empty public constructor
    }


    public static FilterFragment newInstance(String param1, String param2)
    {
        fragment = new FilterFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        args = new Bundle();
        if(fragment == null) fragment = new FilterFragment();

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_find, container, false);

        buttonfind = (Button) view.findViewById(R.id.JBGuardar);
        nombre = (TextView) view.findViewById(R.id.JTName);
        ida = (RadioButton) view.findViewById(R.id.JRB1);
        idayV = (RadioButton) view.findViewById(R.id.JRB2);
        cb1 = (CheckBox) view.findViewById(R.id.JCB1);
        cb2 = (CheckBox) view.findViewById(R.id.checkBox2);
        cb3 = (CheckBox) view.findViewById(R.id.checkBox3);


        buttonfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getActivity().getApplicationContext() , "Se han guardado los datos", Toast.LENGTH_SHORT);
                if(fragment == null) fragment = new FilterFragment();
                args.putBoolean("modificado",true);
                args.putString("clase","find");
                args.putString("nombre",nombre.getText().toString());
                args.putString("dificultad",getSelectedItemCB());
                args.putString("tipo",getSelectedItemRB());
                fragment.setArguments(args);
                buttonVolver.setEnabled(true);
            }
        });

        buttonCancel = (Button) view.findViewById(R.id.JBCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                args.putBoolean("modificado",false);
            }
        });

        buttonVolver = (Button) view.findViewById(R.id.JBVolver);
        buttonVolver.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_filterFragment_to_lista3, args));
        buttonVolver.setEnabled(false);

        // Inflate the layout for this fragment
        return view;
    }

    private String getSelectedItemRB()
    {
        if(ida.isSelected()) return "ida";
        if(idayV.isSelected()) return "vuelta";
        return "";
    }

    private String getSelectedItemCB()
    {
        String result = "";
        if(cb1.isChecked()) result = result + "1";
        if(cb2.isChecked()) result = result + "2";
        if(cb3.isChecked()) result = result + "3";
        return result;
    }
}
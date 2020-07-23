package com.example.knowyourfacts;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Frag3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Frag3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag3.
     */
    // TODO: Rename and change types and number of parameters
    public static Frag3 newInstance(String param1, String param2) {
        Frag3 fragment = new Frag3();
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

    Button btnChangeColor;
    LinearLayout ll;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_frag3, container, false);
        btnChangeColor = view.findViewById(R.id.changeColor3);
        ll = view.findViewById(R.id.layout3);


        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random randomno = new Random();
                int color = Color.argb(randomno.nextInt(256),randomno.nextInt(256),randomno.nextInt(256),randomno.nextInt(256));
                ll.setBackgroundColor(color);
            }
        });

        return  view;
    }
}
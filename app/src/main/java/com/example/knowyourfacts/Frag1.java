package com.example.knowyourfacts;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Frag1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Frag1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag1.
     */
    // TODO: Rename and change types and number of parameters
    public static Frag1 newInstance(String param1, String param2) {
        Frag1 fragment = new Frag1();
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

    Button btnChangeImage;
    LinearLayout ll;
    ImageView iv;
    ArrayList<String> al;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_frag1, container, false);
        btnChangeImage = view.findViewById(R.id.changeImage);
        ll = view.findViewById(R.id.layout1);
        iv = view.findViewById(R.id.imageView);

        al = new ArrayList<String>();
        al.add("https://www.wtffunfact.com/wp-content/uploads/2020/07/WTF-Fun-Fact-Weird-Al-Beer-Money.png");
        al.add("https://www.wtffunfact.com/wp-content/uploads/2020/07/WTF-Fun-Fact-Dead-Snail-In-A-Beer.png");
        al.add("https://www.wtffunfact.com/wp-content/uploads/2020/07/WTF-Fun-Fact-Fake-Baby-Elephants-1.png");
        al.add("https://www.wtffunfact.com/wp-content/uploads/2020/07/WTF-Fun-Fact-Cougars-Planting-Seeds-1.png");
        al.add("https://www.wtffunfact.com/wp-content/uploads/2020/07/WTF-Fun-Fact-Dragonfly-Wing-Destroyers.png");

        Picasso.with(getContext()).load(al.get(0)).into(iv);

        btnChangeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random randomno = new Random();
                int num = randomno.nextInt(al.size());
                Picasso.with(getContext()).load(al.get(num)).into(iv);
            }
        });

        return  view;
    }
}
package com.example.absenmanual;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MasukFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MasukFragment extends Fragment {
    Button Masuk;

    public MasukFragment() {
        // Required empty public constructor
    }


    public static MasukFragment newInstance(String param1, String param2) {
        MasukFragment fragment = new MasukFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_masuk, container, false);
        Masuk = (Button) view.findViewById(R.id.masuk_btn);
        Masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),MainActivity.class);
                startActivity(intent);

            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}
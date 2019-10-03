package com.nathan.purpletealfragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TealFragment extends Fragment {

    private final static String ARG_RANDOM = "number argument";
    private int mRandomNumber;

    private TextView mRandomTextView;

    public TealFragment() {
        // Required empty public constructor
    }

    public static TealFragment newInstance(int random) {
        TealFragment fragment = new TealFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_RANDOM, random);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        if(getArguments() != null) {
            mRandomNumber = getArguments().getInt(ARG_RANDOM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_teal, container, false);
        mRandomTextView = view.findViewById(R.id.randomNumberTextView);
        setRandomNumber(mRandomNumber);
        // Inflate the layout for this fragment
        return view;
    }

    public void setRandomNumber(int number) {
        mRandomNumber = number;
        mRandomTextView.setText("Random: " + mRandomNumber);
    }

}

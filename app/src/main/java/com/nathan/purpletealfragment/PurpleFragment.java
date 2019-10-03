package com.nathan.purpletealfragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class PurpleFragment extends Fragment {

    public interface OnRandomNumberGeneratedListener {
        void onRandomNumber(int number);

    }

    OnRandomNumberGeneratedListener listener;
    Random random;


    public PurpleFragment() {
        // Required empty public constructor
        random = new Random();
    }

    public static PurpleFragment newInstance(){
        return new PurpleFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_purple, container, false);

        Button randomButton = view.findViewById(R.id.randomButton);
        randomButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int number = random.nextInt(100);
                listener.onRandomNumber(number);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    public void setOnRandomNumberGeneratedListener(OnRandomNumberGeneratedListener listener) {
        this.listener = listener;
    }

}

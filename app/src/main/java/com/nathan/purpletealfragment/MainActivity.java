package com.nathan.purpletealfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements PurpleFragment.OnRandomNumberGeneratedListener {

//    private PurpleFragment purpleFragment;
//    private TealFragment tealFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the purple frag
        PurpleFragment purpleFragment = PurpleFragment.newInstance();
        purpleFragment.setOnRandomNumberGeneratedListener(this);

        TealFragment tealFragment = TealFragment.newInstance(0);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.purpleFragment, purpleFragment);
        ft.add(R.id.tealFragment, tealFragment);
        ft.commit();



//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.add(R.id.fragmentContainer, purpleFragment);
//        ft.commit();


//        purpleFragment = new PurpleFragment();
//        tealFragment = new TealFragment();
//        View mainView = findViewById(android.R.id.content);
//        mainView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                swapFragments();
//            }
//        });
    }

    @Override
    public void onRandomNumber (int number) {
        //Create and show teal fragment providing the number in a bundle
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        TealFragment tealFragment = TealFragment.newInstance(number);
        ft.replace(R.id.tealFragment, tealFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

/*    private void swapFragments() {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (fm.findFragmentById(R.id.fragmentContainer) == purpleFragment) {

            ft.replace(R.id.fragmentContainer, tealFragment);

        } else {
            ft.replace(R.id.fragmentContainer, purpleFragment);
        }

        ft.commit();
    }*/
}

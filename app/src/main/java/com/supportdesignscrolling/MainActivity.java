package com.supportdesignscrolling;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.supportdesignscrolling.fragments.MainFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.MainInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openFragment(new MainFragment());
    }

    @Override
    public void openFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,fragment)
                .addToBackStack(null)
                .commit();
    }
}

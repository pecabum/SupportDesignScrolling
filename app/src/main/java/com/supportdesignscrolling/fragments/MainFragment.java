package com.supportdesignscrolling.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.supportdesignscrolling.R;
import com.supportdesignscrolling.databinding.FragmentMainBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    private FragmentMainBinding binding;

    private MainInteractionListener listener;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnOne.setOnClickListener(this);
        binding.btnTwo.setOnClickListener(this);
        binding.btnThree.setOnClickListener(this);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainInteractionListener) {
            listener = (MainInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                listener.openFragment(new AppScrolingToolbarFragment());
                break;
            case R.id.btn_two:
                listener.openFragment(new ScrollingToolbarWithTabsFragment());
                break;
            case R.id.btn_three:
                listener.openFragment(new ScrollingToolbarImageFragment());
                break;
        }
    }

    public interface MainInteractionListener {
        void openFragment(Fragment fragment);
    }
}

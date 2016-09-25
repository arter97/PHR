package com.example.pesc.phrapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RootFragment extends Fragment {

    private static final String TAG = "RootFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_root, container, false);


        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.root, new Fragment1());
        transaction.commit();

        return view;

    }
}

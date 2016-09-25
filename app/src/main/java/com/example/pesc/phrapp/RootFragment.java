package com.example.pesc.phrapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by PES on 2016-09-14.
 */

public class RootFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_root, container, false);


        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.root, new Fragment1());
        transaction.commit();

        return view;

    }
}

package com.example.pesc.phrapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class EditedFragment extends Fragment {

    TextView edit_height, edit_weight, edit_abo, edit_medicine, edit_allergy, edit_history, edit_sleepTime, edit_dailyStride;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_page_edit1, container, false);

        Button editButton = (Button)view.findViewById(R.id.edit_button);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.root, new Fragment1());
                fragmentTransaction.commit();
            }
        });


        edit_height = (TextView)view.findViewById(R.id.edit_height);
        edit_height.setText(Fragment1.getHeight());

        edit_weight = (TextView)view.findViewById(R.id.edit_weight);
        edit_weight.setText(Fragment1.getWeight());

        edit_abo = (TextView)view.findViewById(R.id.edit_abo);
        edit_abo.setText(Fragment1.getABO());

        edit_medicine = (TextView)view.findViewById(R.id.edit_medicine);
        edit_medicine.setText(Fragment1.getMedicine());

        edit_allergy = (TextView)view.findViewById(R.id.edit_allergy);
        edit_allergy.setText(Fragment1.getAllergy());

        edit_history = (TextView)view.findViewById(R.id.edit_history);
        edit_history.setText(Fragment1.getHistory());

        edit_sleepTime = (TextView)view.findViewById(R.id.edit_sleepTime);
        edit_sleepTime.setText(Fragment1.getSleepTime());

        edit_dailyStride = (TextView)view.findViewById(R.id.edit_dailyStride);
        edit_dailyStride.setText(Fragment1.getDailyStride());

        return view;
    }
}

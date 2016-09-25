package com.example.pesc.phrapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;


public class EditedFragment extends Fragment {

    TextView tab1_name;
    TextView tab1_age;
    TextView tab1_sex;

    TextView edit_height, edit_weight, edit_abo, edit_medicine, edit_allergy, edit_history, edit_sleepTime, edit_dailyStride;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        int year = Calendar.getInstance().get(Calendar.YEAR);
        int cmonth = Calendar.getInstance().get(Calendar.MONTH);
        int myMonth = Person.birth.getMonth();
        int age = year - Person.birth.getYear();

        View view = inflater.inflate(R.layout.fragment_page_edit1, container, false);

        Button editButton = (Button) view.findViewById(R.id.edit_button);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.root, new Fragment1());
                fragmentTransaction.commit();
            }
        });

        tab1_name = (TextView) view.findViewById(R.id.tab1_name);
        tab1_age = (TextView) view.findViewById(R.id.tab1_age);
        tab1_sex = (TextView) view.findViewById(R.id.tab1_sex);

        String user_name = Person.name;
        tab1_name.setText(user_name);

        if (((cmonth + 1) - myMonth) >= 0) {
            tab1_age.setText("만 " + age + "세" + ". " + (cmonth - myMonth + 1) + "개월");
            System.out.println("=============================================" + cmonth);

        } else {
            tab1_age.setText("만 " + (age - 1) + "세" + ". " + (cmonth - myMonth + 13) + "개월");
            System.out.println("=============================================" + cmonth);

        }

        String user_sex;
        if (Person.sex == 1)
            user_sex = "남";
        else
            user_sex = "여";
        tab1_sex.setText(user_sex);

        edit_height = (TextView) view.findViewById(R.id.edit_height);
        edit_height.setTextColor(Color.RED);
        edit_height.setText("키: " + Fragment1.getHeight() + "cm");

        edit_weight = (TextView) view.findViewById(R.id.edit_weight);
        edit_weight.setText("몸무게: " + Fragment1.getWeight() + "kg");

        edit_abo = (TextView) view.findViewById(R.id.edit_abo);
        edit_abo.setText("심박수/혈압/혈액형: " + Fragment1.getABO());

        edit_medicine = (TextView) view.findViewById(R.id.edit_medicine);
        edit_medicine.setText("복약목록: " + Fragment1.getMedicine());

        edit_allergy = (TextView) view.findViewById(R.id.edit_allergy);
        edit_allergy.setText("알러지/금기목록: " + Fragment1.getAllergy());

        edit_history = (TextView) view.findViewById(R.id.edit_history);
        edit_history.setText("과거력: " + Fragment1.getHistory());

        edit_sleepTime = (TextView) view.findViewById(R.id.edit_sleepTime);
        edit_sleepTime.setText("수면시간: " + Fragment1.getSleepTime() + "시간");

        edit_dailyStride = (TextView) view.findViewById(R.id.edit_dailyStride);
        edit_dailyStride.setText("일일 걸음수: " + Fragment1.getDailyStride() + "걸음");

        return view;
    }
}

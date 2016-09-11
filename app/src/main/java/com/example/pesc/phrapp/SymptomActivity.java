package com.example.pesc.phrapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class SymptomActivity extends AppCompatActivity {
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom);

        int image[] = {
                R.drawable.head, R.drawable.face, R.drawable.neck, R.drawable.breast, R.drawable.belly, R.drawable.back, R.drawable.leg, R.drawable.arm, R.drawable.ankle, R.drawable.digestive, R.drawable.respiratory, R.drawable.hand, R.drawable.heart, R.drawable.hip, R.drawable.jaw, R.drawable.teeth, R.drawable.man, R.drawable.woman, R.drawable.neck2, R.drawable.nouse, R.drawable.sole, R.drawable.finger, R.drawable.tongue, R.drawable.spine,
                R.drawable.ear, R.drawable.elbow};

        GridAdapter gridAdapter = new GridAdapter(getApplicationContext(), R.layout.row, image);

        gridView = (GridView)findViewById(R.id.gridView);
        gridView.invalidateViews();
        gridView.setAdapter(gridAdapter);

    }
}

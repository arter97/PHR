package com.example.pesc.phrapp;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SeekBar;
import android.widget.TextView;

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

        gridView = (GridView) findViewById(R.id.gridView);
        gridView.invalidateViews();
        gridView.setAdapter(gridAdapter);

        final Dialog levelDialog = new Dialog(this);
        levelDialog.setTitle("Select level:");
        levelDialog.setContentView(R.layout.dialog_evaluation);

        final Dialog moreDialog = new Dialog(this);
        moreDialog.setContentView(R.layout.dialog_more);

        final TextView levelTxt = (TextView) levelDialog.findViewById(R.id.level_txt);
        final SeekBar levelSeek = (SeekBar) levelDialog.findViewById(R.id.level_seek);

        //final TextView moreTxt = (TextView) levelDialog.findViewById(R.id.more_txt);
        //final SeekBar moreSeek = (SeekBar) levelDialog.findViewById(R.id.more_seek);

        levelSeek.setMax(10);
        levelSeek.setProgress(10);

        //moreSeek.setMax(10);
        //moreSeek.setProgress(10);

        levelSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //change to progress
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                levelTxt.setText(Integer.toString(progress));
            }

            //methods to implement but not necessary to amend
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        /*****
        moreSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //change to progress
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                moreTxt.setText(Integer.toString(progress));
            }

            //methods to implement but not necessary to amend
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        *****/

        Button okBtn = (Button) levelDialog.findViewById(R.id.level_cancle);
        Button level_more = (Button) levelDialog.findViewById(R.id.level_more);

        Button goDialogBtn;

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //respond to level
                int chosenLevel = levelSeek.getProgress();
                levelDialog.dismiss();
            }
        });

        level_more.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                moreDialog.show();
            }
        });

        levelDialog.show();
    }
}

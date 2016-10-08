package com.example.pesc.phrapp;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class Fragment2 extends Fragment implements View.OnClickListener{
    GridView gridView;
    Button symptom_main_btn1;
    Button symptom_main_btn2;
    Button symptom_main_btn3;
    Button more_confirm;
    private String tmp_st_place;
    private String tmp_st_main;
    private int tmp_st_scale;
    private String tmp_st_sub="";
    private Dialog levelDialog;
    private Dialog moreDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

         /* Dialog 부분 */
        levelDialog = new Dialog(getContext());
        levelDialog.setTitle("Select level:");
        levelDialog.setContentView(R.layout.dialog_evaluation);

        moreDialog = new Dialog(getContext());
        moreDialog.setContentView(R.layout.dialog_more);

        int image[] = {
                R.drawable.head, R.drawable.face, R.drawable.neck, R.drawable.breast, R.drawable.belly, R.drawable.back, R.drawable.leg, R.drawable.arm, R.drawable.ankle, R.drawable.digestive, R.drawable.respiratory, R.drawable.hand, R.drawable.heart, R.drawable.hip, R.drawable.jaw, R.drawable.teeth, R.drawable.man, R.drawable.woman, R.drawable.neck2, R.drawable.nouse, R.drawable.sole, R.drawable.finger, R.drawable.tongue, R.drawable.spine,
                R.drawable.ear, R.drawable.elbow};

        View view = inflater.inflate(R.layout.fragment_page2, container, false);

        GridAdapter gridAdapter = new GridAdapter(getActivity(), R.layout.row, image);

        gridView = (GridView) view.findViewById(R.id.gridView);
        gridView.invalidateViews();
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if(position==0) tmp_st_place="머리";
                else if(position==1) tmp_st_place="얼굴";
                else if(position==2) tmp_st_place="목";

                Toast.makeText(getActivity(), "position:" + position +" , krplacename: "+tmp_st_place, Toast.LENGTH_SHORT).show();
                levelDialog.show();

            }
        });


        symptom_main_btn1=(Button)levelDialog.findViewById(R.id.symptom_main_btn1);
        symptom_main_btn2=(Button)levelDialog.findViewById(R.id.symptom_main_btn2);
        symptom_main_btn3=(Button)levelDialog.findViewById(R.id.symptom_main_btn3);

        more_confirm=(Button)moreDialog.findViewById(R.id.more_confirm);

        symptom_main_btn1.setOnClickListener(this);
        symptom_main_btn2.setOnClickListener(this);
        symptom_main_btn3.setOnClickListener(this);

        more_confirm.setOnClickListener(this);

        /* SeekBar 부분, 통증 선택하기 */
/*
        final TextView levelTxt = (TextView) levelDialog.findViewById(R.id.level_txt);
        final SeekBar levelSeek = (SeekBar) levelDialog.findViewById(R.id.level_seek);

        levelSeek.setMax(10);
        levelSeek.setProgress(10);

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
*/
        final TextView moreTxt = (TextView) moreDialog.findViewById(R.id.more_txt);
        final SeekBar moreSeek = (SeekBar) moreDialog.findViewById(R.id.more_seek);

        moreSeek.setMax(10);
        moreSeek.setProgress(10);

        moreSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //change to progress
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                moreTxt.setText(Integer.toString(progress));
                tmp_st_scale=progress;
            }

            //methods to implement but not necessary to amend
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        Button okBtn = (Button) levelDialog.findViewById(R.id.level_cancel);

 //       Button level_more = (Button) levelDialog.findViewById(R.id.level_more);

        Button goDialogBtn;

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //respond to level

                //int chosenLevel = levelSeek.getProgress();
                levelDialog.dismiss();
            }
        });
/*
        level_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moreDialog.show();
            }
        });
*/

        return view;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.symptom_main_btn1:
                tmp_st_main=symptom_main_btn1.getText().toString();
                moreDialog.show();
                break;

            case R.id.symptom_main_btn2:
                tmp_st_main=symptom_main_btn2.getText().toString();
                moreDialog.show();
                break;

            case R.id.symptom_main_btn3:
                tmp_st_main=symptom_main_btn3.getText().toString();
                moreDialog.show();
                break;
            case R.id.more_confirm:
                levelDialog.dismiss();
                Person.st_main=tmp_st_main;
                Person.st_place=tmp_st_place;
                Person.st_scale=tmp_st_scale;
                Person.st_sub=tmp_st_sub;
                break;
            default:
                break;
        }
    }


}


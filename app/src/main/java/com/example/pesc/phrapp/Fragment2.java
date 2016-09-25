package com.example.pesc.phrapp;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class Fragment2 extends Fragment implements View.OnClickListener {
    GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

         /* Dialog 부분 */
        final Dialog levelDialog = new Dialog(getContext());
        levelDialog.setTitle("Select level:");
        levelDialog.setContentView(R.layout.dialog_evaluation);

        final Dialog moreDialog = new Dialog(getActivity());
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
                Toast.makeText(getActivity(), "position:" + position, Toast.LENGTH_SHORT).show();
                levelDialog.show();
            }
        });

        /* SeekBar 부분, 통증 선택하기 */
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

        final TextView moreTxt = (TextView) moreDialog.findViewById(R.id.more_txt);
        final SeekBar moreSeek = (SeekBar) moreDialog.findViewById(R.id.more_seek);

        moreSeek.setMax(10);
        moreSeek.setProgress(10);

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

        Button cancel_button = (Button) levelDialog.findViewById(R.id.level_cancel);
        Button cancel2_button = (Button) levelDialog.findViewById(R.id.level_cancel2);
        Button level_more = (Button) levelDialog.findViewById(R.id.level_more);
        Button more_cancel = (Button) moreDialog.findViewById(R.id.more_cancel);
        Button goDialogBtn;

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //respond to level
                int chosenLevel = levelSeek.getProgress();
                levelDialog.dismiss();
            }
        });

        cancel2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //respond to level
                int chosenLevel = levelSeek.getProgress();
                levelDialog.dismiss();
            }
        });

        level_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moreDialog.show();
            }
        });

        more_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moreDialog.dismiss();
            }
        });

        return view;
    }

    // 각 그림 눌렀을 때 dialog 띄우기.. 나중에..
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.head_btn1:
                break;

            case R.id.head_btn2:

                break;

            case R.id.head_btn3:
                break;

            default:
                break;
        }
    }


}


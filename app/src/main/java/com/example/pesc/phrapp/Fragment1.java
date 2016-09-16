package com.example.pesc.phrapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.jar.Manifest;

public class Fragment1 extends Fragment {

    TextView tab1_name;
    TextView tab1_age;
    TextView tab1_sex;
    SignupActivity signUpActivity;
    Button cameraButton;
    ImageView myImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        int year = Calendar.getInstance().get(Calendar.YEAR);
        int age = year - Integer.parseInt(signUpActivity.getAge());

        int cmonth = Calendar.getInstance().get(Calendar.MONTH);
        int myMonth = Integer.parseInt(signUpActivity.getMonth());

        View view = inflater.inflate(R.layout.fragment_page1, container, false);

        signUpActivity = new SignupActivity();

        tab1_name = (TextView) view.findViewById(R.id.tab1_name);
        tab1_age = (TextView) view.findViewById(R.id.tab1_age);
        tab1_sex = (TextView) view.findViewById(R.id.tab1_sex);

        myImage = (ImageView) view.findViewById(R.id.myImage);
        cameraButton = (Button) view.findViewById(R.id.camera_button);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1);
            }
        });

        String user_name = signUpActivity.getName();
        tab1_name.setText(user_name);

        String user_age = signUpActivity.getAge();

        if (((cmonth + 1) - myMonth) >= 0) {
            tab1_age.setText("만 " + age + "세" + ". " + (cmonth - myMonth + 1) + "개월");
            System.out.println("=============================================" + cmonth);

        } else {
            tab1_age.setText("만 " + (age - 1) + "세" + ". " + (cmonth - myMonth + 13) + "개월");
            System.out.println("=============================================" + cmonth);

        }

        String user_sex = signUpActivity.getSex();
        tab1_sex.setText(user_sex);

        // 최초 권한 요청 or 사용자에 의한 요청
        if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //사용자가 임의로 취소 했을 시 재요청
        }

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        myImage.setImageURI(data.getData());
    }


}

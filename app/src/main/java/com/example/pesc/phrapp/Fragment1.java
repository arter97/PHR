package com.example.pesc.phrapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Fragment1 extends Fragment {

    TextView tab1_name;
    TextView tab1_age;
    TextView tab1_sex;
    Button cameraButton;
    Button manualButton;
    ImageView myImage;
    static EditText height, weight, abo, medicine, allergy, history, sleepTime, dailyStride;

    private static final int REQUEST_MICROPHONE = 3;
    private static final int REQUEST_EXTERNAL_STORAGE = 2;
    public static final int REQUEST_CAMERA = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        int year = Calendar.getInstance().get(Calendar.YEAR);
        //int age = year - Integer.parseInt(signUpActivity.getAge());
        int age = year - Person.birth.getYear();
        int cmonth = Calendar.getInstance().get(Calendar.MONTH);
        //int myMonth = Integer.parseInt(signUpActivity.getMonth());
        int myMonth = Person.birth.getMonth();

        View view = inflater.inflate(R.layout.fragment_page1, container, false);

        tab1_name = (TextView) view.findViewById(R.id.tab1_name);
        tab1_age = (TextView) view.findViewById(R.id.tab1_age);
        tab1_sex = (TextView) view.findViewById(R.id.tab1_sex);

        myImage = (ImageView) view.findViewById(R.id.myImage);
        height = (EditText) view.findViewById(R.id.height);
        weight = (EditText) view.findViewById(R.id.weight);
        abo = (EditText) view.findViewById(R.id.abo);
        medicine = (EditText) view.findViewById(R.id.medicine);
        allergy = (EditText) view.findViewById(R.id.allergy);
        history = (EditText) view.findViewById(R.id.history);
        sleepTime = (EditText) view.findViewById(R.id.sleepTime);
        dailyStride = (EditText) view.findViewById(R.id.dailyStride);


        cameraButton = (Button) view.findViewById(R.id.camera_button);
        cameraButton.setOnClickListener(buttonClickListener);

        manualButton = (Button) view.findViewById(R.id.manual_button);
        manualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (height.getText().length() == 0 || weight.getText().length() == 0) {
                    Toast.makeText(getActivity(), "키와 몸무게를 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if (getABO().length() == 0) {
                    Toast.makeText(getActivity(), "일일 평균 심박수, 혈액형란을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if (getMedicine().length() == 0) {
                    Toast.makeText(getActivity(), "복약목록란을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if (getAllergy().length() == 0) {
                    Toast.makeText(getActivity(), "알러지/금기목록란을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if (getHistory().length() == 0) {
                    Toast.makeText(getActivity(), "과거력란을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if (getSleepTime().length() == 0) {
                    Toast.makeText(getActivity(), "수면시간란을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if (getDailyStride().length() == 0) {
                    Toast.makeText(getActivity(), "일일 걸음수란을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.root, new EditedFragment());
                    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });

        //String user_name = signUpActivity.getName();
        String user_name = Person.name;

        tab1_name.setText(user_name);

        //String user_age = signUpActivity.getAge();
        String user_age = "" + age;


        if (((cmonth + 1) - myMonth) >= 0) {
            tab1_age.setText("만 " + age + "세" + ". " + (cmonth - myMonth + 1) + "개월");
            System.out.println("=============================================" + cmonth);

        } else {
            tab1_age.setText("만 " + (age - 1) + "세" + ". " + (cmonth - myMonth + 13) + "개월");
            System.out.println("=============================================" + cmonth);

        }

        //String user_sex = signUpActivity.getSex();
        String user_sex;
        if (Person.sex == 1)
            user_sex = "남";
        else
            user_sex = "여";
        tab1_sex.setText(user_sex);

        return view;
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.camera_button:
                    int permissionCamera = ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.CAMERA);
                    if (permissionCamera == PackageManager.PERMISSION_DENIED) {
                        ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.CAMERA}, REQUEST_CAMERA);
                    } else {
                        Toast.makeText(getActivity(), "camera permission authorized", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent, REQUEST_CAMERA);

                    }
                    break;

                default:
                    break;
            }
        }
    };

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CAMERA:
                for (int i = 0; i < permissions.length; i++) {
                    String permission = permissions[i];
                    int grantResult = grantResults[i];
                    if (permission.equals(android.Manifest.permission.CAMERA)) {
                        if (grantResult == PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(getActivity(), "camera permission authorized", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, REQUEST_CAMERA);
                        } else {
                            Toast.makeText(getActivity(), "camera permission denied", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;

                }
            default:
                break;
        }

    }

    public static String getHeight() {
        return height.getText().toString();
    }

    public static String getWeight() {
        return weight.getText().toString();
    }

    public static String getABO() {
        return abo.getText().toString();
    }

    public static String getMedicine() {
        return medicine.getText().toString();
    }

    public static String getAllergy() {
        return allergy.getText().toString();
    }

    public static String getHistory() {
        return history.getText().toString();
    }

    public static String getSleepTime() {
        return sleepTime.getText().toString();
    }

    public static String getDailyStride() {
        return dailyStride.getText().toString();
    }
}



package com.example.pesc.phrapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.nfc.tech.NfcBarcode;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
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
import java.util.jar.Manifest;

public class Fragment1 extends Fragment {

    TextView tab1_name;
    TextView tab1_age;
    TextView tab1_sex;
    SignupActivity signUpActivity;
    Button cameraButton;
    ImageView myImage;
    Button btn;
    
    private static final int REQUEST_MICROPHONE = 3;
    private static final int REQUEST_EXTERNAL_STORAGE = 2;
    public static final int REQUEST_CAMERA = 1;
    private EditText tab1_abo;
    private EditText tab1_allergy;
    private EditText tab1_dailyStride;
    private EditText tab1_height;
    private EditText tab1_history;
    private EditText tab1_medicine;
    private EditText tab1_sleepTime;
    private EditText tab1_weight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        int year = Calendar.getInstance().get(Calendar.YEAR);
        //int age = year - Integer.parseInt(signUpActivity.getAge());
        int age = year - Person.birth.getYear();


        int cmonth = Calendar.getInstance().get(Calendar.MONTH);
        //int myMonth = Integer.parseInt(signUpActivity.getMonth());
        int myMonth = Person.birth.getMonth();

        View view = inflater.inflate(R.layout.fragment_page1, container, false);

        signUpActivity = new SignupActivity();

        tab1_name = (TextView) view.findViewById(R.id.tab1_name);
        tab1_age = (TextView) view.findViewById(R.id.tab1_age);
        tab1_sex = (TextView) view.findViewById(R.id.tab1_sex);

        myImage = (ImageView) view.findViewById(R.id.myImage);
        cameraButton = (Button) view.findViewById(R.id.camera_button);

        cameraButton.setOnClickListener(buttonClickListener);

        tab1_abo=(EditText) view.findViewById(R.id.tab1_abo);
        tab1_allergy=(EditText) view.findViewById(R.id.tab1_allergy);
        tab1_dailyStride =(EditText) view.findViewById(R.id.tab1_dailyStride);
        tab1_height =(EditText) view.findViewById(R.id.tab1_height);
        tab1_history =(EditText) view.findViewById(R.id.tab1_history);
        tab1_medicine =(EditText) view.findViewById(R.id.tab1_medicine);
        tab1_sleepTime =(EditText) view.findViewById(R.id.tab1_sleepTime);
        tab1_weight =(EditText) view.findViewById(R.id.tab1_weight);

        //TODO : EditText에 적혀있는 내용을 서버로 옮겨야함


        //String user_name = signUpActivity.getName();
        String user_name = Person.name;

        tab1_name.setText(user_name);

        //String user_age = signUpActivity.getAge();
        String user_age = ""+age;


        if (((cmonth + 1) - myMonth) >= 0) {
            tab1_age.setText("만 " + age + "세" + ". " + (cmonth - myMonth + 1) + "개월");
            System.out.println("=============================================" + cmonth);

        } else {
            tab1_age.setText("만 " + (age - 1) + "세" + ". " + (cmonth - myMonth + 13) + "개월");
            System.out.println("=============================================" + cmonth);

        }

        //String user_sex = signUpActivity.getSex();
        String user_sex;
        if(Person.sex==1)
            user_sex="남";
        else
            user_sex="여";
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
                            Toast.makeText(getActivity(), "camera permission denied", Toast.LENGTH_LONG);
                        }
                    }
                    break;

                }
            default:
                break;
        }

    }
}

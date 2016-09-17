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
    private static final int REQUEST_CAMERA = 1;

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

        cameraButton.setOnClickListener(buttonClickListener);


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
                        Toast.makeText(getActivity(), "camera permission authorized", Toast.LENGTH_LONG);
                    }
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);
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
                            Toast.makeText(getActivity(), "camera permission authorized", Toast.LENGTH_LONG);
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

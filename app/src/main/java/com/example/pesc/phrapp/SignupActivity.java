package com.example.pesc.phrapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SignupActivity extends AppCompatActivity {

    static EditText phone;
    static EditText name;
    static EditText birth;
    static int age;
    //public EditText sex;
    public Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = (EditText) findViewById(R.id.user_name);
        phone = (EditText) findViewById(R.id.user_phoneNumber);
        //sex = (EditText)findViewById(R.id.sex);
        birth = (EditText) findViewById(R.id.user_birth);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });

        Button signUpButton = (Button) findViewById(R.id.signup);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);

                System.out.println("--------------------------------" + getName());

            }
        });
    }

    public static String getName(){
        return name.getText().toString();
    }

    public static String getAge(){
        return birth.getText().toString();
    }

}

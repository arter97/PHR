package com.example.pesc.phrapp;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    static EditText phone, name, birth;
    static String sex, month;
    public Bundle bundle;
    public EditText userId;
    public EditText userPwd;
    public EditText comparePwd;
    public EditText day;
    public Spinner spinner;
    private ArrayAdapter<CharSequence> spinnerAdapter = null;

    private Button manButton, womanButton;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = (EditText) findViewById(R.id.user_name);
        phone = (EditText) findViewById(R.id.user_phoneNumber);
        birth = (EditText) findViewById(R.id.user_birth);

        userId = (EditText) findViewById(R.id.user_account);
        userPwd = (EditText) findViewById(R.id.user_password);
        comparePwd = (EditText) findViewById(R.id.user_compare_password);
        day = (EditText) findViewById(R.id.user_day);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setSelection(0);
        spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.month, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        Resources res = getResources();
        final String[] month_array = res.getStringArray(R.array.month);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                parent.getItemAtPosition(position);
                spinner.setOnItemSelectedListener(this);
                month = month_array[position];


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

           /*     if (userId.getText().length() == 0 || userPwd.getText().length() == 0 || userPwd.getText().length() >= 10) {
                    Toast.makeText(SignupActivity.this, "아이디와 비밀번호를 확인해주세요. 비밀번호는 10자 이상으로 입력해주세요.", Toast.LENGTH_LONG).show();
                } else if (!userPwd.getText().toString().equals(comparePwd.getText().toString())) {
                    Toast.makeText(SignupActivity.this, "입력한 비밀번호가 같지 않습니다.", Toast.LENGTH_SHORT).show();
                    comparePwd.hasFocus();
                } else if (getName().length() == 0) {
                    Toast.makeText(SignupActivity.this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if (getSex().length() == 0) {
                    Toast.makeText(SignupActivity.this, "성별을 선택해주세요.", Toast.LENGTH_SHORT).show();
                }else if(getAge().length() == 0 || day.getText().length() == 0){
                    Toast.makeText(SignupActivity.this, "생년월일을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }else if(phone.getText().length() == 0){
                    Toast.makeText(SignupActivity.this, "휴대전화번호를 입력해주세요.", Toast.LENGTH_SHORT).show();

                }
                else {
                    startActivity(intent);
                }
*/
                startActivity(intent);

            }
        });

        manButton = (Button) findViewById(R.id.user_man);
        manButton.setOnClickListener(this);

        womanButton = (Button) findViewById(R.id.user_woman);
        womanButton.setOnClickListener(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.user_man:

                if (!manButton.isSelected()) {
                    manButton.setSelected(true);
                    womanButton.setSelected(false);
                    sex = "남자";

                } else {
                    manButton.setSelected(false);
                    sex = null;
                }
                break;

            case R.id.user_woman:

                if (!womanButton.isSelected()) {
                    womanButton.setSelected(true);
                    manButton.setSelected(false);
                    sex = "여자";

                } else {
                    womanButton.setSelected(false);
                    sex = null;
                }
                break;
            case R.id.head_btn1:

            default:
                break;
        }
    }

    public static String getName() {
        return name.getText().toString();
    }

    public static String getAge() {
        return birth.getText().toString();
    }

    public String getSex() {
        return sex;
    }

    static String getMonth() {
        if (month.length() == 2) {
            return month.substring(0, 1);
        } else {
            return month.substring(0, 2);
        }

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Signup Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.pesc.phrapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Signup Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.pesc.phrapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

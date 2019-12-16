package com.faculdade.buddyride.TestActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateUtils;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.faculdade.buddyride.Controllers.Facade;
import com.faculdade.buddyride.R;

import java.util.Date;

public class TestLogonActivity extends AppCompatActivity {

    TextView mFirstName;
    TextView mSurname;
    TextView mUsername;
    TextView mBirthDate;
    TextView mPasswordFirst;
    TextView mPasswordSecond;
    Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_logon);

        mFirstName = findViewById(R.id.test_name);
        mSurname = findViewById(R.id.test_surname);
        mUsername = findViewById(R.id.test_username);
        mBirthDate = findViewById(R.id.test_birthdate);
        mPasswordFirst = findViewById(R.id.test_password_first);
        mPasswordSecond = findViewById(R.id.test_password_second);
        mRegister = findViewById(R.id.test_register);

        mRegister.setOnClickListener(checkAndRegister());
    }

    private View.OnClickListener checkAndRegister() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Facade facade = Facade.getInstance();

                String name = mFirstName.getText().toString();
                String surname = mSurname.getText().toString();

//                Toast.makeText(v.getContext(), birthDate.toString(), Toast.LENGTH_LONG).show();

//                facade.createNewUser(name, surname, birthDate, email, profileName, password);
            }
        };
    }
}

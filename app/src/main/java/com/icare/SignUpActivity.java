package com.icare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity {

    TextView txtDate;
    private int mYear, mMonth, mDay, mHour, mMinute;
    TextInputLayout layoutEmail,layoutUsername,layoutName,layoutPassword;
    TextInputEditText edtEmail, edtUsername, edtName, edtPassword;
    Button btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        addControls();
        addEvents();
    }

    private void addControls() {
        layoutUsername = findViewById(R.id.input_layout_username);
        layoutName = findViewById(R.id.input_layout_name);
        layoutEmail = findViewById(R.id.input_layout_email);
        layoutPassword = findViewById(R.id.input_layout_password);

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtUsername = findViewById(R.id.edtUserName);

        btnCreateAccount = findViewById(R.id.btnSignUp);

        txtDate = findViewById(R.id.date_picker);
    }

    private void addEvents() {
        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickDate();
            }
        });

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String username = edtUsername.getText().toString();
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();

                createNewUser(username,name,email,password);
            }
        });
    }

    private void createNewUser(String username, String name, String email, String password) {

    }

    private void pickDate() {
        final Calendar c = Calendar.getInstance();

        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(SignUpActivity.this,R.style.CustomDatePickerDialogTheme,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);

        datePickerDialog.show();
    }
}
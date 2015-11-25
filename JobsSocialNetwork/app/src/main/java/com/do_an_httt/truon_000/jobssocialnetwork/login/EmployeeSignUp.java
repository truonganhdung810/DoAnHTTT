package com.do_an_httt.truon_000.jobssocialnetwork.login;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.asyntask.EmployeeSignUpAsyntask;
import com.do_an_httt.truon_000.jobssocialnetwork.view.CustomToast;

import java.util.Calendar;

/**
 * Created by truon_000 on 11/19/2015.
 */
public class EmployeeSignUp extends Activity {

    private EditText edtEmailEmployee, edtPasswordEmployee, edtPasswordConfirm, edtBirthday;
    private RadioGroup rdgroupGender;
    private RadioButton rdbtMale, rdbtFemale;
    private Button btSignUpEmployee;

    private String email, password, confirmpassword, birthday, gender;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_employee);

        initLayout();
        setOnClickButtonSignUp();
    }

    private void initLayout() {

        edtEmailEmployee = (EditText) findViewById(R.id.edtEmailEmployee);
        edtPasswordEmployee = (EditText) findViewById(R.id.edtPasswordEmployee);
        edtPasswordConfirm = (EditText) findViewById(R.id.edtConfirmPasswordEmployee);
        edtBirthday = (EditText) findViewById(R.id.edtBirthDay);

        rdgroupGender = (RadioGroup) findViewById(R.id.rdgroupGender);
        rdbtFemale = (RadioButton) findViewById(R.id.rdbtFemale);
        rdbtMale = (RadioButton) findViewById(R.id.rdbtMale);

        edtPasswordEmployee.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edtPasswordConfirm.setTransformationMethod(PasswordTransformationMethod.getInstance());

        btSignUpEmployee = (Button) findViewById(R.id.btEmployeeSignUp);

        edtBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);


                datePickerDialog = new DatePickerDialog(EmployeeSignUp.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear++;
                        String datePick = dayOfMonth + "/" + monthOfYear + "/" + year;
                        datePickerDialog.dismiss();
                        edtBirthday.setText(datePick);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }

    private void setOnClickButtonSignUp() {

        btSignUpEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getStringFromEditText();
                if (checkStringFromEditText())
                    new EmployeeSignUpAsyntask(EmployeeSignUp.this).execute(email, password, birthday, gender);
                else {
                    new CustomToast(EmployeeSignUp.this, "Đăng ký thất bại", 1000);
                }

            }
        });

    }

    private void getStringFromEditText() {

        email = edtEmailEmployee.getText().toString();
        email.trim();

        password = edtPasswordEmployee.getText().toString();
        password.trim();

        confirmpassword = edtPasswordConfirm.getText().toString();
        confirmpassword.trim();

        birthday = edtBirthday.getText().toString();
        birthday.trim();

        if (rdgroupGender.getCheckedRadioButtonId() == R.id.rdbtMale) gender = "male";
        else gender = "female";

    }

    private Boolean checkStringFromEditText() {
        if (!password.equals(confirmpassword)) return false;
        if (email.equals("") || password.equals("") || birthday.equals(""))
            return false;
        else return true;
    }
}

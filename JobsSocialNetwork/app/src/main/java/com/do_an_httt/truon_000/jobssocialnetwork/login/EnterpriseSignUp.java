package com.do_an_httt.truon_000.jobssocialnetwork.login;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.asyntask.EmployeeSignUpAsyntask;
import com.do_an_httt.truon_000.jobssocialnetwork.asyntask.EnterpriseSignUpAsyntask;
import com.do_an_httt.truon_000.jobssocialnetwork.types.Enterprise;
import com.do_an_httt.truon_000.jobssocialnetwork.view.CustomToast;

import java.util.Calendar;

public class EnterpriseSignUp extends Activity {

    private EditText edtEmail, edtPassword, edtConfirm, edtDateEstablish, edtName;
    private Spinner spinerTypeOfEnterprise;

    private Button btRegister;

    private String email, password, confirmpassword, dateEstablish, domain, name;

    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterprise_sign_up);

        domain = "0";
        intLayout();
        setOnClickSignUp();
    }

    private void intLayout() {
        edtEmail = (EditText) findViewById(R.id.edtEmailEnterprise);
        edtPassword = (EditText) findViewById(R.id.edtPasswordEnterprise);
        edtConfirm = (EditText) findViewById(R.id.edtConfirmPasswordEnterprise);
        edtDateEstablish = (EditText) findViewById(R.id.edtDateEstablishEnterprise);
        edtName = (EditText) findViewById(R.id.edtNameEnterprise);

        spinerTypeOfEnterprise = (Spinner) findViewById(R.id.spinerTypeOfEnterprise);

        btRegister = (Button) findViewById(R.id.btEnterpriseSignUp);

        edtDateEstablish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);


                datePickerDialog = new DatePickerDialog(EnterpriseSignUp.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear++;
                        String datePick = dayOfMonth + "/" + monthOfYear + "/" + year;
                        datePickerDialog.dismiss();
                        edtDateEstablish.setText(datePick);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }

    private void setOnClickSignUp() {
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getStringFromEditText();
                if (checkStringFromEditText())
                    new EnterpriseSignUpAsyntask(EnterpriseSignUp.this).execute(email, password, name, dateEstablish, domain);
                else {
                    new CustomToast(EnterpriseSignUp.this, "Đăng ký thất bại", 1000);
                }
            }
        });
    }

    private void getStringFromEditText() {

        email = edtEmail.getText().toString();
        email.trim();

        password = edtPassword.getText().toString();
        password.trim();

        confirmpassword = edtConfirm.getText().toString();
        confirmpassword.trim();

        dateEstablish = edtDateEstablish.getText().toString();
        dateEstablish.trim();

        name = edtName.getText().toString();
        name.trim();


    }

    private Boolean checkStringFromEditText() {
        if (!password.equals(confirmpassword)) return false;
        if (email.equals("") || password.equals("") || dateEstablish.equals("") || name.equals(""))
            return false;
        else return true;
    }

}

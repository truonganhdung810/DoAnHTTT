package com.do_an_httt.truon_000.jobssocialnetwork.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.asyntask.LoginAsyntask;
import com.do_an_httt.truon_000.jobssocialnetwork.main.employee.activity.ActivityMainView;
import com.do_an_httt.truon_000.jobssocialnetwork.main.enterprise.activity.EnterpriseMain;
import com.do_an_httt.truon_000.jobssocialnetwork.view.CustomToast;

public class LoginActivity extends Activity implements View.OnClickListener {

    //Textview Option
    private TextView tvResetPassword, tvSignUp;

    // Button login
    private Button btLogin;

    private EditText edtEmail, edtPassword;

    private String email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();


    }

    private void initView() {

        tvResetPassword = (TextView) findViewById(R.id.tvResetPassword);
        tvSignUp = (TextView) findViewById(R.id.tvRegister);

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

        btLogin = (Button) findViewById(R.id.btLogin);


        tvResetPassword.setOnClickListener(this);
        tvSignUp.setOnClickListener(this);
        btLogin.setOnClickListener(this);
    }

    private void getStringFromEditText() {
        password = edtPassword.getText().toString();
        password.trim();

        email = edtEmail.getText().toString();
        email.trim();
    }

    private boolean checkStringFromEditText() {
        if (email.equals("") || password.equals("")) return false;
        else return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvResetPassword:

                goToResetPasswordActivity();

                break;

            case R.id.tvRegister:

                showDialogSelectTypeOfAccount();
                break;

            case R.id.btLogin:

                getStringFromEditText();
                if (checkStringFromEditText())
                    new LoginAsyntask(this).execute(email, password);
                else new CustomToast(LoginActivity.this, "Đăng nhập thất bại", 1000);
                // gotoEnterpriseMainView();
                //gotoEmployeeMainView();
        }
    }

    private void gotoEmployeeMainView() {
        Intent intent = new Intent(this, ActivityMainView.class);
        startActivity(intent);
    }


    private void gotoEnterpriseMainView() {
        Intent intent = new Intent(this, EnterpriseMain.class);
        startActivity(intent);
    }

    private void goToResetPasswordActivity() {
        Intent intent = new Intent(this, ResetPassword.class);
        startActivity(intent);
    }


    private void showDialogSelectTypeOfAccount() {
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("SELECT");
        dialog.setMessage("Please select the type of account that you want create");
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "EMPLOYEE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent employeeSignUpIntent = new Intent(LoginActivity.this, EmployeeSignUp.class);
                startActivity(employeeSignUpIntent);
            }
        });

        dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "ENTERPRISE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent enterpriseSignUpIntent = new Intent(LoginActivity.this, EnterpriseSignUp.class);
                startActivity(enterpriseSignUpIntent);
            }
        });

        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}

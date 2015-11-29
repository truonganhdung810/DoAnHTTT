package com.do_an_httt.truon_000.jobssocialnetwork.asyntask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.main.employee.activity.ActivityMainView;
import com.do_an_httt.truon_000.jobssocialnetwork.main.enterprise.activity.EnterpriseMain;
import com.do_an_httt.truon_000.jobssocialnetwork.types.Employee;
import com.do_an_httt.truon_000.jobssocialnetwork.types.Enterprise;
import com.do_an_httt.truon_000.jobssocialnetwork.view.CustomToast;
import com.example.nguyenhuungoc.connecttophp.ConnectToPHP;
import com.google.gson.Gson;

/**
 * Created by truon_000 on 11/24/2015.
 */
public class LoginAsyntask extends AsyncTask<String, Void, Boolean> {

    ProgressDialog dialog;
    String json;
    Context context;

    public LoginAsyntask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = new ProgressDialog(context);
        dialog.setMessage("Loading...");
        dialog.show();
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }

        if (result) {
//            new CustomToast(context, "Đăng ký thành công", 1000);
//            Intent intent = new Intent(context, LoginActivity.class);
//            context.startActivity(intent);
//            ((Activity) context).finish();
            Log.d("Result: ", json);
            ProjectManagement.employee = (new Gson()).fromJson(json, Employee.class);
            if (ProjectManagement.employee.sex == null) {
                ProjectManagement.enterprise = (new Gson()).fromJson(json, Enterprise.class);
                Log.d("Enterprise", ProjectManagement.enterprise.name);
                startActivityEnterprise();
            } else {
                startActivityEmployee();
            }


            // goto MainActivity
        } else {
            //that bai;
            new CustomToast(context, "Đăng nhập thất bại", 1000);
        }
    }

    private void startActivityEnterprise() {
        Intent intentToEnterprise = new Intent(context, EnterpriseMain.class);
        context.startActivity(intentToEnterprise);
        ((Activity) context).finish();
    }

    private void startActivityEmployee() {
        Intent intentToEmployee = new Intent(context, ActivityMainView.class);
        context.startActivity(intentToEmployee);
        ((Activity) context).finish();
    }

    @Override
    protected Boolean doInBackground(String... params) {
        String email = params[0];
        String password = params[1];

        try {
            String[] keys = new String[]{"email", "password"};
            String[] values = new String[]{email, password};

            json = ConnectToPHP.connect(ProjectManagement.BASE_URL + "sign_in.php", keys, values);
            if (json.trim().equals("fail")) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}

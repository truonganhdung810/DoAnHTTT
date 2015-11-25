package com.do_an_httt.truon_000.jobssocialnetwork.asyntask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.example.nguyenhuungoc.connecttophp.ConnectToPHP;

/**
 * Created by truon_000 on 11/24/2015.
 */
public class EnterpriseSignUpAsyntask extends AsyncTask<String, Void, Boolean> {

    ProgressDialog dialog;
    String json;
    Context context;

    public EnterpriseSignUpAsyntask(Context context) {
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

            Log.d("Result: ", json);


        } else {
            //that bai;
            Log.d("Result", "That bai");
        }
    }

    @Override
    protected Boolean doInBackground(String... params) {
        String email = params[0];
        String password = params[1];
        String name = params[2];
        String established_date = params[3];
        String domain = params[4];

        try {
            String[] keys = new String[]{"email", "password", "name", "established_date", "domain"};
            String[] values = new String[]{email, password, name, established_date, domain};

            json = ConnectToPHP.connect(ProjectManagement.BASE_URL + "create_company.php", keys, values);
            if (json.trim().equals("fail")) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}

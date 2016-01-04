package com.do_an_httt.truon_000.jobssocialnetwork.asyntask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.main.employee.activity.ActivityMainView;
import com.do_an_httt.truon_000.jobssocialnetwork.types.Message;
import com.example.nguyenhuungoc.connecttophp.ConnectToPHP;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by truon_000 on 1/5/2016.
 */
public class GetAllMessageAsyntask extends AsyncTask<String, Void, Boolean> {
    ProgressDialog dialog;
    String json;
    Context context;

    public GetAllMessageAsyntask(Context context) {
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
            Log.d("Result_1", json);
            if (json.equals("null")) {
                ProjectManagement.listMessage = new ArrayList<Message>();
            } else {
                Type message = new TypeToken<ArrayList<Message>>() {
                }.getType();
                ProjectManagement.listMessage = (new Gson()).fromJson(json, message);
            }

            Intent intentToEmployee = new Intent(context, ActivityMainView.class);
            context.startActivity(intentToEmployee);
            ((Activity) context).finish();

        } else {
            //that bai;
            Log.d("Result", "That bai");
        }
    }

    @Override
    protected Boolean doInBackground(String... params) {

        String[] keys = new String[]{"email"};
        String[] values = new String[]{params[0]};

        try {
            json = ConnectToPHP.connect(ProjectManagement.BASE_URL + "get_message.php", keys, values);
            Log.d("Result_2", json);
            if (json.trim().equals("fail")) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}

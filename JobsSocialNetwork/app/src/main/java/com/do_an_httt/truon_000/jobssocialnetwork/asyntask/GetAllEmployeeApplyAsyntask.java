package com.do_an_httt.truon_000.jobssocialnetwork.asyntask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.main.enterprise.adapter.AdapterJobApplier;
import com.do_an_httt.truon_000.jobssocialnetwork.types.Applier;
import com.example.nguyenhuungoc.connecttophp.ConnectToPHP;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by truon_000 on 1/4/2016.
 */
public class GetAllEmployeeApplyAsyntask extends AsyncTask<String, Void, Boolean> {

    ProgressDialog dialog;
    String json;
    Context context;
    ListView lvEmployeeApplier;

    public GetAllEmployeeApplyAsyntask(Context context, ListView listView) {

        this.context = context;
        this.lvEmployeeApplier = listView;
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
            Log.d("Result", json);
            Type applier = new TypeToken<ArrayList<Applier>>() {
            }.getType();
            ProjectManagement.allApplier = (new Gson()).fromJson(json, applier);
            Log.d("Result", ProjectManagement.allApplier.size() + "");

            for (Applier item : ProjectManagement.allApplier) {
                Log.d("Result", "Name: " + item.name);
                Log.d("Result", "Email: " + item.email);
            }

            AdapterJobApplier adapterJobApplier = new AdapterJobApplier(context, ProjectManagement.allApplier);
            lvEmployeeApplier.setAdapter(adapterJobApplier);

        } else {
            //that bai;
            Log.d("Result", "That bai");
        }
    }

    @Override
    protected Boolean doInBackground(String... params) {
        String id = params[0];

        try {
            String[] keys = new String[]{"id_job"};
            String[] values = new String[]{id};

            json = ConnectToPHP.connect(ProjectManagement.BASE_URL + "get_applier.php", keys, values);
            if (json.trim().equals("fail")) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}

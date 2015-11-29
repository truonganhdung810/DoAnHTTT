package com.do_an_httt.truon_000.jobssocialnetwork.asyntask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.types.FriendItem;
import com.do_an_httt.truon_000.jobssocialnetwork.types.Job;
import com.example.nguyenhuungoc.connecttophp.ConnectToPHP;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by truon_000 on 11/24/2015.
 */
public class GetAllFriendAsyntask extends AsyncTask<String, Void, Boolean> {

    ProgressDialog dialog;
    String json;
    Context context;

    public GetAllFriendAsyntask(Context context) {
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
            Log.d("Result", json);
            Type friend = new TypeToken<ArrayList<FriendItem>>() {
            }.getType();
            ProjectManagement.allfriends = (new Gson()).fromJson(json, friend);
            Log.d("Result", ProjectManagement.allfriends.size() + "");

            for (FriendItem item_friend : ProjectManagement.allfriends) {
                Log.d("Result", item_friend.email);
            }
        } else {
            //that bai;
            Log.d("Result", "That bai");
        }
    }

    @Override
    protected Boolean doInBackground(String... params) {
        String email = params[0];

        try {
            String[] keys = new String[]{"email"};
            String[] values = new String[]{email};

            json = ConnectToPHP.connect(ProjectManagement.BASE_URL + "get_friend.php", keys, values);
            if (json.trim().equals("fail")) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}

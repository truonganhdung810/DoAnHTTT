package com.do_an_httt.truon_000.jobssocialnetwork.main;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.do_an_httt.truon_000.jobssocialnetwork.ProjectManagement;
import com.do_an_httt.truon_000.jobssocialnetwork.R;
import com.do_an_httt.truon_000.jobssocialnetwork.types.FriendItem;

import java.util.ArrayList;

public class ActivitySendMessage extends Activity {

    private TextView tvEmailSender;
    private EditText edtEmailReceiver, edtTitleMessage, edtContentMessage;
    private Button btSendMessage;
    private ImageView imgvAddEmailReceiver;

    public static boolean[] checkSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_send_message);

        initLayout();
    }

    private void initLayout() {

        tvEmailSender = (TextView) findViewById(R.id.tvSenderMessage);
        edtEmailReceiver = (EditText) findViewById(R.id.edtSendMessageReceiver);
        edtTitleMessage = (EditText) findViewById(R.id.edtTitleSendMessage);
        edtContentMessage = (EditText) findViewById(R.id.edtContentSendMessage);

        imgvAddEmailReceiver = (ImageView) findViewById(R.id.imgvShowListCheckBoxFriend);

        btSendMessage = (Button) findViewById(R.id.btSendMessage);

        clickChooseFriend();

    }

    private void clickChooseFriend() {

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.popup_list_friend, (ViewGroup) findViewById(R.id.ln_popup_listfriend_choose));

        final PopupWindow popupWindow = new PopupWindow(layout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);

        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    popupWindow.dismiss();
                    return true;
                }
                return false;
            }
        });

        popupWindow.setContentView(layout);
        RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.rlt_send_message);

        final ArrayList<String> items = new ArrayList<>();
        for (FriendItem friendItem : ProjectManagement.allfriends) {
            items.add(friendItem.email);
        }

        final ListView list = (ListView) layout.findViewById(R.id.lvListFriendChoose);
        DropDownListAdapter adapter = new DropDownListAdapter(this, items, edtEmailReceiver);
        list.setAdapter(adapter);


        imgvAddEmailReceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.showAsDropDown(v);
            }
        });
    }

}

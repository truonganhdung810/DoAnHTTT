package com.do_an_httt.truon_000.jobssocialnetwork.main;

/**
 * Created by truon_000 on 11/29/2015.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.do_an_httt.truon_000.jobssocialnetwork.R;

import java.util.ArrayList;

public class DropDownListAdapter extends BaseAdapter {

    private ArrayList<String> mListItems;
    private LayoutInflater mInflater;
    private EditText mSelectedItems;
    private static int selectedCount = 0;
    private static String firstSelected = "";
    private ViewHolder holder;
    private static String selected = "";    //shortened selected values representation

    public static String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        DropDownListAdapter.selected = selected;
    }

    public DropDownListAdapter(Context context, ArrayList<String> items,
                               EditText edt) {
        mListItems = new ArrayList<String>();
        mListItems.addAll(items);
        mInflater = LayoutInflater.from(context);
        mSelectedItems = edt;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mListItems.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_friend_drop_down_item, null);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.tvEmailFriendItem);
            holder.chkbox = (CheckBox) convertView.findViewById(R.id.ckbFriendItemChoose);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv.setText(mListItems.get(position));

        final int position1 = position;

        //whenever the checkbox is clicked the selected values textview is updated with new selected values
        holder.chkbox.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                setText(position1);
            }
        });

        if (ActivitySendMessage.checkSelected[position])
            holder.chkbox.setChecked(true);
        else
            holder.chkbox.setChecked(false);
        return convertView;
    }


    /*
     * Function which updates the selected values display and information(checkSelected[])
     * */
    private void setText(int position1) {
        if (!ActivitySendMessage.checkSelected[position1]) {
            ActivitySendMessage.checkSelected[position1] = true;
            selectedCount++;
        } else {
            ActivitySendMessage.checkSelected[position1] = false;
            selectedCount--;
        }

        if (selectedCount == 0) {
            mSelectedItems.setText("Select friends");
        } else if (selectedCount == 1) {
            for (int i = 0; i < ActivitySendMessage.checkSelected.length; i++) {
                if (ActivitySendMessage.checkSelected[i] == true) {
                    firstSelected = mListItems.get(i);
                    break;
                }
            }
            mSelectedItems.setText(firstSelected);
            setSelected(firstSelected);
        } else if (selectedCount > 1) {
            for (int i = 0; i < ActivitySendMessage.checkSelected.length; i++) {
                if (ActivitySendMessage.checkSelected[i] == true) {
                    firstSelected = mListItems.get(i);
                    break;
                }
            }
            mSelectedItems.setText(firstSelected + " & " + (selectedCount - 1) + " more");
            setSelected(firstSelected + " & " + (selectedCount - 1) + " more");
        }
    }

    private class ViewHolder {
        TextView tv;
        CheckBox chkbox;
    }
}
package com.example.thefamily_proto;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JaeBong on 15. 2. 2..
 */
public class inviteListAdapter extends ArrayAdapter<Contact> {
    private Context context;
    private int layoutResourceId;
    private ArrayList<Contact> phoneNumberList;

    public inviteListAdapter(Context context, int layoutResourceId, ArrayList<Contact> phoneNumberList){
        super(context,layoutResourceId,phoneNumberList);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.phoneNumberList = phoneNumberList;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId,parent,false);
        }

        return row;
    }
}

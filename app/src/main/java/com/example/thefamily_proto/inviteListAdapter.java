package com.example.thefamily_proto;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by JaeBong on 15. 2. 2..
 */
public class inviteListAdapter extends ArrayAdapter<contact> {



    public inviteListAdapter(Context context, int layoutResourceId, ArrayList<contact> phoneNumberList){
        super(context,layoutResourceId,phoneNumberList);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}

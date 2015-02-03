package com.example.thefamily_proto;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;


public class AddFamilyMember extends Activity implements View.OnClickListener{

    private ImageButton sendInviteMessage;
    private ListView inviteList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_family_member);

        ActionBar actionBar = getActionBar();
        actionBar.hide();

//        inviteList = (ListView)findViewById(R.id.inviteList);
//        inviteList.setAdapter();

        sendInviteMessage = (ImageButton)findViewById(R.id.bt_sendInviteMessage);
        sendInviteMessage.setOnClickListener(this);




    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_sendInviteMessage:

        }
    }
}

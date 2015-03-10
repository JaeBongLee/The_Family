package com.example.thefamily_proto;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class p4_home extends Activity implements View.OnClickListener {

    ImageButton btn_home;
    ImageButton btn_viewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p4_home);

        ActionBar actionBar = getActionBar();
        actionBar.hide();

        btn_home = (ImageButton)findViewById(R.id.btn_home);
        btn_viewAll = (ImageButton)findViewById(R.id.btn_viewAll);

        btn_viewAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_viewAll:
                Intent intent = new Intent(this,p5_view_all.class);
                startActivity(intent);
                break;
        }
    }
}

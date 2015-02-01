package com.example.thefamily_proto;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SelectRole extends Activity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_role);

        ActionBar actionBar = getActionBar();
        actionBar.hide();

		ImageButton bt_grandFather = (ImageButton)findViewById(R.id.bt_grandFather);

        bt_grandFather.setOnClickListener(this);

	}

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bt_grandFather:
                Intent intent = new Intent(this,InputInform.class);
                startActivity(intent);
        }

    }
}

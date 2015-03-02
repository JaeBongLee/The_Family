package com.example.thefamily_proto;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class CheckFamily extends Activity implements OnClickListener {
	ImageButton btn_yes;
	ImageButton btn_no;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_p1_check_family);
		
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		btn_yes = (ImageButton)findViewById(R.id.btn_yes);
		btn_no = (ImageButton)findViewById(R.id.btn_no);
		
		btn_yes.setOnClickListener(this);
		btn_no.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.btn_yes:
            btn_yes.setImageResource(R.drawable.bt_yes_black);

			//핸드폰 번호 정보를 검색해서 
			TelephonyManager tMgr = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
			//String myPhoneNumber = tMgr.getLine1Number();
			String myPhoneNumber = "+821066090484";
			if(myPhoneNumber != null){
				Log.i("CheckFamily",myPhoneNumber);
			}
			else{
				Log.i("CheckFamily","Cannot read device phone number");
			}
			
			// 새로운 화면을 띄운다.
			Intent intent = new Intent(this,SelectRole.class);
			startActivity(intent);
            btn_yes.setImageResource(R.drawable.bt_yes_white);
			break;
			
         case R.id.btn_no:
            btn_no.setImageResource(R.drawable.bt_no_black);
            break;
		}
		
	}

}

package com.example.thefamily_proto;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class InputInform extends Activity implements View.OnClickListener {

    int year, month, day;
    ImageButton birthdayButton;
    TextView birthday;
    String date;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_inform);

        //ActionBar를 숨긴다.
        ActionBar actionBar = getActionBar();
        actionBar.hide();

        //달력을 설정
        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        birthdayButton = (ImageButton) findViewById(R.id.bt_birthday);
        birthday = (TextView) findViewById(R.id.tv_birthday);

        //생일입력 버튼을 만듬
        birthdayButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            //생일입력버튼을 누르면 생일을 입력하는 pickerDilaog를 띄우게 함
            case R.id.bt_birthday:
                new DatePickerDialog(this, dateSetListener, year, month, day).show();

        }
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            //picker에서 입력받은 생일을 저장
            date = String.format("%d%d%d", year, monthOfYear + 1, dayOfMonth);
            //birthday에 date정보를 string으로 저장
            birthday.setText(date);
        }
    };

}

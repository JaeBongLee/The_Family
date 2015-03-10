package com.example.thefamily_proto;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;

import java.util.ArrayList;


public class p5_view_all extends Activity implements View.OnClickListener{

    private final Handler handler = new Handler();
    private Dao dao ;
    private ArrayList<Post> postList;
    protected ImageButton btn_viewAll_all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p5_view_all);

        ActionBar actionBar = getActionBar();
        actionBar.hide();

        dao = new Dao(getApplicationContext());
        btn_viewAll_all = (ImageButton)findViewById(R.id.btn_viewAll_all);

        btn_viewAll_all.setOnClickListener(this);
        refreshData();

    }

    private void refreshData(){
        new Thread(){
            public void run(){
            Log.i("test","refresh Start");
            Proxy proxy = new Proxy();
            String jsonData = proxy.getAllContents();

            Log.i("test","jsonData " + jsonData);

            dao.insertJsonData(jsonData);

            Log.i("test","Dao done");

            handler.post(new Runnable(){
                public void run(){
                    setGridView();
                }
            });
            }
        }.start();
    }

    private void setGridView(){
        //DataBase���� ������ �о��
        postList = dao.getPostList();

        Log.i("test","PostList[0] = " + postList.get(0).toString());


        ViewAllAdapter adapter = new ViewAllAdapter(this,R.layout.view_all_block_image,postList);
        GridView postView = (GridView)findViewById(R.id.postView);
        postView.setAdapter(adapter);
        Log.i("test","setAdapter Done");
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_viewAll_all:
                refreshData();
                break;

        }
    }
}

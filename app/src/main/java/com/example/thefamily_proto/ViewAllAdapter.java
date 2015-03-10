package com.example.thefamily_proto;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ViewAllAdapter extends ArrayAdapter<Post>{

    private Context context;
    private int resourceId;
    private ArrayList<Post> postList;

    public ViewAllAdapter(Context context, int resourceId, ArrayList<Post> postList) {
        super(context, resourceId, postList);
        this.context = context;
        this.resourceId = resourceId;
        this.postList = postList;

    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;
        String date;
        String imageUrl;
        String typeNum;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(resourceId, parent,false);
        }

        ImageView back_image = (ImageView)row.findViewById(R.id.back_image);
        TextView year_month = (TextView)row.findViewById(R.id.year_month);
        TextView day = (TextView)row.findViewById(R.id.day);
        TextView week_of_day = (TextView)row.findViewById(R.id.week_of_day);

        typeNum = postList.get(position).getType();

        Log.i("test", "PositionNum"+ position);
        Log.i("test","TypeOfPostion" + typeNum);


        if(typeNum.equals("0"))
        {
            date = postList.get(position).getDate();
            year_month.setText(date.substring(0,4));
            day.setText(date.substring(4,6));
            week_of_day.setText(date.substring(6,8));
        }

        if(typeNum.equals("1"))
        {
            Log.i("test", "imageInput");
            imageUrl = postList.get(position).getPicUrl();
            Log.i("test","imageUrl :" + imageUrl);

            Picasso.with(context).load(imageUrl).into(back_image);
            Log.i("test","Picasso done");
            year_month.setText("");
            day.setText("");
            week_of_day.setText("");
        }

        if(typeNum.equals("2"))
        {
            Log.i("test", "memoInput");
            year_month.setText(postList.get(position).getText());
        }
          Log.i("test","getView Done");
        return row;
    }

}

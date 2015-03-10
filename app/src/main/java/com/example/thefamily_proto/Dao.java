package com.example.thefamily_proto;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by JaeBong on 15. 3. 4..
 */
public class Dao {
    private Context context;
    private SQLiteDatabase database;

    public Dao(Context context) {
        this.context = context;

        database = context.openOrCreateDatabase("LocalDATA.db",
                SQLiteDatabase.CREATE_IF_NECESSARY, null);

        try {
            String createPostSQL = "CREATE TABLE IF NOT EXISTS Posts(ID integer primary key autoincrement,"
                    + "										 Date text not null,"
                    + "										 PicUrl text unique,"
                    + "										 Content text ,"
                    + "										 Type text not null,"
                    + "										 User_id integer not null,"
                    + "										 Family_id integer not null);";
            database.execSQL(createPostSQL);


        } catch (Exception e) {
            Log.e("test", "CREATE TABLE FAILED! - " + e);
            e.printStackTrace();
        }
    }

    public void insertJsonData(String jsonData) {

        String Date;
        String PicUrl;
        String Content;
        String Type;
        String User_id;
        String Family_id;


        try {
            JSONArray jArr = new JSONArray(jsonData);

            for (int i = 0; i < jArr.length(); ++i) {
                JSONObject jObj = jArr.getJSONObject(i);

                Date = jObj.getString("post_date");
                PicUrl = jObj.getString("post_picUrl");
                Content = jObj.getString("post_text");
                Type = jObj.getString("post_type");
                User_id = jObj.getString("user_id");
                Family_id = jObj.getString("family_id");

                Log.i("test", "Date: " + Date + " Content:"
                        + Content);

                String sql = "INSERT INTO Posts(Date, PicUrl, Content, Type, User_id, Family_id)"
                        + " VALUES("
                        + Date
                        + ", '"
                        + PicUrl
                        + "', '"
                        + Content
                        + "', '"
                        + Type
                        + "', '"
                        + User_id
                        + "', '"
                        + Family_id + "');";

                try {
                    database.execSQL(sql);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        } catch (Exception e) {
            Log.e("test", "JSON ERROR! - " + e);
            e.printStackTrace();
        }

    }

    public ArrayList<Post> getPostList() {

        ArrayList<Post> postList = new ArrayList<Post>();

        int Id;
        String Date;
        String PicUrl;
        String Content;
        String Type;
        String User_id;
        String Family_id;

        String sql = "SELECT * FROM Posts;";
        Cursor cursor = database.rawQuery(sql, null);

        while (cursor.moveToNext()) {

            Id = cursor.getInt(0);
            Date = cursor.getString(1);
            PicUrl = cursor.getString(2);
            Content = cursor.getString(3);
            Type = cursor.getString(4);
            User_id = cursor.getString(5);
            Family_id = cursor.getString(6);

            postList.add(new Post(Id,Date,PicUrl,Content,Type,User_id,Family_id));
        }

        cursor.close();

        return postList;
    }
}

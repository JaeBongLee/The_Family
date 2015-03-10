package com.example.thefamily_proto;

import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;

public interface TheFamilyService {

    //쿼리로 FamilyId같이 보내기
    //JsonObject로 사진 url
    @GET("/familyMain/familyPic")
    JSONObject getMainPic();

    //가족 메인사진 보내기 위해 사용
    //FamilyId같이 보내기
    @Multipart
    @POST("/familyMain/familyPic")
    void setMainPic(int familyNum, String url, Callback cb);

    @GET("/sample/posting")
    JsonArray getAllContents();


}

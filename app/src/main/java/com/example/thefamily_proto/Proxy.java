package com.example.thefamily_proto;


import retrofit.RestAdapter;

public class Proxy {
    public static String SERVER_URL = "http://54.64.239.231:8080";
    private RestAdapter restAdapter;
    private TheFamilyService service;

    public Proxy(){
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(SERVER_URL)
                .build();

        service = restAdapter
                .create(TheFamilyService.class);

    }

    public String getAllContents(){
        return service.getAllContents().toString();
    }



}

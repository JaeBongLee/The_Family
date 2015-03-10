package com.example.thefamily_proto;

public class Post {
    private int id;
    private String date;
    private String picUrl;
    private String text;
    private String type;
    private String user_id;
    private String family_id;

    public Post(int id, String date, String picUrl, String text, String type, String user_id, String family_id){
        this.id = id;
        this.date = date;
        this.picUrl = picUrl;
        this.text = text;
        this.type = type;
        this.user_id = user_id;
        this.family_id = family_id;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getFamily_id() {
        return family_id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", user_id='" + user_id + '\'' +
                ", family_id='" + family_id + '\'' +
                '}';
    }
}

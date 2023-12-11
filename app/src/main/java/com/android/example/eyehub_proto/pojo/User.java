package com.android.example.eyehub_proto.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class User {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("emailaddress")
    @Expose
    private String emailaddress;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("score")
    @Expose
    private int score;
    @SerializedName("challenges")
    @Expose
    private List<String> challenges = new ArrayList<>();

    public User(String id, String emailaddress, String name, String lastName,
                String password, int score, List<String> challenges) {
        this.id = id;
        this.emailaddress = emailaddress;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.score = score;
        this.challenges = challenges;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<String> challenges) {
        this.challenges = challenges;
    }
}

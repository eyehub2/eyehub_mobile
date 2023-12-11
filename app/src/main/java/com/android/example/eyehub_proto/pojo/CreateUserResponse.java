package com.android.example.eyehub_proto.pojo;

import com.google.gson.annotations.SerializedName;

public class CreateUserResponse {

    @SerializedName("name")
    public String name;

    @SerializedName("_id")
    public String id;
    @SerializedName("createdAt")
    public String createdAt;
}

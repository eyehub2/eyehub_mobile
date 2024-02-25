package com.android.example.eyehub_proto;

import com.android.example.eyehub_proto.pojo.MultipleResource;
import com.android.example.eyehub_proto.pojo.ResponsePost;
import com.android.example.eyehub_proto.pojo.User;
import com.android.example.eyehub_proto.pojo.UserData;
import com.android.example.eyehub_proto.pojo.UserList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

interface APIInterface {

    @GET("/get-user/{username}")
    Call<UserData> getUser(@Path("username") String username);

}

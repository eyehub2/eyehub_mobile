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

    @GET("/api/users/{uid}")
    Call<UserData> getUser(@Path("uid") String uid);

    @POST("/api/users")
    Call<ResponsePost> postScore(@Body ResponsePost responsePost);

    @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") String page);

    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);

}

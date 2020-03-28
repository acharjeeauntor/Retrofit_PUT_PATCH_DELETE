package com.auntor.retrofitjsonpractice;

import com.auntor.retrofitjsonpractice.JsonPlaceholder.CreateUserClass;
import com.auntor.retrofitjsonpractice.Response.MainResponseObjectClass;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface OurRetrofitClient {

    //TODO:Use For Fake JSON

    @POST("q")
    Call<MainResponseObjectClass> getPostValue(@Body MainObjectClass mainObjectClass);



//TODO:USe FOr jsonplaceholder create user

    @FormUrlEncoded
@POST("posts")
Call<CreateUserClass> CreateUser(
        @Field("userId") int userId,
        @Field("title") String title,
        @Field("body") String body
    );

}

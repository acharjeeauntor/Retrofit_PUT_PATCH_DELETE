package com.auntor.retrofitjsonpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.auntor.retrofitjsonpractice.JsonPlaceholder.CreateUserClass;
import com.auntor.retrofitjsonpractice.Response.MainResponseObjectClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    OurRetrofitClient ourRetrofitClient;
    LastLoginObject lastLoginObject;
    dataObjectClass dataObjectClass;
    MainObjectClass mainObjectClass;
    private static final String TOKEN = "62-D9fQTdy4glnF9kkDF_A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //TODO:USE For Fakejsondata

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://app.fakejson.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        lastLoginObject = new LastLoginObject("dateTime|UNIX", "172.242.228.245");
//        dataObjectClass = new dataObjectClass("555", "internetEmail", "personGender", "name", lastLoginObject);
//        mainObjectClass = new MainObjectClass(TOKEN,dataObjectClass);
//
//        ourRetrofitClient = retrofit.create(OurRetrofitClient.class);
//        Call<MainResponseObjectClass> res  = ourRetrofitClient.getPostValue(mainObjectClass);
//
//        res.enqueue(new Callback<MainResponseObjectClass>() {
//            @Override
//            public void onResponse(Call<MainResponseObjectClass> call, Response<MainResponseObjectClass> response) {
//                if (response.isSuccessful()){
//                    String email = response.body().getEmail();
//                    String name =response.body().getName();
//                    String gender =response.body().getGender();
//                    String id =    response.body().getId();
//                    LastLoginObject object = response.body().getLast_login();
//
//                    String time = object.getDate_time();
//                    String ip =object.getIp4();
//
//                    Log.d("name",name);
//                    Log.d("email",email);
//                    Log.d("gender",gender);
//                    Log.d("Id",id);
//                    Log.d("time",time);
//                    Log.d("ip",ip);
//
//                }else{
//                    Log.d("response","Fail");
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MainResponseObjectClass> call, Throwable t) {
//                Log.d("response","Fail");
//            }
//        });


        //TODO:USE for jsonplaceholder

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ourRetrofitClient = retrofit.create(OurRetrofitClient.class);

      Call<CreateUserClass>  call =  ourRetrofitClient.CreateUser(101,"JsonplaceHolder","This is practice for jsonplaceholder");
call.enqueue(new Callback<CreateUserClass>() {
    @Override
    public void onResponse(Call<CreateUserClass> call, Response<CreateUserClass> response) {
        if(response.isSuccessful()){

            Log.d("title",response.body().getTitle());
            Log.d("body",response.body().getBody());
            Log.d("userId", String.valueOf(response.body().getUserId()));

        }else{
            Log.d("response","Fail");

        }
    }

    @Override
    public void onFailure(Call<CreateUserClass> call, Throwable t) {
Log.d("response","Fail");
    }
});

    }
}

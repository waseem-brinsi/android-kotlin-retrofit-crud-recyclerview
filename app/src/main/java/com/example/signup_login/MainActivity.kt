package com.example.signup_login

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wassimUser =User(id = null,name = "ahmed",email="ahmed@gmail.com", gender = "male",status = "active")

        val Retrofit = RetrofitInstance.getRetrofit()
        val RetService : RetroService = Retrofit.create(RetroService::class.java)
        var postuser : RetroService = Retrofit.create(RetroService::class.java)

        println("===============resault================")
        val resault = RetService.getUsersList()
        resault.enqueue(object :Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                Log.d("resault", response.body().toString())
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                t.printStackTrace()
            }
        }).toString()

        var posted =  postuser.createUser(wassimUser)
        posted.enqueue(object :Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if(response.isSuccessful){
                    Log.d("resault", response.body().toString())
                }

            }
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                t.printStackTrace()
            }
        }).toString()
    }

}



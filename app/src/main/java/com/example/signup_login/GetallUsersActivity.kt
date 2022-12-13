package com.example.signup_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetallUsersActivity : AppCompatActivity() {
    var btnBackGetusersToMain:Button? = null
    var btnSearch:Button? = null
    var etSearchUser:EditText? = null
    var name:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getall_users)

        val retrofit = RetrofitInstance.getRetrofit()
        val retService : RetroService = retrofit.create(RetroService::class.java)

        //allusers
        var resault = retService.getUsersList()
        resault.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                println("===============resault get================")
                Log.d("resault", response.body().toString())
                val adapter = UserAdaptor(response.body())
                val rvUsers: RecyclerView? = findViewById(R.id.rvUsers)
                rvUsers?.adapter = adapter
                rvUsers?.layoutManager = LinearLayoutManager(this@GetallUsersActivity)
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                t.printStackTrace()
            }
        })

        //Button Search -- users by name

        etSearchUser = findViewById(R.id.etSearchUser)
        btnSearch = findViewById(R.id.btnSearch)
        btnSearch?.setOnClickListener {
            var name = etSearchUser?.text.toString()
            retService.searchUser(name).enqueue(object : Callback<List<User>>{
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    if (response.isSuccessful){
                        Log.d("resault",response.body().toString())
                    }
                }
                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    t.message
                }
            })
        }

        //Button Back
        btnBackGetusersToMain = findViewById(R.id.btnBackGetusersToMain)
        btnBackGetusersToMain?.setOnClickListener {
            Intent(this,GetallUsersActivity::class.java).also {
                finish()
            }
        }


    }
}
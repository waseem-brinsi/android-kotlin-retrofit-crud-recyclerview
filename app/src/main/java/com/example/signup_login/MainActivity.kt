package com.example.signup_login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    //properties
    private var btnSignup:Button? = null
    private var btnLoginMain:Button? = null
    private var btnGetallUser:Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)







        //Button
        btnGetallUser = findViewById(R.id.btnGetallUser)
        btnGetallUser?.setOnClickListener {
            Intent(this,GetallUsersActivity::class.java).also {
                startActivity(it)
            }
        }


        btnSignup = findViewById(R.id.btnSignup)
        btnSignup?.setOnClickListener {
            Intent(this,SignupActivity::class.java).also{
                startActivity(it)
            }
        }

        btnLoginMain = findViewById(R.id.btnLoginMain)
        btnLoginMain?.setOnClickListener {
            Intent(this,LoginActivity::class.java).also{
                startActivity(it)
            }
        }
    }

}



package com.example.myhello

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.Settings.Global.putString
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvUserName.setOnClickListener {
            val input = editText.text.toString().trim()
            if (input.isEmpty()) {
                Toast.makeText(baseContext, "Please fill out this field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

        }


        tvPassword.setOnClickListener {
            val input = editText.text.toString().trim()
            if (input.isEmpty()) {
                Toast.makeText(baseContext, "Please fill out this field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
          fetchCourses()
        }
    }

        fun fetchCourses() {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
            val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")


            editor.apply {
                putString("ACCESS_TOKEN_KEY", " ")

            }.apply()
            Toast.makeText(this, "Login data available", Toast.LENGTH_SHORT).show()


            val apiClient = ApiClient.buildService(ApiInterface::class.java)
            val loginCall = apiClient.getLogin("Bearer " + accessToken)
            loginCall.enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        var loginList = response.body()?.login as List<Login>

                    } else {
                        Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                            .show()
                    }
                }
            })
        }
    }




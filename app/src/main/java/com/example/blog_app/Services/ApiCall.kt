package com.example.blog_app.Services

import android.content.Context
import com.example.blog_app.Data.BlogData
import retrofit.Call
import retrofit.Callback
import retrofit.GsonConverterFactory
import retrofit.Response
import retrofit.Retrofit

class ApiCall {
    // This function takes a Context and callback function
    // as a parameter, which will be called
    // when the API response is received.
    fun getBlog(context: Context, callback: (BlogData) -> Unit) {

        // Create a Retrofit instance with the base URL and
        // a GsonConverterFactory for parsing the response.
        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://api.realworld.io/").addConverterFactory(
            GsonConverterFactory.create()).build()
        val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)

        val call: Call<BlogData> = service.getBlog()

        // Use the enqueue() method of the Call object to
        // make an asynchronous API request.
        call.enqueue(object : Callback<BlogData> {
            // This is an anonymous inner class that implements the Callback interface.
            override fun onResponse(response: Response<BlogData>?, retrofit: Retrofit?) {
                // This method is called when the API response is received successfully.

                if(response!!.isSuccess){
                    // If the response is successful, parse the
                    // response body to a DataModel object.
                    val blogs: BlogData = response.body() as BlogData

                    // Call the callback function with the DataModel
                    // object as a parameter.
                    callback(blogs)
                }
            }

            override fun onFailure(t: Throwable?) {

            }
        })
    }
}
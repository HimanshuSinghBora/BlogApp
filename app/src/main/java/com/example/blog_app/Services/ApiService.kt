package com.example.blog_app.Services

import com.example.blog_app.Data.BlogData
import retrofit.Call
import retrofit.http.GET

// This interface defines an API
// service for getting random jokes.
interface ApiService {
    // This annotation specifies that the HTTP method
    // is GET and the endpoint URL is "jokes/random".
    @GET("api/articles")
    // This method returns a Call object with a generic
    // type of DataModel, which represents
    // the data model for the response.
    fun getBlog(): Call<BlogData>

}
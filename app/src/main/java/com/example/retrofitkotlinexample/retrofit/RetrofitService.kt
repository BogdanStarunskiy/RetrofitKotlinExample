package com.example.retrofitkotlinexample.retrofit

import com.example.retrofitkotlinexample.model.CommentModel
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("./comments")
    fun getCommentsList(): Call<CommentModel>
}
package com.example.retrofitkotlinexample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitkotlinexample.model.CommentModel
import com.example.retrofitkotlinexample.retrofit.RetrofitInstance
import com.example.retrofitkotlinexample.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {
    val itemList = MutableLiveData<CommentModel>()

    fun getDataFromServer() {
        val retrofit = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
        retrofit.getCommentsList().enqueue(object: Callback<CommentModel>{
            override fun onResponse(call: Call<CommentModel>, response: Response<CommentModel>) {
                val dataFromServer = response.body()
                itemList.postValue(dataFromServer)
            }

            override fun onFailure(call: Call<CommentModel>, t: Throwable) {
                itemList.postValue(null)
            }

        })
    }

    fun getItemList(): LiveData<CommentModel>{
        return itemList
    }
}
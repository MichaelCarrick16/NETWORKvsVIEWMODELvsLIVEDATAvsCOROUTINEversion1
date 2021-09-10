package com.example.networkvsmvvmvscoroutine

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse
import java.lang.Exception

class MainViewModel : ViewModel() {

    val image : MutableLiveData<Image> by lazy {
        MutableLiveData<Image>()
    }

    fun getData(context: Context){
        viewModelScope.launch(Dispatchers.IO) {
        try {
            val response = RetrofitInstance.api.getImage().awaitResponse()
            if (response.isSuccessful) {
                var data = response.body()

                withContext(Dispatchers.Main) {
                    image.value = data
                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
                }
            }
        }catch (e : Exception){
            withContext(Dispatchers.Main){
                Toast.makeText(context,"Seems like something",Toast.LENGTH_SHORT).show()
            }
        }


//            Cach 2 :
//            RetrofitInstance.api.getImage().enqueue(object : Callback<Image>{
//                override fun onResponse(call: Call<Image>, response: Response<Image>) {
//                    var imageDefault = response.body()
//                    image.value = imageDefault
//                }
//
//                override fun onFailure(call: Call<Image>, t: Throwable) {
//                    Toast.makeText(context,"Fail",Toast.LENGTH_SHORT)
//                }
//            })




        }
    }


}
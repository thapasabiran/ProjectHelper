package com.example.myweatherapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.RequestBody
import java.lang.Exception

class BookViewModel(private val repo: Repository): ViewModel() {
    var currentWeather = MutableLiveData<Weather>()
    var job: Job? = null

    fun getCurrentWeather() {
        job = CoroutineScope(Dispatchers.IO).launch {
            try {

                var res = repo.getCurrentWeather()
                if(res.isSuccessful) {
                    currentWeather.postValue(res.body())
                }
            } catch (e: Exception) {
                println(e)
            }
        }
    }

//    fun postBook() {
//        job = CoroutineScope(Dispatchers.IO).launch {
//            var res = repo.postBook(requestBody)
//            if(res.isSuccessful) {
//                println("Post method was successful!")
//                println(res.body())
//            } else {
//                println("Post method encounter some exception!")
//            }
//        }
//    }
}
class MyViewModel {
}
package com.example.myweatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfirstretrofit.RetroApiInterface
import com.example.myweatherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var vm: BookViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intrf = RetroApiInterface.create()
        val repo = Repository(intrf)
        vm = BookViewModel(repo)

        vm.getCurrentWeather()

        binding.welcomeContinueButton.setOnClickListener {
            val myActivity2Intent = Intent(this, MainActivity2::class.java)
            startActivity(myActivity2Intent)
        }
    }
}
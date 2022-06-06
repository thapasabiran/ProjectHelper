package com.example.myweatherapp

data class Weather(
    val location: Location
)

data class Location(
    var name: String,
    var region: String,
    var country: String,
    var lat: Float,
    var lon: Float,
    var tz_id: String,
    var localtime_epoch: Long,
    var localtime: String
)

package com.jathowweather.android.logic.model

data class Weather(val realTime: RealtimeResponse.RealTime, val daily: DailyResponse.Daily)

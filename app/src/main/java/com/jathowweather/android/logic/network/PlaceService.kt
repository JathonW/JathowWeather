package com.jathowweather.android.logic.network

import com.jathowweather.android.JathowWeatherApplication
import com.jathowweather.android.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {

    //只有一个可变数据,用@Query标识
    // Retrofit会将json自动转换成PlaceResonse
    @GET("v2/place?token=${JathowWeatherApplication.Token}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
    //java写法
    /*
     区别 一 kotlin 避免了空指针 二 get可以直接使用$(JathowWeatherApplication.Token
     @GET("v2/place?token=o0QcCVv2NVhVkr48&lang=zh_CN")
     @NotNull
     Call searchPlaces(@Query("query") @NotNull String var1);
     */
}
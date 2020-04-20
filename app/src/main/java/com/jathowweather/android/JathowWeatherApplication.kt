package com.jathowweather.android

import android.app.Application
import android.content.Context

/**
 * 全局获取context的方法
 */
class JathowWeatherApplication: Application() {

    companion object {
        const val Token = "o0QcCVv2NVhVkr48"
        //获取Application的Context,全局知存在一个实例,故可以忽略警告
        @SuppressWarnings("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}
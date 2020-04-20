package com.jathowweather.android.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 创建AppService的动态代理对象
 */
object ServiceCreator {

    private  const val BASE_URL = "https://api.caiyunapp.com/"

    //Retrofit全局通用 故用单例模式
    //需要设置转化格式
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    //泛型实话
    inline fun <reified T> create(): T = create(T::class.java)

    /*
    java 实现
     private static final String BASE_URL = "https://api.caiyunapp.com/";
   private static final Retrofit retrofit;
   public static final ServiceCreator INSTANCE;

   public final Object create(@NotNull Class serviceClass) {
      Intrinsics.checkParameterIsNotNull(serviceClass, "serviceClass");
      return retrofit.create(serviceClass);
   }

   // $FF: synthetic method
   public final Object create() {
      int $i$f$create = 0;
      Intrinsics.reifiedOperationMarker(4, "T");
      return this.create(Object.class);
   }

   private ServiceCreator() {
   }

   static {
      ServiceCreator var0 = new ServiceCreator();
      INSTANCE = var0;
      retrofit = (new Builder()).baseUrl("https://api.caiyunapp.com/").addConverterFactory((Factory)GsonConverterFactory.create()).build();
   }
     */
}
package br.com.coroutines.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private val BASE_URL = "https://api.github.com/"
private var retrofitOption: Retrofit? = null


fun gitHubApi():GitHubApi{
    if(retrofitOption == null){
        initRetrofit()
    }

    return retrofitOption!!.create(GitHubApi::class.java)
}

private fun initRetrofit(){

    retrofitOption = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .build()
}
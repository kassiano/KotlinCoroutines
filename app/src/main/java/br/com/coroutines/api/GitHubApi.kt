package br.com.coroutines.api

import br.com.coroutines.model.Repository
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("/users/{username}/repos")
    fun getRepositories(@Path("username") username:String) : Deferred<List<Repository>>

    @GET("/users/{username}/repos")
    fun getRepositoriesRx(@Path("username") username:String) : Observable<List<Repository>>
}

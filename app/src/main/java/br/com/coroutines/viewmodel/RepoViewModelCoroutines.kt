package br.com.coroutines.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.coroutines.api.gitHubApi
import br.com.coroutines.model.Repository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class RepoViewModelCoroutines: ViewModel(), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main


    val repositories = MutableLiveData<List<Repository>>()

    fun getRepositories(){

        launch(Dispatchers.Main) {
            val repos : List<Repository> = fetchRepositories().await()
            repositories.value = repos
        }

    }


    private fun fetchRepositories(): Deferred<List<Repository>>{
        return gitHubApi().getRepositories("kassiano")
    }

}
package br.com.coroutines.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.coroutines.api.gitHubApi
import br.com.coroutines.model.Repository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers


class RepoViewModelRx: ViewModel() {


    val disposables = CompositeDisposable()

    val repositories = MutableLiveData<List<Repository>>()


    fun getRepositories(){

        fetchRepositories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {

                repositories.value = it

            }.addTo(disposables)

    }


    private fun fetchRepositories(): Observable<List<Repository>> {
       return gitHubApi().getRepositoriesRx("kassiano")
    }

}
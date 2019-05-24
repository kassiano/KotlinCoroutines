package br.com.coroutines.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import br.com.coroutines.R
import br.com.coroutines.viewmodel.RepoViewModelCoroutines
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val repoAdapter = RepositoryAdapter()

    val viewmodel by lazy {
        ViewModelProviders.of(this)
            .get(RepoViewModelCoroutines::class.java)
            //.get(RepoViewModelRx::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvRepositories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvRepositories.adapter = this.repoAdapter
    }

    override fun onResume() {
        super.onResume()
        viewmodel.getRepositories()
        updateUI()
    }

    private fun updateUI() {
        viewmodel.repositories.observe(this, Observer {
            it?.let {
                repos->
                repoAdapter.setItems(repos)
            }
        })
    }

}

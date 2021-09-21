package com.kalinews.app.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.kalinews.app.R
import com.kalinews.app.databinding.ActivityMainBinding
import com.kalinews.app.db.ArticleDatabase
import com.kalinews.app.repository.NewsRepository

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    lateinit var viewModel: NewsViewModel
    companion object{
        private const val TAG = "MainActivity"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val repository = ArticleDatabase(this)?.let { NewsRepository(it) }
        Log.d("TAG", "onCreate:repository  $repository")
        val viewModelProviderFactory = repository?.let { NewsViewModelProviderFactory(it) }
        Log.d("TAG", "onCreate:viewModelProviderFactory $viewModelProviderFactory")
        viewModel = ViewModelProvider(this,viewModelProviderFactory!!).get(NewsViewModel::class.java)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        binding?.apply {
            bottomNavigationView.setupWithNavController(navController)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null;
    }
}
package com.kalinews.app.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.kalinews.app.R
import com.kalinews.app.databinding.FragmentArticleBinding
import com.kalinews.app.ui.MainActivity
import com.kalinews.app.ui.NewsViewModel


class ArticleFragment : Fragment(R.layout.fragment_article) {

    private var binding: FragmentArticleBinding? = null
    val args: ArticleFragmentArgs by navArgs()
    lateinit var viewModel:NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel

        val article = args.article
        binding?.apply {
            webView.apply {
                webViewClient = WebViewClient()
                loadUrl(article.url)
            }
        }

        binding?.fab?.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view,"Article saved successfully",Snackbar.LENGTH_SHORT).show()
        }
    }
}
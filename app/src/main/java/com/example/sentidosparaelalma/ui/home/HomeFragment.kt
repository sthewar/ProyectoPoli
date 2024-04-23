package com.example.sentidosparaelalma.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.sentidosparaelalma.R
import com.example.sentidosparaelalma.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val URL_Base = "https://www.google.com"
    private val SEARCH_PATH = "/search?q="

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // WebView
        val myWebView: WebView = binding.webViewID
        val mySearch : SearchView = binding.mySearchView

        mySearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(p0: String?): Boolean {

                p0?.let {
                    if(URLUtil.isValidUrl(it)) {
                        // Es una url
                        myWebView.loadUrl(it)
                    } else {
                        // No es una url
                        myWebView.loadUrl("$URL_Base$SEARCH_PATH$it")
                    }
                }

                return false
            }

        })


        myWebView.webChromeClient = object : WebChromeClient() {

        }

        myWebView.webViewClient = object : WebViewClient() {

        }

        val settings: WebSettings = myWebView.settings
        settings.javaScriptEnabled = true

        myWebView.loadUrl(URL_Base)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
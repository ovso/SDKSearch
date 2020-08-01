package io.github.ovso.sdksearch.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import io.github.ovso.sdksearch.R
import io.github.ovso.sdksearch.ui.main.Log
import io.github.ovso.sdksearch.ui.main.MainActivity
import timber.log.Timber

typealias TLog = Timber

class HomeFragment : Fragment(), MainActivity.OnSearchListener {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        textView.isClickable = true
        return root
    }

    override fun onPause() {
        super.onPause()
        TLog.d("onPause()")
    }

    override fun onStop() {
        super.onStop()
        TLog.d("onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        TLog.d("onDestroy()")
    }

    override fun onSearch(text: CharSequence) {
        Log.d("onSearch = $text")
    }
}
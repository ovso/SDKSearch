package io.github.ovso.sdksearch.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.orhanobut.logger.Logger
import io.github.ovso.sdksearch.R
import io.github.ovso.sdksearch.base.DataBindingActivity
import io.github.ovso.sdksearch.databinding.ActivityMainBinding
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import timber.log.Timber


typealias Log = Logger
typealias TLog = Timber

class MainActivity : DataBindingActivity() {

    private val binding by binding<ActivityMainBinding>(R.layout.activity_main)
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
        supportActionBar?.hide()
        val navController = findNavController(R.id.nav_host_fragment)
        navController.addOnDestinationChangedListener(viewModel::onDestinationChanged)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
        observer()

        Thread{
            val doc: Document = Jsoup.connect("https://kotlinlang.org/?q=loop&p=0").timeout(1000*60).get()
            doc.body()
        }.start()
    }

    private fun observer() {
        fun getCurrentFragment(): Fragment? {
            return supportFragmentManager
                .primaryNavigationFragment
                ?.childFragmentManager
                ?.fragments?.first()
        }
        viewModel.searchText.observe(this, Observer { text ->
            (getCurrentFragment() as? OnSearchListener)?.onSearch(text)
        })
    }

    private fun performDataBinding() {
        binding.also {
            it.viewModel = viewModel
            it.lifecycleOwner = this
            it.executePendingBindings()
        }
    }

    interface OnSearchListener {
        fun onSearch(text: CharSequence)
    }
}
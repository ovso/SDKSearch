package io.github.ovso.sdksearch.initializer

import android.content.Context
import androidx.startup.Initializer
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import io.github.ovso.sdksearch.BuildConfig
import timber.log.Timber


class LoggerInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        Logger.addLogAdapter(object : AndroidLogAdapter() {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
        Timber.d("LoggerInitializer is initialized.")
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}

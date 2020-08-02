package io.github.ovso.sdksearch.data

import io.github.ovso.sdksearch.ui.main.Log
import okhttp3.Interceptor
import okhttp3.Response

class HttpRequestInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val originalRequest = chain.request()
    val request = originalRequest.newBuilder().url(originalRequest.url).build()
    Log.d(request.toString())
    return chain.proceed(request)
  }
}
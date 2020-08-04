package io.github.ovso.sdksearch.data

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import okio.Buffer
import java.nio.charset.Charset
import java.util.concurrent.TimeUnit


object OkHttpClientProvider {
  val okHttpClient: OkHttpClient

  init {
    okHttpClient = createClient()
  }

  private fun createClient(): OkHttpClient {
    val httpClient = OkHttpClient.Builder()
    httpClient.readTimeout(
      TIMEOUT_SECONDS.toLong(),
      TimeUnit.SECONDS
    )
    httpClient.connectTimeout(
      TIMEOUT_SECONDS.toLong(),
      TimeUnit.SECONDS
    )
    httpClient.addInterceptor(
      Interceptor { chain: Interceptor.Chain ->
        val builder =
          chain.request().newBuilder().header("Content-Type", "application/json")
        chain.proceed(builder.build())
      }
    )
    httpClient.addInterceptor(
      HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    )
    httpClient.addInterceptor(MyInterceptor())
    return httpClient.build()
  }

  class MyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
      val response = chain.proceed(chain.request())
      println(response.request.url.toUri().path)
      val source = response.body!!.source()
      source.request(Long.MAX_VALUE) // Buffer the entire body.

      val buffer: Buffer = source.buffer()
      val responseBodyString: String = buffer.clone().readString(Charset.forName("UTF-8"))
      println(responseBodyString)
      return response
    }

  }
  private const val TIMEOUT_SECONDS = 60
}

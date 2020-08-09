package io.github.ovso.sdksearch.data

import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteDataSource {
    private const val BASE_URL = "https://7961pkyrxv-dsn.algolia.net"

    private fun api(): KotlinService {
        return createRetrofit().create(KotlinService::class.java)
    }

    fun searchKotlin(k: KotlinReq): Single<KotlinResponse> {
        return api().searchKotlin(k)
    }

    fun searchAndroid(q: String): Single<Any> {
        return api().searchAndroid(q)
    }

    private fun createRetrofit(): Retrofit {

        OkHttpClientProvider.okHttpClient
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(OkHttpClientProvider.okHttpClient)
            .build()
    }

}

package io.github.ovso.sdksearch.data

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteDataSource {
    private const val BASE_URL = "https://kotlinlang.org/"

    private fun api(): KotlinService {
        return createRetrofit().create(KotlinService::class.java)
    }

    fun searchKotlin(q: String): Single<Any> {
        return api().searchKotlin(q)
    }

    fun searchAndroid(q: String): Single<Any> {
        return api().searchAndroid(q)
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(OkHttpClientProvider.okHttpClient)
            .build()
    }

}

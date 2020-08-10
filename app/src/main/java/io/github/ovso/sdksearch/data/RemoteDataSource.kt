package io.github.ovso.sdksearch.data

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit

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
//            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(OkHttpClientProvider.okHttpClient)
            .build()
    }

}

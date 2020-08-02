package io.github.ovso.sdksearch.data

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface KotlinService {
    @GET("")
    fun searchKotlin(
        @Query("q") q: String
    ): Single<Any>

    @GET("")
    fun searchAndroid(q: String): Single<Any>
}
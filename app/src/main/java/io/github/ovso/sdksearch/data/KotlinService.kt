package io.github.ovso.sdksearch.data

import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface KotlinService {
    @Headers(
        "Accept: application/json",
        "Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.5,en;q=0.3",
        "Accept-Encoding: gzip, deflate, br",
        "content-type: application/x-www-form-urlencoded",
        "Content-Length: 102",
        "Origin: https://kotlinlang.org",
        "Connection: keep-alive",
        "Referer: https://kotlinlang.org/?q=loop&p=0"
    )
    @POST("/1/indexes/*/queries?x-algolia-application-id=7961PKYRXV&x-algolia-api-key=604fa45d89af86bdf9eed4cc862b2d0b")
    fun searchKotlin(
        @Body k: KotlinReq
    ): Single<KotlinResponse>

    @GET("")
    fun searchAndroid(q: String): Single<Any>
}
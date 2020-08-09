package io.github.ovso.sdksearch.data

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
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

/*

/*

POST /1/indexes/*/queries?x-algolia-agent=Algolia%20for%20JavaScript%20(3.35.1)%3B%20Browser%20(lite)%3B%20instantsearch.js%202.0.2%3B%20JS%20Helper%20(2.28.1)&x-algolia-application-id=7961PKYRXV&x-algolia-api-key=604fa45d89af86bdf9eed4cc862b2d0b HTTP/1.1
Host: 7961pkyrxv-dsn.algolia.net
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:78.0) Gecko/20100101 Firefox/78.0
Accept: application/json
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.5,en;q=0.3
Accept-Encoding: gzip, deflate, br
content-type: application/x-www-form-urlencoded
Content-Length: 102
Origin: https://kotlinlang.org
Connection: keep-alive
Referer: https://kotlinlang.org/?q=loop&p=0

 */

 */
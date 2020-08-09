package io.github.ovso.sdksearch.data

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import io.reactivex.rxjava3.core.Single
import okhttp3.ResponseBody
import retrofit2.Response

interface TaskDataSource {
    fun searchKotlin(q: String): Single<KotlinResponse>
    fun searchAndroid(q: String): Single<Any>
}

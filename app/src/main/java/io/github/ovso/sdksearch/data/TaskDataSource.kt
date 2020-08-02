package io.github.ovso.sdksearch.data

import io.reactivex.rxjava3.core.Single

interface TaskDataSource {
    fun searchKotlin(q: String): Single<Any>
    fun searchAndroid(q: String): Single<Any>
}

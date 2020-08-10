package io.github.ovso.sdksearch.data

import io.reactivex.rxjava3.core.Single

class MainRepository(private val remoteDataSource: RemoteDataSource) : TaskDataSource {
    override fun searchKotlin(q: String): Single<KotlinResponse> {
        return remoteDataSource.searchKotlin(
            KotlinReq(
                listOf(Request("prod_KOTLINLANG", "query=loops&page=0&facets=%5B%5D"))
            )
        )
    }

    override fun searchAndroid(q: String): Single<Any> {
        return remoteDataSource.searchAndroid(q)
    }
}
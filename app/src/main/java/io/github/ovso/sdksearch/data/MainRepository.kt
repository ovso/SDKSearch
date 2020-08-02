package io.github.ovso.sdksearch.data

import io.reactivex.rxjava3.core.Single

class MainRepository(private val remoteDataSource: RemoteDataSource) : TaskDataSource {
    override fun searchKotlin(q: String): Single<Any> {
        return remoteDataSource.searchKotlin(q)
    }

    override fun searchAndroid(q: String): Single<Any> {
        return remoteDataSource.searchAndroid(q)
    }
}
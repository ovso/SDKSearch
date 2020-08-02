package io.github.ovso.sdksearch

import io.github.ovso.sdksearch.data.MainRepository
import io.github.ovso.sdksearch.data.RemoteDataSource
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class KotlinUnitTest {


    @Test
    fun test() {
        val repository = MainRepository(RemoteDataSource)
        repository
            .searchKotlin("loop")
            .subscribeOn(Schedulers.trampoline())
            .observeOn(Schedulers.trampoline())
            .subscribe({
                println(it.toString())
            }, {
                it.printStackTrace()
            })
    }
}
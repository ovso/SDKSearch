package io.github.ovso.sdksearch

import com.google.gson.Gson
import com.google.gson.JsonElement
import io.github.ovso.sdksearch.data.MainRepository
import io.github.ovso.sdksearch.data.RemoteDataSource
import io.reactivex.rxjava3.schedulers.Schedulers
import okio.internal.commonToUtf8String
import org.junit.Test
import retrofit2.HttpException

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
                val httpException = it as? HttpException
                println(httpException?.message())
                println(httpException?.code())
                println(httpException?.response())
                println(httpException?.response()?.body())
                println(httpException?.response()?.message())
                println(httpException?.response()?.code())
                println(httpException?.response()?.errorBody()?.string())
                println(httpException?.response()?.raw()?.body?.string())
            })
    }

}
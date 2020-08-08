package io.github.ovso.sdksearch

import com.google.gson.Gson
import com.google.gson.JsonElement
import io.github.ovso.sdksearch.data.MainRepository
import io.github.ovso.sdksearch.data.RemoteDataSource
import io.reactivex.rxjava3.schedulers.Schedulers
import okio.internal.commonToUtf8String
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.junit.Test
import retrofit2.HttpException

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class JsoupUnitTest {


    @Test
    fun test() {
        val doc: Document =
            Jsoup.connect("https://kotlinlang.org/?q=loop&p=0").timeout(1000 * 60).get()
        val body = doc.body()
        val select = body.select("div[data-reactroot]")
        println("end")
    }

}
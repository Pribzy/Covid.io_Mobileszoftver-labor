package hu.bme.aut.pribelszki.covidio.network

import hu.bme.aut.pribelszki.covidio.BuildConfig
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer

class MockNetworkInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (BuildConfig.DEBUG) {
            val uri = chain.request().url.toString()
            val method = chain.request().method

            return when {
                method == "POST" && uri.endsWith("cases") -> postNewCaseResponse(chain)
                method == "DELETE" && uri.contains("countries") -> okResponse(chain)
                else -> chain.proceed(chain.request())
            }
        } else {
            throw IllegalAccessError("MockInterceptor is only meant for Testing Purposes and " +
                    "bound to be used only with DEBUG mode")
        }
    }

    private fun okResponse(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
                .newBuilder()
                .code(200)
                .protocol(Protocol.HTTP_2)
                .build()
    }

    private fun postNewCaseResponse(chain: Interceptor.Chain): Response {
        val buffer = Buffer()
        chain.request().body?.writeTo(buffer)
        return chain.proceed(chain.request())
                .newBuilder()
                .code(200)
                .protocol(Protocol.HTTP_2)
                .body(buffer.readUtf8().toByteArray().toResponseBody("application/json".toMediaTypeOrNull()))
                .addHeader("content-type", "application/json")
                .build()
    }

}
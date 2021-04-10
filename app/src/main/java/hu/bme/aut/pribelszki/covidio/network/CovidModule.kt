package hu.bme.aut.pribelszki.covidio.network

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class CovidModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(interceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.covid19api.com/")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideCovidApi(retrofit: Retrofit): CovidAPI = retrofit.create()

    @Provides
    @Singleton
    fun provideMockCovidApi(): MockCovidAPI = MockCovidAPIImpl()

    @Provides
    @Singleton
    fun provideMockNetworkInterceptor(): Interceptor = MockNetworkInterceptor()
}
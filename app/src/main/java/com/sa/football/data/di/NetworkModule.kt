package com.sa.football.data.di

import android.content.Context
import android.net.ConnectivityManager
import com.sa.football.data.utils.NetworkUtils
import com.sa.football.data.data_source.remote.FootballServices

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyStore
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager


@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {


    init {
        System.loadLibrary("native-lib")
    }
    private external fun getEncryptedBaseUrl(): String

    @Provides
    @Singleton
    fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Provides
    @Singleton
    fun provideNetworkUtils(connectivityManager: ConnectivityManager): NetworkUtils {
        return NetworkUtils(connectivityManager)
    }


    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Provides
    @Singleton
    fun provideHeadersInterceptor() =
        Interceptor { chain ->
            chain.proceed(
                chain.request().newBuilder()
                    .header("Accept" , "application/json")
                    .header("Accept-Language" , "en")
                    .build()
            )
        }


    @Provides
    @Singleton
    fun provideOkhttp(logging: HttpLoggingInterceptor, headersInterceptor: Interceptor): OkHttpClient {
        val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        trustManagerFactory.init(null as KeyStore?)
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, trustManagerFactory.trustManagers, null)

        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .addInterceptor(headersInterceptor)
            .sslSocketFactory(sslContext.socketFactory, trustManagerFactory.trustManagers[0] as X509TrustManager)
            .build()
    }



    @Provides
    @Singleton
    fun provideApi( okHttpClient: OkHttpClient ) : Retrofit =
        Retrofit.Builder()
            .baseUrl(getEncryptedBaseUrl())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit) : FootballServices =
        retrofit.create(FootballServices::class.java)


}
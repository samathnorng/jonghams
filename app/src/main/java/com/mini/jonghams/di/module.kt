package com.mini.jonghams.di


import com.mini.jonghams.viewModel.CommentViewModel
import com.mini.jonghams.viewModel.ProductViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/*val appModule = module {
    single { AppInterceptor() }
    single { createOkHttpClient(get()) }
    single { createWebService<AppServices>(get(), "https://api.myjson.com/") }
}*/

val dataModule = module {

    /* single { AppRepositoryImpl(get(), get()) as AppRepository }
     single { PetMapper() }
     single { ConfigResponse(get()) }*/

    viewModel { ProductViewModel() }

    viewModel { CommentViewModel() }

}

/*fun createOkHttpClient(interceptor: AppInterceptor): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    val timeout = 60L
    return OkHttpClient.Builder()
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(interceptor)
            .build()
}*/

/*inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create()

    val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
    return retrofit.create(T::class.java)
}*/

val myAppModule = listOf(dataModule)
package dev.whysoezzy.currencyapp.di

import android.content.Context
import android.content.SharedPreferences
import dev.whysoezzy.currencyapp.data.network.CurrencyApi
import dev.whysoezzy.currencyapp.data.repositoryImpl.CurrencyRepositoryImpl
import dev.whysoezzy.currencyapp.domain.repository.CurrencyRepository
import dev.whysoezzy.currencyapp.domain.use_cases.GetLatestCurrenciesUseCase
import dev.whysoezzy.currencyapp.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val mainModule = module {
    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.cbr-xml-daily.ru")
            .build()
            .create(CurrencyApi::class.java)

    }
    single<SharedPreferences> { androidApplication().getSharedPreferences("my_shared_prefs", Context.MODE_PRIVATE) }
    single<CurrencyRepository> { CurrencyRepositoryImpl(get()) }
    single { GetLatestCurrenciesUseCase(get()) }
    viewModel {parameters ->
        MainViewModel(get(), get())
    }
}
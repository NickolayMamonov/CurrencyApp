package dev.whysoezzy.currencyapp.presentation.main

import dev.whysoezzy.currencyapp.domain.model.CurrencyData

sealed class MainScreenState {
    data class Content(val valutes: List<CurrencyData>) : MainScreenState()

    data class Error(val th: Throwable) : MainScreenState()

    object Loading : MainScreenState()
}
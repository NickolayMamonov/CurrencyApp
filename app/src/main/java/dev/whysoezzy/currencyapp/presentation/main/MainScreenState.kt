package dev.whysoezzy.currencyapp.presentation.main

import dev.whysoezzy.currencyapp.data.entity.ValutesDTO

sealed class MainScreenState {
    data class Content(val valutes: List<ValutesDTO>): MainScreenState()

    data class Error(val th:Throwable): MainScreenState()

    object Loading: MainScreenState()
}
package dev.whysoezzy.currencyapp.domain.repository

import dev.whysoezzy.currencyapp.domain.model.CurrencyData

interface CurrencyRepository {

    suspend fun getData(): List<CurrencyData>
}
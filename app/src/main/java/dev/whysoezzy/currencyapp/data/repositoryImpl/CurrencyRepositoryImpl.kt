package dev.whysoezzy.currencyapp.data.repositoryImpl

import dev.whysoezzy.currencyapp.data.mapper.ResponseDTOMapper
import dev.whysoezzy.currencyapp.data.network.CurrencyApi
import dev.whysoezzy.currencyapp.domain.model.CurrencyData
import dev.whysoezzy.currencyapp.domain.repository.CurrencyRepository

class CurrencyRepositoryImpl(private val currencyApi: CurrencyApi) : CurrencyRepository {
    override suspend fun getData(): List<CurrencyData> {
        val response = currencyApi.getLatestCurrencies()
        return ResponseDTOMapper.fromTo(response)
    }
}
package dev.whysoezzy.currencyapp.data.repositoryImpl

import dev.whysoezzy.currencyapp.data.entity.ValutesDTO
import dev.whysoezzy.currencyapp.data.mapper.ResponseDTOMapper
import dev.whysoezzy.currencyapp.data.network.CurrencyApi
import dev.whysoezzy.currencyapp.domain.repository.CurrencyRepository

class CurrencyRepositoryImpl(private val currencyApi: CurrencyApi) : CurrencyRepository {
    override suspend fun getData(): List<ValutesDTO> {
        val response = currencyApi.getLatestCurrencies()
        return ResponseDTOMapper.fromTo(response)    }
}
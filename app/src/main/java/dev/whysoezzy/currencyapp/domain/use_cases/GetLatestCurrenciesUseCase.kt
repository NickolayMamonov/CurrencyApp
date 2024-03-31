package dev.whysoezzy.currencyapp.domain.use_cases

import dev.whysoezzy.currencyapp.domain.model.CurrencyData
import dev.whysoezzy.currencyapp.domain.repository.CurrencyRepository

class GetLatestCurrenciesUseCase(private val currencyRepository: CurrencyRepository) {
    suspend operator fun invoke(): List<CurrencyData> {
        return currencyRepository.getData()
    }
}
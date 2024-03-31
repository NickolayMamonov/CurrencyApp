package dev.whysoezzy.currencyapp.domain.repository

import dev.whysoezzy.currencyapp.data.entity.ValutesDTO

interface CurrencyRepository  {

    suspend fun getData() : List<ValutesDTO>
}
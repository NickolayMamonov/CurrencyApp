package dev.whysoezzy.currencyapp.domain.model

data class CurrencyData(
    val charCode: String,
    val name: String,
    val nominal: Int,
    val value: Double
)
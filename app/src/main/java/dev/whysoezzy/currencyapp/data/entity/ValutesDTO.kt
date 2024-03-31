package dev.whysoezzy.currencyapp.data.entity

data class ValutesDTO(
    val ID: String,
    val NumCode: String,
    val CharCode: String,
    val Nominal: Int,
    val Name: String,
    val Value: Double,
    val Previous: Double
)
package dev.whysoezzy.currencyapp.data.entity

data class ResponseDTO(
    val Date: String,
    val PreviousDate:String,
    val PreviousURL: String,
    val Timestamp: String,
    val Valute: Map<String,ValutesDTO>
)
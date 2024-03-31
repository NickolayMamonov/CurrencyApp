package dev.whysoezzy.currencyapp.data.mapper

import dev.whysoezzy.currencyapp.data.common.EntityMapper
import dev.whysoezzy.currencyapp.data.entity.ResponseDTO
import dev.whysoezzy.currencyapp.domain.model.CurrencyData

object ResponseDTOMapper : EntityMapper<ResponseDTO, List<CurrencyData>> {
    override fun fromTo(entity: ResponseDTO): List<CurrencyData> {
        return entity.Valute.entries.map { entry ->
            CurrencyData(
                name = entry.value.Name,
                charCode = entry.value.CharCode,
                nominal = entry.value.Nominal,
                value = entry.value.Value
            )
        }
    }
}
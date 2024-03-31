package dev.whysoezzy.currencyapp.data.mapper

import dev.whysoezzy.currencyapp.data.common.EntityMapper
import dev.whysoezzy.currencyapp.data.entity.ResponseDTO
import dev.whysoezzy.currencyapp.data.entity.ValutesDTO

object ResponseDTOMapper : EntityMapper<ResponseDTO, List<ValutesDTO>> {
    override fun fromTo(entity: ResponseDTO): List<ValutesDTO> {
        return entity.Valute.entries.map { entry ->
            ValutesDTO(
                ID = entry.value.ID,
                CharCode = entry.value.CharCode,
                NumCode = entry.value.NumCode,
                Nominal = entry.value.Nominal,
                Name = entry.value.Name,
                Value = entry.value.Value,
                Previous = entry.value.Previous
            )
        }
    }
}
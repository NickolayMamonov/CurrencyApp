package dev.whysoezzy.currencyapp.data.common

interface EntityMapper<From,To> {
    fun fromTo(entity: From): To
}
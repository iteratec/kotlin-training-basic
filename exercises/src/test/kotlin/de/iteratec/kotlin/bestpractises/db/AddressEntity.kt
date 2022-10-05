package de.iteratec.kotlin.bestpractises.db

import de.iteratec.kotlin.bestpractises.dto.AddressDto

class AddressEntity {
    var streetAndNumber: String? = null
    var postalCodeAndCity: String? = null
    var additionalInfo: String? = null

    fun toDto(): AddressDto {
        val (street, number) = streetAndNumber?.split(" ").let {
            val street = it?.take(it.size - 1)?.joinToString(separator = " ")
            val number = it?.last()?.toInt()
            street to number
        }
        val (postal, city) = postalCodeAndCity?.split(" ").let {
            val postal = it?.first()?.toInt()
            val city = it?.takeLast(it.size - 1)?.joinToString(separator = " ")
            postal to city
        }
        return AddressDto(
            street = street ?: "",
            number = number ?: 0,
            postalCode = postal ?: 0,
            city = city ?: "",
            additional = additionalInfo
        )
    }
}
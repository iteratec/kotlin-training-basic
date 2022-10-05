package de.iteratec.kotlin.bestpractises.solutions

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import de.iteratec.kotlin.bestpractises.solutions.dto.AddressDto
import de.iteratec.kotlin.bestpractises.solutions.db.AddressEntity


/**
 * # Extensions
 *
 * - add new functionality to 'not owned' classes
 * - reduce binding between packages
 */
fun main() {
    val dto = AddressDto(street = "Musterstraße", number = 21, postalCode = 12345, city = "Berlin", additional = null)

    val entity = dto.toEntity()

    val dto2 = entity.toDto()

    println("dto's equal ${dto == dto2}")
}

fun AddressEntity.toDto(): AddressDto {
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

fun AddressDto.toEntity(): AddressEntity {
    val entity = AddressEntity()

    entity.streetAndNumber = "$street $number"
    entity.postalCodeAndCity = "$postalCode $city"
    entity.additionalInfo = additional

    jacksonObjectMapper()
    return entity
}
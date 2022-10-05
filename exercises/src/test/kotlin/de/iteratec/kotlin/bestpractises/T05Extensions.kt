package de.iteratec.kotlin.bestpractises

import de.iteratec.kotlin.bestpractises.dto.AddressDto

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
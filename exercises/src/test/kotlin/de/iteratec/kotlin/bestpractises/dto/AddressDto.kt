package de.iteratec.kotlin.bestpractises.dto

import de.iteratec.kotlin.bestpractises.db.AddressEntity

data class AddressDto(val street: String, val number: Int, val postalCode: Int, val city: String, val additional: String?) {

    fun toEntity(): AddressEntity {
        val entity = AddressEntity()

        entity.streetAndNumber = "$street $number"
        entity.postalCodeAndCity = "$postalCode $city"
        entity.additionalInfo = additional

        return entity
    }
}

package me.dio.credit.application.system.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotEmpty(message = "invalid imput") val firstName: String,
    @field:NotEmpty(message = "invalid imput") val lastName: String,
    @field:NotNull(message = "invalid imput") val income: BigDecimal,
    @field:NotEmpty(message = "invalid imput") val zipCod: String,
    @field:NotEmpty(message = "invalid imput") val street: String
) {
    fun toEntity(customer: Customer): Customer{
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.street
        customer.address.zipCod = this.zipCod
        return customer
    }
}

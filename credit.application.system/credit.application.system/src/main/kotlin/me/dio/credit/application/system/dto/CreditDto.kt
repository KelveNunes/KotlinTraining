package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "invalid imput") val creditValue: BigDecimal,
    @field:Future(message = "invalid imput") val dayfirstInstallment: LocalDate,
    @field:NotEmpty(message = "invalid imput") val numberOfIntallment: Int,
    @field:NotNull(message = "invalid imput") val id: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayfirstInstallment = this.dayfirstInstallment,
        numberOfIntallment = this.numberOfIntallment,
        customer = Customer(id = this.id)
    )
}

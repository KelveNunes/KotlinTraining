package me.dio.credit.application.system.dto

import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue: BigDecimal,
    val dayfirstInstallment: LocalDate,
    val numberOfIntallments: Int,
    val id: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayfirstInstallment = this.dayfirstInstallment,
        numberOfIntallments = this.numberOfIntallments,
        customer = Customer(id = this.id)
    )
}

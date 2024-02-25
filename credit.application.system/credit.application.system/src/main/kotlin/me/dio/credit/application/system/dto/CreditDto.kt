package me.dio.credit.application.system.dto

import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue: BigDecimal,
    val dayfirstInstallment: LocalDate,
    val numberOfIntallment: Int,
    val id: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayfirstInstallment = this.dayfirstInstallment,
        numberOfIntallment = this.numberOfIntallment,
        customer = Customer(id = this.id)
    )
}

package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(

    @field:NotEmpty(message = "invalid imput") val firstName: String,
    @field:NotEmpty(message = "invalid imput") val lastName: String,
    @field:NotEmpty(message = "invalid imput")
    @field:CPF(message = "This invalid CPF") val cpf: String,
    @field:NotNull(message = "invalid imput") val income: BigDecimal,
    @field:Email(message = "invalid email")
    @field:NotEmpty(message = "invalid imput")val email: String,
    @field:NotEmpty(message = "invalid imput") val password: String,
    @field:NotEmpty(message = "invalid imput") val zipCod: String,
    @field:NotEmpty(message = "invalid imput") val street: String

) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCod = this.zipCod,
            street = this.street
        )


    )
}

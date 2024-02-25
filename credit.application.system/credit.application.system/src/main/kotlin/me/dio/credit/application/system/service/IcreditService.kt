package me.dio.credit.application.system.service

import me.dio.credit.application.system.entity.Credit
import java.util.*

interface IcreditService {
    fun save(credit: Credit): Credit
    fun findAllByCustomer (customerID: Long): List<Credit>
    fun findByCreditCode ( creditCode: UUID, customerID: Long): Credit
}
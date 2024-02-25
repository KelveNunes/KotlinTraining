package me.dio.credit.application.system.repository

import me.dio.credit.application.system.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CreditRepository: JpaRepository<Credit, Long> {
    fun findByCreditCode(creditCode: UUID): Credit?
}
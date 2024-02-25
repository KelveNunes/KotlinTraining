package me.dio.credit.application.system.service.implemetation


import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.repository.CreditRepository
import me.dio.credit.application.system.service.IcreditService
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): IcreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }

        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerID: Long): List<Credit> =
        this.creditRepository.findAllByCustomerId(customerID)

    override fun findByCreditCode(creditCode: UUID, customerID: Long): Credit {
        val credit: Credit = this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("CreditCode $creditCode not found")
        return if(credit.customer?.id == customerID) credit else throw RuntimeException("Contact adm")
    }
}
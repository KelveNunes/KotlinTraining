package me.dio.credit.application.system.service

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import me.dio.credit.application.system.repository.CustomerRepository
import me.dio.credit.application.system.service.implemetation.CustomerService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal
import java.util.*

@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class CustomerServiceTeste {
    @MockK
    lateinit var customerRepository: CustomerRepository
    @InjectMockKs
    lateinit var customerService: CustomerService

    @Test
    fun `should create customer`() {
        //given
        val fakeCustomer: Customer = buildCustomer()
        every { customerRepository.save((any())) } returns fakeCustomer
        //when
        val actual:Customer =  customerService.save(fakeCustomer)
        //then
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(fakeCustomer)
        verify (exactly = 1){ customerRepository.save(fakeCustomer)}
    }

    @Test
    fun `should find costumer`(){
        //given
        val fakeId: Long = Random().nextLong()
        val fakeCustomer: Customer = buildCustomer(id = fakeId)
        every {customerRepository.findById(fakeId)  } returns Optional.of(fakeCustomer)
        //when
        val actual: Customer=  customerService.findById(fakeId)
        //then
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isExactlyInstanceOf(Customer::class.java)
        Assertions.assertThat(actual).isSameAs(fakeCustomer)
        verify(exactly = 1) { customerRepository.findById(fakeId) }
    }

    @Test
    fun `should not find customer by invalid id and throw BusinessException`(){
        //given
        val fakeId: Long = Random().nextLong()
        every {customerRepository.findById(fakeId)  } returns Optional.empty()
        //when
        //then
        Assertions.assertThatExceptionOfType(Bussinesse)
    }
    private fun buildCustomer(
        firstName: String = "kelve",
        lastName: String = "Nunes",
        cpf: String = "11163664448",
        email: String = "kelve.com",
        password: String = "123456",
        zipCod: String = "13213213",
        street: String = "sadasdasdasa",
        income: BigDecimal = BigDecimal.valueOf(1000.0),
        id: Long = 1L
        )= Customer(
            firstName = firstName,
            lastName = lastName,
            cpf = cpf,
            email = email,
            password = password,
            address = Address(
                zipCod = zipCod,
                street = street
            ),
            income = income,
            id = id

        )

}
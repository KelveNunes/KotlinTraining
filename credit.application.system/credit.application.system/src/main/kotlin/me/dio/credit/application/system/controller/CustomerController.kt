package me.dio.credit.application.system.controller

import me.dio.credit.application.system.controller.dto.CustomerWiew
import me.dio.credit.application.system.dto.CustomerDto
import me.dio.credit.application.system.entity.Customer
import me.dio.credit.application.system.service.implemetation.CustomerService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    private val customerService: CustomerService,
) {
    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): String{
        val savedCustomer = this.customerService.save(customerDto.toEntity())
        return "Customer ${savedCustomer.email} saved!"
    }
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CustomerWiew {
       val customer: Customer = this.customerService.findById(id)
        return CustomerWiew(customer)
    }
    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long) = this.customerService.delete(id)
}
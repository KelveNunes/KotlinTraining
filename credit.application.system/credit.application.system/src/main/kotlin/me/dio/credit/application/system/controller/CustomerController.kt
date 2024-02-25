package me.dio.credit.application.system.controller

import me.dio.credit.application.system.dto.CustomerDto
import me.dio.credit.application.system.dto.CustomerUpdateDto
import me.dio.credit.application.system.dto.CustomerWiew
import me.dio.credit.application.system.entity.Customer
import me.dio.credit.application.system.service.implemetation.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    private val customerService: CustomerService,
) {
    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): ResponseEntity<String> {
        val savedCustomer = this.customerService.save(customerDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer ${savedCustomer.email} saved!")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerWiew> {
        val customer: Customer = this.customerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerWiew(customer))
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long) = this.customerService.delete(id)

    @PatchMapping
    fun updateCustomer(
        @RequestParam(value = "customeId") id: Long,
        @RequestBody customerUpdateDto: CustomerUpdateDto
    ): ResponseEntity<CustomerWiew> {
        val customer: Customer = this.customerService.findById(id)
        val customerToUpedate: Customer = customerUpdateDto.toEntity(customer)
        val customerUpedated: Customer = this.customerService.save(customerToUpedate)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerWiew(customerUpedated))

    }

}
package me.dio.credit.application.system.repository;

import me.dio.credit.application.system.entity.Customer
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface CustomerRepository: JpaRepository<Cutomer, Long>


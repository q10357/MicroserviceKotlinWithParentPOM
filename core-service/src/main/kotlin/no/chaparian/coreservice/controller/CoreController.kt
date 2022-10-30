package no.chaparian.coreservice.controller

import no.chaparian.coreservice.exception.CustomerNotFoundException
import no.chaparian.coreservice.model.Customer
import no.chaparian.coreservice.service.CoreService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class CoreController(@Autowired private val coreService: CoreService) {

    @GetMapping("/customer/{id}")
    fun getCustomerById(@PathVariable id: Long): ResponseEntity<Customer> {
        coreService.getCustomerById(id)?.let { return ResponseEntity.ok(it) }
        throw CustomerNotFoundException("No customer found matching your request")
    }

    @PostMapping("/customer/new")
    fun registerCustomer(@RequestBody customer: Customer): ResponseEntity<Customer> {
        coreService.registerCustomer(customer)?.let { return ResponseEntity.ok(it) }
        throw CustomerNotFoundException("No customer found matching your request")
    }
}
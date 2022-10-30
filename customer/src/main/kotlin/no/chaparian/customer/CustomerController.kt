package no.chaparian.customer

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/customer")
class CustomerController(@Autowired private val customerService: CustomerService) {

    private val logger = KotlinLogging.logger {  }

    @PostMapping("/new")
    fun registerCustomer(@Valid @RequestBody customer: Customer): ResponseEntity<Customer?> {
        logger.info { "New customer registration $customer"}
        val id = customerService.registerCustomer(customer) ?: return ResponseEntity.badRequest().body(null)
        return ResponseEntity.ok(id)
    }

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: Long) : ResponseEntity<Customer>{
        return ResponseEntity.ok(customerService.getCustomerById(id))
    }
}
package no.chaparian.customer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CustomerService(@Autowired private val customerRepo: CustomerRepository) {

    fun registerCustomer(customer: Customer): Customer? {
        if(customer.id != null){
            if(customerRepo.existsById(customer.id)) return null
        }
        return customerRepo.save(customer)
    }

    fun getCustomerById(id: Long): Customer? {
        return customerRepo.findByIdOrNull(id)
    }
}
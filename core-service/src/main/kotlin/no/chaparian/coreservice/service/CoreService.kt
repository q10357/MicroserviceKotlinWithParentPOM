package no.chaparian.coreservice.service

import no.chaparian.coreservice.gateway.CustomerGateway
import no.chaparian.coreservice.model.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CoreService(@Autowired private val customerGateway: CustomerGateway) {

    fun getCustomerById(id: Long): Customer? {
        return customerGateway.fetchCustomer(id)
    }

    fun registerCustomer(customer: Customer): Customer? {
        return customerGateway.registerCustomer(customer)
    }
}
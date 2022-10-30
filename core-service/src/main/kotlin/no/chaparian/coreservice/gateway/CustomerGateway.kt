package no.chaparian.coreservice.gateway

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import no.chaparian.coreservice.exception.ServiceInterruptionException
import no.chaparian.coreservice.model.Customer
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class CustomerGateway {

    val logger = LoggerFactory.getLogger(CustomerGateway::class.java)
    val GET_ENDPOINT = "customer"

    @Value("\${customer.baseurl}")
    lateinit var baseUrl: String

    @CircuitBreaker(name = "customerGateway", fallbackMethod = "cbFallback")
    fun fetchCustomer(id: Long): Customer? {
        val result = RestTemplate().getForObject("$baseUrl/$GET_ENDPOINT/$id", ByteArray::class.java)
        result?.let {
            return jacksonObjectMapper().readValue(result, Customer::class.java)
        }
        return null
    }

    fun registerCustomer(customer: Customer): Customer? {
        val result = RestTemplate().postForObject("$baseUrl/$GET_ENDPOINT/new", customer, ByteArray::class.java)
        result.let {
            return jacksonObjectMapper().readValue(result, Customer::class.java)
        }
    }

    fun cbFallback(e: Throwable): Customer? {
        logger.error("Circuit breaker fallback called")
        throw ServiceInterruptionException("The gateway is currently down, please try again later")
    }
}
package no.chaparian.coreservice.exception

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class CoreControllerAdvice {

    @ExceptionHandler
    fun handleCatNotFound(ex: CustomerNotFoundException): ResponseEntity<String> {
        val exceptionPayload = ExceptionPayload(HttpStatus.NOT_FOUND.value(), ex.message?: "Customer not found")
        return ResponseEntity(jacksonObjectMapper().writeValueAsString(exceptionPayload), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleServiceInterruption(ex: ServiceInterruptionException): ResponseEntity<String> {
        val exceptionPayload = ExceptionPayload(HttpStatus.GATEWAY_TIMEOUT.value(), ex.message?: "Gateway is down")
        return ResponseEntity(jacksonObjectMapper().writeValueAsString(exceptionPayload), HttpStatus.GATEWAY_TIMEOUT)
    }
}

data class ExceptionPayload(
    val statusCode: Int,
    val message: String
)
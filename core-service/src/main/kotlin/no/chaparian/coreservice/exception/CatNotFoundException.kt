package no.chaparian.coreservice.exception

import java.lang.RuntimeException

class CustomerNotFoundException(message: String?) : RuntimeException(message)
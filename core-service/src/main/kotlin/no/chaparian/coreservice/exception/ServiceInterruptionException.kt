package no.chaparian.coreservice.exception

import java.lang.RuntimeException

class ServiceInterruptionException(message: String?) : RuntimeException(message)
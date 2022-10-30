package no.chaparian.customer.integrationtest

import org.json.JSONObject
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class RestAPITest(@Autowired private val mockMvc: MockMvc) {

    val baseUrl = "http://localhost:8080/api/v1/customer"

    @Test
    @Order(1)
    fun shouldRegisterCustomer() {
        val customerPayload = JSONObject()
            .put("firstName", "Isabel")
            .put("lastName", "King")
            .put("email", "isabel@isthebest.com")

        mockMvc.post(baseUrl) {
            contentType = MediaType.APPLICATION_JSON
            content = customerPayload
        }
            .andExpect { status { isOk() } }
            .andReturn()
    }

}
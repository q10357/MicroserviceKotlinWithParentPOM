package no.chaparian.customer

import org.jetbrains.annotations.NotNull
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name="customer")
data class Customer(
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "customer_id_sequence"
    )
    @SequenceGenerator(
        name = "customer_id_sequence",
        allocationSize = 1
    )
    val id: Long? = null,

    @NotBlank(message = "First Name is mandatory")
    @Column(name="first_name")
    val firstName: String,

    @NotBlank(message = "Last Name is mandatory")
    @Column(name="last_name")
    val lastName: String,

    @field:NotBlank(message = "Email is mandatory")
    @Column(name="email")
    val email: String
)
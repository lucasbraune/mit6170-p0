package io.github.lucasbraune.projectzero

import org.springframework.data.repository.CrudRepository
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Customer(
    @field:Id @field:GeneratedValue var id: Int = 0,
    var name: String = ""
)

interface CustomerRepository : CrudRepository<Customer, Int>
package io.github.lucasbraune.projectzero

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.repository.CrudRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@SpringBootApplication
class ProjectzeroApplication

fun main(args: Array<String>) {
    runApplication<ProjectzeroApplication>(*args)
}

@Entity
class Customer(
	@field:Id @field:GeneratedValue var id: Int = 0,
	var name: String = ""
)

@Repository
interface CustomerRepository : CrudRepository<Customer, Int>

@RestController
class MyController (@Autowired private val repository: CrudRepository<Customer, Int>) {

	@GetMapping("/")
	fun hello(): String = helloPage()

	@GetMapping("/customers")
	fun getCustomers(): ResponseEntity<List<Customer>> =
		ResponseEntity.ok(repository.findAll().toList())

	@PostMapping("/customers")
	fun createCustomer(@RequestBody name: String): ResponseEntity<Customer> {
		val saved: Customer = repository.save(Customer(0, name))
		return ResponseEntity.ok(saved)
	}

}
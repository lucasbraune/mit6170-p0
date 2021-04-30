package io.github.lucasbraune.projectzero

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@SpringBootApplication
class ProjectzeroApplication

fun main(args: Array<String>) {
    runApplication<ProjectzeroApplication>(*args)
}

@RestController
class MyController {

	@GetMapping("/")
	fun hello(): String = helloPage()

}
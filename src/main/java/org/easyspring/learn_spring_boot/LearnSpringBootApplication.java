package org.easyspring.learn_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LearnSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootApplication.class, args);
	}

	//http://localhost:8080/hello?name=Sharona
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	//http://localhost:8080/employee?id=100&empName=Alex
	//http://localhost:8080/employee?id=100
	@GetMapping("/employee")
	public String employee(@RequestParam(name = "id") String empId, @RequestParam(required = false) String empName) {
		return String.format("Hello %2$s! your id is %1$s", empId, empName);
	}

	//http://localhost:8080/person?fname=Lynda&lname=Berry
	//http://localhost:8080/person
	@GetMapping("/person")
	public Person person(@RequestParam(value = "fname", defaultValue = "First Name") String firstName, @RequestParam(value = "lname", defaultValue = "Last Name") String lastName) {
		return new Person(firstName, lastName);
	}

	record Person(String firstName, String lastName) {
	}

}

package com.example.demodocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDockerApplication.class, args);
    }


}

@RestController
@RequestMapping("api/students")
class RestControllerClass {
    static List<Student> students;

    static {
        students = List.of(
                new Student("Farah", 34),
                new Student("Hamza", 20),
                new Student("Robert", 53)
        );
    }

    @GetMapping
    List<Student> getStudents() {
        return students;
    }

    @PostMapping
    Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @GetMapping("/{name}")
    Student getStudentByName(@PathVariable String name) {
        return students.stream()
                .filter(student -> student.name().equals(name))
                .findFirst()
                .orElse(null);
    }
}

record Student(String name, int age) {
}

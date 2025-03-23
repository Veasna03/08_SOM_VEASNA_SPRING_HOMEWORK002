package org.example.homework002.controller;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.example.homework002.model.dto.request.StudentRequest;
import org.example.homework002.model.dto.response.ApiResponse;
import org.example.homework002.model.entity.Student;
import org.example.homework002.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/vi/student")
public class StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents(@RequestParam(defaultValue = "10") Integer size , @RequestParam(defaultValue = "1")Integer page) {
        ApiResponse<List<Student>> response=ApiResponse.<List<Student>>builder()
                .message("All student has been sucessfully fetched")
                .payload(studentService.getAllStudents(size,page))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{student-id}")
    public Student getStudentById(@PathVariable("student-id") Integer studentId) {
       return   studentService.getStudentById(studentId);

    }


    @PostMapping
    public Student addStudent(@RequestBody StudentRequest student) {
        return studentService.addStudent(student);
    }






}

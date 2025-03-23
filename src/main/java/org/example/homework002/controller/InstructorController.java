package org.example.homework002.controller;

import org.example.homework002.model.dto.request.InstructorRequest;
import org.example.homework002.model.dto.response.ApiResponse;
import org.example.homework002.model.entity.Instructor;

import org.example.homework002.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/instructors")
public class InstructorController {

private  final InstructorService instructorService;

public InstructorController(InstructorService instructorService) {
    this.instructorService = instructorService;
}

    @GetMapping
    public ResponseEntity<?> getAllInstructor(@RequestParam(defaultValue = "10") Integer size, @RequestParam(defaultValue = "1") Integer page) {

        ApiResponse<Object> reponse = ApiResponse.builder()
                .message("All instructor hass been successfully fetched")
                .payload(instructorService.getAllInstructors(size, page))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(reponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable Integer id) {
        ApiResponse<Instructor> response=ApiResponse.<Instructor>builder()
                .message("Instructor has been successfully founded")
                .payload(instructorService.getInstructorById(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
    return ResponseEntity.ok(response);
    }

    @PutMapping("/{instructor_id}")
    public ResponseEntity<?> UpdateInstructor(@PathVariable("instructor_id") Integer instructor_id, @RequestBody InstructorRequest instructorRequest) {
      ApiResponse<Instructor> response=ApiResponse.<Instructor>builder()
              .message("Instructor has been successfully updated")
              .payload(instructorService.UpdateInstructor(instructor_id, instructorRequest))
              .status(HttpStatus.OK)
              .timestamp(LocalDateTime.now())
              .build();
      return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{instructor_id}")
    public ResponseEntity<ApiResponse<Instructor>> DeleteInstructor(@PathVariable("instructor_id") Integer instructor_id) {
        ApiResponse<Instructor> response=ApiResponse.<Instructor>builder()
                .message("Instructor has been successfully deleted")
                .payload(instructorService.DeleteInstructor(instructor_id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
    return ResponseEntity.ok(response);
    }


    @PostMapping
    public Instructor createInstructor(@RequestBody InstructorRequest instructorRequest) {
    return instructorService.AddInstructor(instructorRequest);
    }









}



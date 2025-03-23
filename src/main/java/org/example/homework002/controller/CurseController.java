package org.example.homework002.controller;

import org.example.homework002.model.dto.request.CourseRequest;
import org.example.homework002.model.dto.response.ApiResponse;
import org.example.homework002.model.entity.Course;
import org.example.homework002.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CurseController {

    private final CourseService courseService;
    public CurseController(CourseService courseService) {
        this.courseService = courseService;
    }

     @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses(@RequestParam(defaultValue = "10") Integer size,@RequestParam(defaultValue = "1" ) Integer page) {
          ApiResponse<List<Course>> response=ApiResponse.<List<Course>>builder()
                  .message("All course has been successfully fetched")
                  .payload(courseService.getAllCourses(size,page))
                  .status(HttpStatus.OK)
                  .timestamp(LocalDateTime.now())
                  .build();
        return ResponseEntity.ok(response);
     }

      @PostMapping
    public ResponseEntity<ApiResponse<Course>> addCourse(@RequestBody CourseRequest courseRequest) {
        ApiResponse<Course> response=ApiResponse.<Course>builder()
                .message("Course has been successfully created")
                .payload(courseService.AddCourse(courseRequest))
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
      }


      @GetMapping("/{course-id}")
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourseByStudentId(@PathVariable("course-id") Integer id) {
        ApiResponse<List<Course>> response=ApiResponse.<List<Course>>builder()
                .message("Course has been successfully founded")
                .payload(courseService.getAllCourseByStudentId(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
      }

      @PutMapping("/{course_id}")
    public ResponseEntity<?> updateCourse(@PathVariable("course_id") Integer id, @RequestBody CourseRequest courseRequest) {
        ApiResponse<Course> response=ApiResponse.<Course>builder()
                .message("Course has been successfully updated")
                .payload(courseService.updateCourse(id, courseRequest))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
      }

      @DeleteMapping("/{course_id}")
    public ResponseEntity<ApiResponse<Course>> deleteCourse(@PathVariable("course_id") Integer id) {
        ApiResponse<Course> response=ApiResponse.<Course>builder()
                .message("Course has been successfully deleted")
                .payload(courseService.deleteCourse(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
      }





}

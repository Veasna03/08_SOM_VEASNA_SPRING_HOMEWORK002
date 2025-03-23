package org.example.homework002.service.impl;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.example.homework002.model.dto.request.CourseRequest;
import org.example.homework002.model.entity.Course;
import org.example.homework002.repository.CourseRepository;
import org.example.homework002.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @Override
    public List<Course> getAllCourses(Integer size, Integer page) {
        return courseRepository.getAllCourse(size, page);
    }

    @Override
    public Course AddCourse(CourseRequest course) {
        return courseRepository.AddCourse(course);
    }
    @Override
    public List<Course> getAllCourseByStudentId(Integer studentId) {
        return courseRepository.getAllCourseByStudentId(studentId);
    }

    @Override
    public Course updateCourse(Integer id, CourseRequest course) {
        return courseRepository.UpdateCourse(id, course);
    }


    @Override
    public Course deleteCourse(Integer id) {
        return courseRepository.deleteCourse(id);
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseRepository.getCourseById(id);
    }
}


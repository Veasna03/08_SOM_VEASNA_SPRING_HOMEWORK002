package org.example.homework002.service;

import org.example.homework002.model.dto.request.CourseRequest;
import org.example.homework002.model.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses(Integer size,Integer page);
    Course AddCourse(CourseRequest course);
    List<Course> getAllCourseByStudentId(Integer studentId);
    Course updateCourse(Integer id,CourseRequest course);
    Course deleteCourse(Integer id);






}

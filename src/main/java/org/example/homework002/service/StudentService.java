package org.example.homework002.service;

import org.example.homework002.model.dto.request.StudentRequest;
import org.example.homework002.model.entity.Student;

import java.util.List;

public interface StudentService {
  List<Student> getAllStudents(Integer size, Integer page);
  Student getStudentById(Integer id);
  Student addStudent(StudentRequest student);
 Student insertStudent(StudentRequest student);
 Student deleteStudent(Integer id);
}

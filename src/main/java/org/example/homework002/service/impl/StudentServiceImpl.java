package org.example.homework002.service.impl;

import org.example.homework002.model.dto.request.StudentRequest;
import org.example.homework002.model.entity.Student;
import org.example.homework002.repository.CourseRepository;
import org.example.homework002.repository.StudentRepository;
import org.example.homework002.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements  StudentService {
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {

        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Student> getAllStudents(Integer size, Integer page) {
        return studentRepository.getAllStudent(size, page);
    }
    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.getStudentById(id);
    }


    @Override
    public Student addStudent(StudentRequest student) {
        return studentRepository.addStudent(student);
    }

    @Override
    public Student insertStudent(StudentRequest studentRequest) {
       Student st= studentRepository.insertStudent(studentRequest);
       for(Integer courseId:studentRequest.getCourse_id()){
           courseRepository.insertStudentAndCourse(st.getId(), courseId);
       }

        return null;
    }
}

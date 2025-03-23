package org.example.homework002.service;

import org.example.homework002.model.dto.request.InstructorRequest;
import org.example.homework002.model.entity.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructors(Integer size, Integer page);
    Instructor getInstructorById(Integer id);
    Instructor UpdateInstructor(Integer id, InstructorRequest instructorRequest);
    Instructor DeleteInstructor(Integer id);
    Instructor AddInstructor(InstructorRequest instructorRequest);
}

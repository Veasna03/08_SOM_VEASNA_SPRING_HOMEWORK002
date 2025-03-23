package org.example.homework002.service.impl;

import org.example.homework002.model.dto.request.InstructorRequest;
import org.example.homework002.model.entity.Instructor;
import org.example.homework002.repository.InstructorRepository;
import org.example.homework002.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl  implements InstructorService {
    private InstructorRepository instructorRepository;
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    @Override
    public List<Instructor> getAllInstructors(Integer size, Integer page) {
        return instructorRepository.getAllInstructors(size, page);
    }

    @Override
    public Instructor getInstructorById(Integer id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public Instructor UpdateInstructor(Integer id, InstructorRequest instructor) {
        return instructorRepository.UpdateInstructor(id,instructor);
    }


    @Override
    public Instructor DeleteInstructor(Integer id) {
        return instructorRepository.DeleteInstructorById(id);

    }


    @Override
    public Instructor AddInstructor(InstructorRequest instructorRequest) {
        return instructorRepository.InsertInstructor(instructorRequest);
    }
}

package org.example.homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example.homework002.model.dto.request.StudentRequest;
import org.example.homework002.model.entity.Student;

import java.util.List;

@Mapper
public interface StudentRepository {



    @Select("""
      select * from students 
        offset #{size} *(#{page}-1)
  limit #{size}  
""")
    @Results(id = "studentMapper", value = {
            @Result(property = "id",column = "student_id"),
            @Result(property = "name",column = "student_name"),
            @Result(property = "course",column = "student_id",
                    many = @Many(select = "org.example.homework002.repository.CourseRepository.getAllCourseByStudentId")
            )
    })
    List<Student> getAllStudent(Integer size,Integer page);



    @Select("""
    select * from students where student_id=#{id}
""")
    @ResultMap("studentMapper")
    Student getStudentById(Integer id);

    @Select("""
insert into students (student_name,email,phone_number) values (#{student.name},#{student.email},#{student.phone_number}) RETURNING *
                                                    
""")

    @ResultMap("studentMapper")
    Student addStudent(@Param("student") StudentRequest student);






}

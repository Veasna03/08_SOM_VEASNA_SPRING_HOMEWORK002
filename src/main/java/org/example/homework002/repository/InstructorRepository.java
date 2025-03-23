package org.example.homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example.homework002.model.dto.request.InstructorRequest;
import org.example.homework002.model.entity.Instructor;

import java.util.List;
@Mapper
public interface InstructorRepository {

    @Select("""
  select  * from instructors
  offset #{size} *(#{page}-1)
  limit #{size}     

""")
    @Results(id = "instructorMapper",value = {
            @Result(property = "id",column = "instructor_id"),
            @Result(property = "name",column = "instructor_name")
    })
    List<Instructor>  getAllInstructors(Integer size, Integer page);

    @Select("""
      select  * from instructors where instructor_id=#{id}
""")
    @ResultMap("instructorMapper")
    Instructor getInstructorById(@Param("id") Integer id);

   @Select("""

  update instructors set instructor_name=#{instructor.name},email=#{instructor.email} where instructor_id=#{id}
  RETURNING *;
""")
//    @ResultMap("instructorMapper")
   @ResultMap("instructorMapper")
    Instructor UpdateInstructor(Integer id,@Param("instructor") InstructorRequest instructor);

    @Select("""
      delete  from instructors where instructor_id=#{id}
      RETURNING *;

""")
    @ResultMap("instructorMapper")
    Instructor DeleteInstructorById(Integer id);



    @Select("""
   insert  into instructors(instructor_name,email) values (#{instructor.name},#{instructor.email}) RETURNING *;
""")
    @ResultMap("instructorMapper")
    Instructor InsertInstructor(@Param("instructor") InstructorRequest instructor);



}

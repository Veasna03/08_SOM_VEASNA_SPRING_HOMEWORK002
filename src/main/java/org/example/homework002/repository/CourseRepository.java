package org.example.homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example.homework002.model.dto.request.CourseRequest;
import org.example.homework002.model.entity.Course;

import java.util.List;
@Mapper
public interface CourseRepository {

    @Select("""
     select * from courses  
       offset #{size} *(#{page}-1)
  limit #{size}  
""")
    @Results(id = "courseMapper",value = {
            @Result(property = "id",column = "course_id"),
            @Result(property = "name",column = "course_name"),
            @Result(property = "instructor",
                    column = "instructor_id",
                    one= @One(select = "org.example.homework002.repository.InstructorRepository.getInstructorById")
            )
    })
    List<Course> getAllCourse(Integer size, Integer page);

    @Select("""

   insert  into courses(course_name,description,instructor_id) values (#{course.name},#{course.description},#{course.instructor_id}) 
   RETURNING *;
""")
    @ResultMap("courseMapper")
    Course AddCourse(@Param("course") CourseRequest course);
    @Select("""
      select sc.course_id,course_name,description,instructor_id from student_course sc inner join public.courses c on c.course_id=sc.course_id where student_id=#{id};
""")
    @ResultMap("courseMapper")
    public List<Course> getAllCourseByStudentId(Integer id);
    @Select("""
    update courses set course_name=#{course.name},description=#{course.description},instructor_id=#{course.instructor_id}  where course_id=#{id}  RETURNING *;""")
    @ResultMap("courseMapper")
    Course UpdateCourse(Integer id ,@Param("course") CourseRequest course);



    @Select("""
    delete  from courses  where course_id=#{id} RETURNING *;
   
""")
    @ResultMap("courseMapper")
    Course deleteCourse(Integer id);


}

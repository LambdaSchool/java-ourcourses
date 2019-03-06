package com.lambdaschool.ourcourses.repository;

import com.lambdaschool.ourcourses.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Courserepository extends JpaRepository <Course, Long>
{
    List<Course> findCoursesByCoursenameEquals(String name);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM studcourses WHERE courseid = :courseid", nativeQuery = true)
    void deleteCourseFromStudcourses(long courseid);


}

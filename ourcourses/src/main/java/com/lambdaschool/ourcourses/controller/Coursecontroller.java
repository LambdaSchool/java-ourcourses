package com.lambdaschool.ourcourses.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.lambdaschool.ourcourses.model.Course;
import com.lambdaschool.ourcourses.repository.Courserepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/courses/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Coursecontroller
{
    //TODO add custom swagger documentation
    @Autowired
    Courserepository courserepos;

    @GetMapping("/courses")
    public List<Course> listAllCourses()
    {
        return courserepos.findAll();
    }

    @JsonView(View.CoursesOnly.class)
    @GetMapping("/courses/nostudents")
    public List<Course> listAllCoursesNoStudents()
    {
        return courserepos.findAll();
    }
    
    @GetMapping(value = "/id/{courseid}")
    public List<Course> getCourseByCourseId(@PathVariable long courseid)
    {
        return courserepos.findById(courseid).stream().collect(Collectors.toList());
    }

    @GetMapping(value = "/name/{coursename}")
    public List<Course> getCourseByCourseName(@PathVariable String coursename)
    {
        return courserepos.findCoursesByCoursenameEquals(coursename);
    }

    //TODO add get for courses plus number of students in course
}

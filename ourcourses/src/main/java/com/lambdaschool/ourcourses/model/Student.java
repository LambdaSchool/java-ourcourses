package com.lambdaschool.ourcourses.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "student")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studid;

    private String studname;

    @ManyToMany
    @JoinTable(name = "studcourses",
        joinColumns = {@JoinColumn(name = "studid")},
        inverseJoinColumns = {@JoinColumn(name = "courseid")})
    @JsonIgnoreProperties("students")
    private Set<Course> courses  = new HashSet<>();

    public Student()
    {
    }

    public Student(String studname)
    {
        this.studname = studname;
    }

    public long getStudid()
    {
        return studid;
    }

    public void setStudid(long studid)
    {
        this.studid = studid;
    }

    public String getStudname()
    {
        return studname;
    }

    public void setStudname(String studname)
    {
        this.studname = studname;
    }

    public Set<Course> getCourses()
    {
        return courses;
    }

    public void setCourses(Set<Course> courses)
    {
        this.courses = courses;
    }
}

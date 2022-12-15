package com.springboot.learningjpaandhibernate.course;

import com.springboot.learningjpaandhibernate.course.Course;
import com.springboot.learningjpaandhibernate.course.jdbc.CourseJDBCRepository;
import com.springboot.learningjpaandhibernate.course.jpa.CourseJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

/*    @Autowired
    CourseJDBCRepository repository;*/

    @Autowired
    private CourseJPARepo repository;

    @Override
    public void run(String... args) {
        repository.insert(new Course(1, "Oscar","Echeverria"));
        repository.insert(new Course(2, "Enrique","Ache"));
        repository.insert(new Course(3, "Lus","Bello"));
        repository.delete(2);
        System.out.println(repository.findById(3));
        System.out.println(repository.findById(1));
    }

}

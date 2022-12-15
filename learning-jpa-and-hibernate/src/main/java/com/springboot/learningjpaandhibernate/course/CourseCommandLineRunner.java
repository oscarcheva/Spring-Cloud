package com.springboot.learningjpaandhibernate.course;

import com.springboot.learningjpaandhibernate.course.Course;
import com.springboot.learningjpaandhibernate.course.jdbc.CourseJDBCRepository;
import com.springboot.learningjpaandhibernate.course.jpa.CourseJPARepo;
import com.springboot.learningjpaandhibernate.course.springdatajpa.CourseSpringDataJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

/*    @Autowired
    CourseJDBCRepository repository;*/

/*    @Autowired
    private CourseJPARepo repository;*/

    @Autowired
    private CourseSpringDataJPARepo repository;

    @Override
    public void run(String... args) {
        repository.save(new Course(1, "Oscar", "Echeverria"));
        repository.save(new Course(2, "Enrique", "Ache"));
        repository.save(new Course(3, "Lus", "Bello"));

        repository.deleteById(2l);

        System.out.println(repository.findById(3l));
        System.out.println(repository.findById(1l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("Bello"));
        System.out.println(repository.findByName("Oscar"));

    }
}

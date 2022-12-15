package com.springboot.learningjpaandhibernate.course.jdbc;

import com.springboot.learningjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJDBCRepository {

    @Autowired
    private JdbcTemplate springjddbcTemplate;

    private static String INSERT_QUERY =
            """
                    INSERT INTO COURSE (ID, NAME, AUTHOR) 
                    VALUES (?, ?, ?)    
                    """;

    private static String DELETE_QUERY =
            """
                    DELETE FROM COURSE 
                    WHERE ID = ?    
                    """;

    private static String SELECT_QUERY =
            """
                    SELECT * FROM COURSE 
                    WHERE ID = ?    
                    """;

    public void insert(Course course) {
        springjddbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void delete(long id) {
        springjddbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        return springjddbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}

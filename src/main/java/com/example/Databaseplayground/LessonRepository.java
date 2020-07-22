package com.example.Databaseplayground;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface LessonRepository extends CrudRepository<Lesson, Long> {

    @Query(value = "SELECT * FROM lessons WHERE id = :id", nativeQuery = true)
    public Lesson byId(Long id);

    @Query(value = "SELECT * FROM lessons WHERE title = :title", nativeQuery = true)
    public Lesson byTitle(String title);

    @Query(value = "DELETE * FROM lessons WHERE id = :id", nativeQuery = true)
    public Lesson deletebyId(Long id);

    @Query(value = "SELECT * FROM lessons WHERE (delivered_on BETWEEN :date1 AND :date2)", nativeQuery = true)
    public Lesson betweenDates(Date date1, Date date2);

}

package com.example.Databaseplayground;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Long> {

    @Query(value = "SELECT * FROM lessons WHERE id = :id", nativeQuery = true)
    public Lesson byId(Long id);

    @Query(value = "DELETE * FROM lessons WHERE id = :id", nativeQuery = true)
    public Lesson deletebyId(Long id);

}

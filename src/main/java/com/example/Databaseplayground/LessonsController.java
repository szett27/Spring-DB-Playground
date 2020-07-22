package com.example.Databaseplayground;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

    @GetMapping("/{id}")
    public Lesson getlesson(@PathVariable("id") Long id) {
        return this.repository.byId(id);
    }

    @DeleteMapping("/{id}")
    public void deletelesson(@PathVariable("id") Long id) {
        this.repository.deleteById(id);
    }



}

package com.example.Databaseplayground;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.util.Optional;

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

    @PatchMapping("/{id}")
    public Lesson updateId(@PathVariable String id, @RequestBody Lesson l, HttpServletResponse response) {
        try {
            Optional<Lesson> rec = this.repository.findById(Long.valueOf(id));
            if (rec.isPresent()) {
                Lesson update = rec.get();
                update.setTitle(l.getTitle());
                update.setDeliveredOn(l.getDeliveredOn());
                return this.repository.save(update);
            }
            else {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                return null;
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }
    }



}

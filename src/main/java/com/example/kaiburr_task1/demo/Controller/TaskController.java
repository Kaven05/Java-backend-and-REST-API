package com.example.kaiburr_task1.demo.Controller;

import java.util.List;

import com.example.kaiburr_task1.demo.Entity.Task;
import com.example.kaiburr_task1.demo.Service.TaskService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> getAll(@RequestParam(required = false) String id) {
        if (id != null) {
            Task task = service.getById(id);
            return task != null ? List.of(task) : List.of();
        }
        return service.getAll();
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        return service.save(task);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable String id, @RequestBody Task task) {
        task.setId(id);
        return service.save(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/search")
    public List<Task> search(@RequestParam String name) {
        return service.searchByName(name);
    }

    @PutMapping("/{id}/execute")
    public Task execute(@PathVariable String id) throws Exception {
        return service.executeCommand(id);
    }
}

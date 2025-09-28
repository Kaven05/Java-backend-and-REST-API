package com.example.kaiburr_task1.demo.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.example.kaiburr_task1.demo.Entity.Task;
import com.example.kaiburr_task1.demo.Entity.TaskExecution;
import com.example.kaiburr_task1.demo.Repository.TaskRepository;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> getAll() {
        return repo.findAll();
    }

    public Task getById(String id) {
        return repo.findById(new ObjectId(id)).orElse(null);
    }

    public Task save(Task task) {
        if (task.getTaskExecutions() == null) {
            task.setTaskExecutions(new ArrayList<>());
        }

        TaskExecution exec = new TaskExecution();
        exec.setStartTime(Instant.now());

        try {
            // Run the command
            Process process = Runtime.getRuntime().exec(task.getCommand());
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            process.waitFor();

            exec.setEndTime(Instant.now());
            exec.setOutput(output.toString());

        } catch (Exception e) {
            exec.setEndTime(Instant.now());
            exec.setOutput("Error while executing command: " + e.getMessage());
        }

        task.getTaskExecutions().add(exec);
        return repo.save(task);
    }

    public void delete(String id) {
        repo.deleteById(new ObjectId(id));
    }

    public List<Task> searchByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    public Task executeCommand(String id) throws Exception {
        Task task = getById(id);
        if (task == null)
            return null;

        TaskExecution exec = new TaskExecution();
        exec.setStartTime(Instant.now());

        Process process = Runtime.getRuntime().exec(task.getCommand());
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null)
            output.append(line).append("\n");
        process.waitFor();

        exec.setEndTime(Instant.now());
        exec.setOutput(output.toString());

        task.getTaskExecutions().add(exec);
        repo.save(task);
        return task;
    }
}

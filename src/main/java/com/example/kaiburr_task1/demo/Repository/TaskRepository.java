package com.example.kaiburr_task1.demo.Repository;

import java.util.List;

import com.example.kaiburr_task1.demo.Entity.Task;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, ObjectId> {
    List<Task> findByNameContainingIgnoreCase(String name);
}

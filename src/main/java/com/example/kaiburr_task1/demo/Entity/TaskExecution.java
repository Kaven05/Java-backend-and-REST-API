package com.example.kaiburr_task1.demo.Entity;

import java.time.Instant;

import lombok.Data;

@Data
public class TaskExecution {
    private Instant startTime;
    private Instant endTime;
    private String output;
}

Copy, paste, and fill in your screenshot file names. This template is ready for direct use in your repository.```markdown
# Task 1: Java Backend and REST API Example

**This is the first task in my submission.**

---

## Task Overview

Developed a Java REST API for managing and running "task" objects, representing shell commands to be executed in a Kubernetes pod. All data is persisted in MongoDB. The API supports searching, creating, deleting, and executing tasks.

---

## Features

- CRUD operations for tasks
- Execution tracking (start/end time, output)
- Secure command validation
- MongoDB storage

---

## Data Model

**Task Object**:  
- `id` (String): Task ID  
- `name` (String): Task name  
- `owner` (String): Task owner  
- `command` (String): Shell command  
- `taskExecutions` (List): Array of execution objects  

**TaskExecution Object**:  
- `startTime` (Date): Execution start
- `endTime` (Date): Execution end
- `output` (String): Command output  

*Example JSON:*
[
    {
        "id": "68d92c87b7b6ec9b8c2e4f11",
        "name": "Thaya",
        "owner": "ajay",
        "command": "cmd /c echo Kavin",
        "taskExecutions": [
            {
                "startTime": "2025-09-28T13:25:38.026Z",
                "endTime": "2025-09-28T13:25:38.026Z",
                "output": "Task created"
            },
            {
                "startTime": "2025-09-28T13:25:52.733Z",
                "endTime": "2025-09-28T13:25:52.792Z",
                "output": "Kavin\n"
            }
        ]
    },
    {
        "id": "68d95031ffc73ab8609300bf",
        "name": "Kavin",
        "owner": "ajay",
        "command": "cmd /c echo Kavin",
        "taskExecutions": [
            {
                "startTime": "2025-09-28T15:11:45.687Z",
                "endTime": "2025-09-28T15:11:45.734Z",
                "output": "Kavin\n"
            }
        ]
    }
]



---

## API Endpoints

| Method | Endpoint                        | Description                                                             |
|--------|----------------------------------|-------------------------------------------------------------------------|
| GET    | `/tasks`                        | Return all tasks, or one by ID if ID is provided                        |
| PUT    | `/tasks`                        | Create new task (JSON body, validates command)                          |
| DELETE | `/tasks/{id}`                   | Delete task by ID                                                       |
| GET    | `/tasks/search?name={string}`   | Find tasks by name substring                                            |
| PUT    | `/tasks/{id}/execution`         | Execute shell command for task and record execution                     |

---

## MongoDB Setup

- All tasks and executions are stored in MongoDB.
- Update connection details in your configuration file.

---

## How to Run

1. Install Java and MongoDB.
2. Configure application with your MongoDB connection.
3. Build with Maven/Gradle.
4. Run the server.
   --cmd
   mvn spring-boot:run
6. Use Postman/curl to test endpoints.

---

## Screenshots

**All screenshots include the current date/time and my name. Replace these paths with your actual screenshot files.**

### Terminal - App Running
<img width="1919" height="1189" alt="image" src="https://github.com/user-attachments/assets/1007ed02-be60-4693-a203-032be440b00b" />


### Task Creation (Postman)

<img width="1920" height="1200" alt="Screenshot 2025-09-28 215908" src="https://github.com/user-attachments/assets/268d73ed-3ef9-4235-b66d-58ffd497248f" />
<img width="1920" height="1200" alt="Screenshot 2025-09-28 215433" src="https://github.com/user-attachments/assets/5937b012-5eb1-4bf4-935f-ec242832c1c9" />
<img width="1920" height="1200" alt="Screenshot 2025-09-28 215323" src="https://github.com/user-attachments/assets/415824c0-efa8-408d-a398-dcb76d41f72d" />
<img width="1919" height="1189" alt="Screenshot 2025-09-28 215156" src="https://github.com/user-attachments/assets/0b3515b7-9f07-46cf-988e-0715a7b92934" />
<img width="1920" height="1200" alt="Screenshot 2025-09-28 215846" src="https://github.com/user-attachments/assets/0e9fd4ff-c574-4d25-b04a-47d13a117049" />
<img width="1920" height="1200" alt="Screenshot 2025-09-28 215546" src="https://github.com/user-attachments/assets/23a6ed1d-341b-4b86-a4fa-155f336e03e7" />

### MongoDB Data View
<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/b17a77a6-f75c-4cb6-b90e-7d9fea68181e" />


---

## Notes

- This is Task 1 of the submission.
- All commands are validated for security.
- Do not share this work or submit in zip/pdf/doc formats.

---

Copyright © 2025 Kaiburr LLC. All rights reserved.

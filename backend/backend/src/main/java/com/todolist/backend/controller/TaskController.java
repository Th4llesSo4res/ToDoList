package com.todolist.backend.controller;

import com.todolist.backend.entity.Task;
import com.todolist.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public String createTask(@RequestBody Task task) {
        taskService.saveTask(task);
        return "Tarefa salva com sucesso!";
    }
}

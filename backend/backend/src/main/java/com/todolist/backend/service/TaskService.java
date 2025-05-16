package com.todolist.backend.service;

import com.todolist.backend.entity.Task;
import com.todolist.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void saveTask(Task task) {
        taskRepository.save(task);
    }
}

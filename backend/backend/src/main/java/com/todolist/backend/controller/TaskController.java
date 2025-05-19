package com.todolist.backend.controller;

import com.todolist.backend.entity.Task;
import com.todolist.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Criar nova tarefa
    @PostMapping
    public String createTask(@RequestBody Task task) {
        taskService.saveTask(task);
        return "Tarefa salva com sucesso!";
    }

    // Buscar todas as tarefas
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Atualizar tarefa pelo ID
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return taskService.updateTask(id, updatedTask);
    }

    // Marcar tarefa como concluída
@PutMapping("/{id}/complete")
public String completeTask(@PathVariable Long id) {
    Task task = taskService.findById(id);
    if (task != null) {
        task.setCompleted(true);
        taskService.saveTask(task);
        return "Tarefa marcada como concluída!";
    } else {
        return "Tarefa não encontrada.";
    }
}

    // Deletar tarefa pelo ID
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Tarefa deletada com sucesso!";
    }
}

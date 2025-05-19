package com.todolist.backend.service;

import com.todolist.backend.entity.Task;
import com.todolist.backend.entity.User;
import com.todolist.backend.repository.TaskRepository;
import com.todolist.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    // Criar nova tarefa associada a um usuário fixo (ID = 1)
    public void saveTask(Task task) {
        // ⚠️ Simula o usuário logado (substituir por JWT no futuro)
        User user = userRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Usuário com ID 1 não encontrado"));
        
        task.setUser(user); // associa a tarefa ao usuário
        taskRepository.save(task);
    }


    // Buscar todas as tarefas
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Atualizar uma tarefa existente
    public Task updateTask(Long id, Task updatedTask) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com id: " + id));

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCompleted(updatedTask.isCompleted());

        return taskRepository.save(existingTask);
    }

    public Task findById(Long id) {
    return taskRepository.findById(id).orElse(null);
}


    // Deletar uma tarefa pelo ID
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada com id: " + id);
        }
        taskRepository.deleteById(id);
    }

    
}

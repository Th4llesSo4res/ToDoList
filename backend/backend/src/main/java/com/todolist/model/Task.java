package com.todolist.model;
import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean completed = false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

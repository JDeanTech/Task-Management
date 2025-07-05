package com.example.taskmanager.model;

/**
 * Represents a single task in the task manager application.
 * This is a simple Java Bean (POJO - Plain Old Java Object)
 * which acts as our 'Model' in a simplified MVC setup.
 */
public class Task {
    private String description; // The description of the task
    private boolean completed;  // Whether the task is completed or not

    /**
     * Default constructor.
     */
    public Task() {
    }

    /**
     * Constructor to create a task with a description.
     *
     * @param description The textual description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.completed = false; // By default, a new task is not completed
    }

    /**
     * Gets the description of the task.
     *
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the task.
     *
     * @param description The new description for the task.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Checks if the task is completed.
     *
     * @return true if the task is completed, false otherwise.
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Sets the completion status of the task.
     *
     * @param completed true to mark as completed, false to mark as not completed.
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
               "description='" + description + '\'' +
               ", completed=" + completed +
               '}';
    }
}
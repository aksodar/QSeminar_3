package ru.sberbank.service;

import ru.sberbank.data.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {
    List<Task> taskList;

    public TaskService() {
        this.taskList = new ArrayList<>();
    }

    public boolean createTask(int id, String summary) {
        if (summary == null || summary.isEmpty()) {
            throw new IllegalStateException("Task isn't created");
        }
        return taskList.add(new Task(id, summary));
    }

    public Task getTask(String summary) {
        return taskList.stream()
                       .filter(task -> summary.equalsIgnoreCase(task.getSummary()))
                       .findFirst()
                       .orElseThrow(() -> new IllegalStateException("Task is not found"));

    }

    public List<Task> getTasksForDeveloping() {
        return taskList.stream()
                       .filter(taks -> !taks.isDeveloped())
                       .collect(Collectors.toList());
    }

    public Task getTaskById(int id) {
        return taskList.stream()
                       .filter(task -> task.getId() == id)
                       .findFirst()
                       .orElseThrow(() -> new IllegalStateException("Task is with id = " + id + " not found"));
    }

    public Task addSummaryToTask(int id, String summary) {
        if (summary == null || summary.isEmpty()) {
            throw new IllegalStateException("Summary don't set");
        }
        Task task = this.getTaskById(id);
        task.setSummary(summary);
        return task;
    }
}
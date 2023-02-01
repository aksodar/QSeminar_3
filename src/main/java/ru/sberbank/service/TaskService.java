package ru.sberbank.service;

import ru.sberbank.data.Developer;
import ru.sberbank.data.Task;

import java.util.ArrayList;

public class TaskService {
    ArrayList<Task> arrayList;

    public TaskService() {
        this.arrayList = new ArrayList<>();
    }

    public void createTask(int id, String summary) {
        if(summary == null || summary.isEmpty()){
            throw new IllegalStateException("Incorrect params, Task not created");
        }
        arrayList.add(new Task(id, summary));
    }

    public Task getTask(String summary) {
        for (Task n: arrayList) {
            if (summary.equalsIgnoreCase(n.summary)) {
                return n;
            }
        }
        throw new IllegalStateException("Task not found");
    }

    public ArrayList<Task> getTasksForDeveloping() {
        ArrayList<Task> list = new ArrayList<>();
        for (Task n: arrayList) {
            if(!n.isDeveloped) {
                list.add(n);
            }
        }
        if(list.isEmpty()) {
            throw new IllegalStateException("No tasks for developing");
        }
        return list;
    }

    public Task getTaskById(int id) {
        for (Task task: arrayList) {
            if(id == task.id) {
                return task;
            }
        }
        throw new IllegalStateException("Id isn't correct, task not found");
    }

    public void addCommentToTask(int id, String comment) {
        Task task = getTaskById(id);
        int counter = 0;
        for (Integer i: task.comments.keySet()){
            if (i > counter) {
                counter = i;
            }
        }
        task.comments.put(++counter, comment);
    }

}
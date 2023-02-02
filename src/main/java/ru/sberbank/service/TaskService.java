package ru.sberbank.service;

import ru.sberbank.data.Task;

import java.util.ArrayList;

public class TaskService {
    ArrayList<Task> arrayList;

    public TaskService() {
        this.arrayList = new ArrayList<>();
    }

    public void createTask(int id, String summary) {
        if(summary == null && summary.isEmpty()){
            throw new IllegalStateException("Task is not create");
        }
        arrayList.add(new Task(id, summary));
    }

    public Task getTask(String summary) {
        for (Task n: arrayList) {
            if(summary.equalsIgnoreCase(n.summary)) {
                return n;
            }
        }
        throw new IllegalStateException("Task is not found");
    }

    public ArrayList<Task> getTasksForDeveloping() {
        ArrayList<Task> list = new ArrayList<>();
        for (Task n: arrayList) {
            if(!n.isDeveloped) {
                list.add(n);
            }
        }
        if(list.isEmpty()) {
            throw new IllegalStateException("All task developed");
        }
        return list;
    }

    public Task getTaskById(int id){
        for (Task a:arrayList) {
            if(id == a.id) {
                return a;
            }
        }
        throw new IllegalStateException("Task with id not found");
    }

    public void addCommentToTask(int id, String comment){
        Task task = getTaskById(id);
        int counter = 0;
        for (Integer i: task.comments.keySet()) {
            if(i > counter){
                counter = i;
            }
        }
        if(counter == 0) {
            throw new IllegalStateException("No task");
        }
        task.comments.put(++counter, comment);
    }
}
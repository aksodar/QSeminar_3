package ru.sberbank.service;

import ru.sberbank.data.Task;

import java.util.ArrayList;
import java.util.Collections;

public class TaskService {
    ArrayList<Task> list;

    public TaskService() {
        this.list = new ArrayList<>();
    }

    public boolean createTask(int id, String summary) {
        if(summary != null && !summary.isEmpty()){
            list.add(new Task(id, summary));
            return true;
        }
        return false;
    }

    public Task getTask(String summary) {
        for (Task n: list) {
            if(summary.equalsIgnoreCase(n.summary)) {
                return n;
            }
        }
        return null;
    }

    public ArrayList<Task> getTasksForDeveloping() {
        ArrayList<Task> list = new ArrayList<>();
        for (Task n: list) {
            if(!n.isDeveloped) {
                list.add(n);
            }
        }
        return list;
    }

    public Task getTaskById(int id){
        for(Task a: list) {
            if(a.id == id) {
                return a;
            }
        }
        throw new IllegalStateException("Task not found");
    }

    public void addCommentToTask(int id, String comment){
        Task t = getTaskById(id);

        t.comment.put(Collections.max(t.comment.keySet()) + 1, comment);
    }
}
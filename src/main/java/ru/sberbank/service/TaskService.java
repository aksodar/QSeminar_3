package ru.sberbank.service;

import ru.sberbank.data.Task;

import java.util.ArrayList;

public class TaskService {
    ArrayList<Task> arrayList;

    public TaskService() {
        this.arrayList = new ArrayList<>();
    }

    public void createTask(int id, String summary) {
        if(summary != null && !summary.isEmpty()){
            arrayList.add(new Task(id, summary));
        }
        throw new IllegalStateException("Task is not created");
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
        return list;
    }

    public Task getTaskById(int id){
        for (Task a: arrayList) {
            if(a.id == id) {
                return a;
            }
        }
        throw new IllegalStateException("Task is not found");
    }

    public void addCommentToTask(int id, String comment){
        if (comment == null || comment == ""){
            throw new IllegalStateException("Comment is empty");
        }
        Task t = getTaskById(id);
        int counter = 0;
        for (Integer i: t.comments.keySet()){
            if (i > counter){
                counter = i;
            }
        }
        t.comments.put(id, comment);
    }
}
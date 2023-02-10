package ru.sberbank.service;

import ru.sberbank.data.Task;

import java.util.ArrayList;

public class TaskService {
    ArrayList<Task> arrayList;

    public TaskService() {
        this.arrayList = new ArrayList<>();
    }

    public void createTask(int id, String summary) {

        if (summary == null || summary.isEmpty()) {
            throw new IllegalArgumentException("incorrect summary");
        }

        arrayList.add(new Task(id, summary));
    }

    public Task getTask(String summary) {
        for (Task n : arrayList) {
            if (summary.equalsIgnoreCase(n.summary)) {
                return n;
            }
        }
        throw new IllegalArgumentException("task not found");
    }

    public ArrayList<Task> getTasksForDeveloping() {
        ArrayList<Task> list = new ArrayList<>();
        for (Task n : arrayList) {
            if (!n.isDeveloped) {
                list.add(n);
            }
        }
        return list;
    }

    public Task getTaskBiId(int id) {
        for (Task task : this.arrayList) {
            if (task.id == id) {
                return task;
            }

        }
        throw new IllegalArgumentException("task not found");
    }

    public void addCommentToTask(int id, String comment) {

        if (id < 0) {
            throw new IllegalArgumentException("incorrect id");
        } else if (comment == null || comment.isEmpty()) {
            throw new IllegalArgumentException("incorrect comment");
        }

        Task task = getTaskBiId(id);

        int maxKey = 0;
        for (Integer currentKey : task.comments.keySet()) {
            if (currentKey > maxKey) {
                maxKey = currentKey;
            }
        }

        task.comments.put(++maxKey, comment);

    }

}
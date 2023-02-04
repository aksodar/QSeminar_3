package ru.sberbank.service;

import ru.sberbank.data.Task;

import java.util.ArrayList;

public class TaskService {
    ArrayList<Task> list;

    public TaskService() {
        this.list = new ArrayList<>();
    }

    public void createTask(int id, String summary) {
        if(summary == null || summary.isEmpty()){
            throw new IllegalArgumentException("Недопустимые атрибуты Task");
        }
        list.add(new Task(id, summary));
    }

    public Task getTask(String summary) {
        for (Task n: list) {
            if(summary.equalsIgnoreCase(n.summary)) {
                return n;
            }
        }
        throw new IllegalArgumentException("Не найдено ни одной записи c наименованием " + summary);
    }

    public ArrayList<Task> getTasksForDeveloping() {
        ArrayList<Task> list = new ArrayList<>();
        for (Task n: this.list) {
            if(!n.isDeveloped) {
                list.add(n);
            }
        }
        if(list.isEmpty()){
            throw new IllegalArgumentException("Нет задач для разработки");
        }
        return list;
    }

    public Task getTaskById(int id) {
        ArrayList<Task> list = new ArrayList<>();
        for (Task n: this.list) {
            if(id == n.id) {
                return n;
            }
        }
        throw new IllegalArgumentException("Отсутствует Task с id: " + id);
    }

    public void addCommentToTask(int id, String comment) {
        Task n = getTaskById(id);
        int counter = 0;
        for(Integer i: n.comments.keySet()){
            if(i > counter){
                counter = i;
            }
        }
        n.comments.put(++counter,comment);
    }

}
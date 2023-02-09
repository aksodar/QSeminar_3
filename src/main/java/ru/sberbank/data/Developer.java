package ru.sberbank.data;

import java.util.Objects;

public class Developer {
    private int id;
    private String firstName;
    private String secondName;
    private boolean isFree;
    private Task currentTask;

    public Developer(int id, String firstName, String secondName) {
        this.id = id;
        this.isFree = true;
        this.secondName = secondName;
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(final String secondName) {
        this.secondName = secondName;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(final boolean free) {
        isFree = free;
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(final Task currentTask) {
        this.currentTask = currentTask;
    }

    public boolean addTask(Task task){
        if(this.isFree && this.currentTask == null){
            this.currentTask = task;
            this.isFree = false;
            return true;
        }
        return false;
    }

    public Task makeTask(){
        if(this.currentTask != null && !this.isFree){
            this.currentTask.setDeveloped(true);
            this.isFree = true;
        }
        return null;
    }

    public void release(){
        this.currentTask = null;
        this.isFree = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return id == developer.id && isFree == developer.isFree && Objects.equals(currentTask, developer.currentTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentTask, id, isFree);
    }
}

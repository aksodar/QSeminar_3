package ru.sberbank.data;

public class Tester {
    int id;
    public String firstName;
    public String secondName;
    public boolean isFree;
    public Task currentTask;

    @Override
    public String toString() {
        return "Tester{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", secondName='" + secondName + '\'' +
               ", isFree=" + isFree +
               ", currentTask=" + currentTask +
               '}';
    }

    public Tester (int id, String firstName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.isFree = true;
    }

    public boolean addTask(Task t) {
        if (this.isFree == true && this.currentTask == null) {
            this.currentTask = t;
            this.isFree = false;
            return true;
        }
        return false;
    }

    public Task checkTask() {
        if (this.currentTask != null) {
            this.currentTask.isTested = true;
        }
        return currentTask;
    }

    public void release() {
        this.currentTask = null;
        this.isFree = true;
    }
}

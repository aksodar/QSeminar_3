package ru.sberbank.data;

public class Tester {
    int id;
    Task currentTask;
    public boolean isFree;
    public String firstName;
    public String secondName;

    public Tester(int id) {
        this.id = id;
        this.isFree = true;
    }

    public Tester(int id, String firstName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.isFree = true;
    }

    public boolean addTask(Task task) {
        if (this.isFree && task.isDeveloped && !task.isTested) {
            this.currentTask = task;
            this.isFree = false;
            return true;
        }
        return false;
    }

    public Task checkTask() {
        if (this.currentTask != null) {
            this.currentTask.isTested = true;
        }
        return this.currentTask;
    }

    public void release() {
        this.isFree = true;
        this.currentTask = null;
    }

    @Override
    public String toString() {
        return "Tester{" +
                "id=" + id +
                ", currentTask=" + currentTask +
                ", isFree=" + isFree +
                '}';
    }
}

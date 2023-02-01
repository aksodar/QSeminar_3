package ru.sberbank.data;

public class Tester {
    public int id;
    public Task currentTask;
    public boolean isFree;
    public String firstName;
    public String secondName;

    public Tester(int id) {
        this.id = id;
        this.isFree = true;
    }

    public Tester(int id, boolean isFree) {
        this.id = id;
        this.isFree = isFree;
    }

    @Override
    public String toString() {
        return "Tester{" +
               "id=" + id +
               ", currentTask=" + currentTask +
               ", isFree=" + isFree +
               ", firstName='" + firstName + '\'' +
               ", secondName='" + secondName + '\'' +
               '}';
    }

    public Tester(int id, String firstName, String secondName) {
        this.id = id;
        this.isFree = true;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public boolean equalsTesters(Tester tester) {
        if((this.id == tester.id) && (this.firstName.equalsIgnoreCase(tester.firstName)) && (this.secondName.equalsIgnoreCase(tester.secondName))){
            return true;
        }
        return false;
    }

    public boolean addTask(Task incident) {
        if (this.isFree == true && this.currentTask == null) {
            this.currentTask = incident;
            this.isFree = false;
            return true;
        }
        return false;
    }

    public Task checkTask() {
        if ((this.currentTask != null) && (this.currentTask.isDeveloped == true) /*протестировать можно только задачу, которая была разработана*/) {
            this.currentTask.isTested = true;
        }
        return currentTask;
    }

    public void release() {
        this.isFree = true;
        this.currentTask = null;
    }
}
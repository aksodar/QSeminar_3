package ru.sberbank.data;

import java.util.Objects;

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
    }

    public boolean addTask(Task t) {
        if(this.isFree && this.currentTask == null) {
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
        return this.currentTask;
    }

    public void release() {
        this.currentTask = null;
        this.isFree = true;
    }

    public boolean equals(Tester t) {
        return this.id == t.id && this.firstName.equals(t.firstName) && this.secondName.equals(t.secondName) ? true :  false;
    }
}

package ru.sberbank.data;

public class Tester {
    private int id;
    private String firstName;
    private String secondName;
    private Task currentTask;
    private boolean isFree;

    public Tester(int id, String firstName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.isFree = true;
    }

    @Override
    public String toString() {
        return "Tester{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", secondName='" + secondName + '\'' +
               ", currentTask=" + currentTask +
               ", isFree=" + isFree +
               '}';
    }

    public Tester(int id) {
        this.id = id;
        this.isFree = true;
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

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(final Task currentTask) {
        this.currentTask = currentTask;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(final boolean free) {
        isFree = free;
    }

    public boolean addTask(Task test) {
        if (this.isFree == true && this.currentTask == null && test.isDeveloped()) {
            this.currentTask = test;
            this.isFree = false;
            return true;
        }
        return false;
    }

    public Task checkTask() {
        if (this.currentTask != null) {
            this.currentTask.setTested(true);
            this.isFree = false;
        }
        return currentTask;
    }

    public void release() {
        this.isFree = true;
        this.currentTask = null;
    }
}

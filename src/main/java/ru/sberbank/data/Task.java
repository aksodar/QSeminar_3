package ru.sberbank.data;

public class Task {
    private int id;
    private boolean isDeveloped;
    private boolean isTested;
    private String summary;

    public Task(int id, String summary) {
        this.id = id;
        this.isDeveloped = false;
        this.isTested = false;
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public boolean isDeveloped() {
        return isDeveloped;
    }

    public void setDeveloped(final boolean developed) {
        isDeveloped = developed;
    }

    public boolean isTested() {
        return isTested;
    }

    public void setTested(final boolean tested) {
        isTested = tested;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(final String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Task{" +
               "id=" + id +
               ", isDeveloped=" + isDeveloped +
               ", isTested=" + isTested +
               ", summary='" + summary + '\'' +
               '}';
    }
}
package ru.sberbank.data;

import java.util.HashMap;
import java.util.Map;

public class Task {
    public int id;
    public boolean isDeveloped;
    public boolean isTested;
    public String summary;
    public Map<Integer, String> comments;

    public Task(int id, String summary) {
        this.id = id;
        this.isDeveloped = false;
        this.isTested = false;
        this.summary = summary;
        this.comments = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", isDeveloped=" + isDeveloped +
                ", summary='" + summary + '\'' +
                ", isTested=" + isTested + '\'' +
                '}';
    }
}
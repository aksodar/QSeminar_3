package ru.sberbank.data;

import java.util.HashMap;
import java.util.Map;

public class Task {
    public int id;
    public boolean isDeveloped;
    public boolean isTested;
    public String summary;
    public Map<Integer, String> comment;

    public Task(int id, String summary) {
        this.id = id;
        this.summary = summary;
        this.comment = new HashMap<>();
        this.isDeveloped = false;
        this.isTested = false;
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
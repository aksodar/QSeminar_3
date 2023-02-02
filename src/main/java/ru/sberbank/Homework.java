package ru.sberbank;

import ru.sberbank.data.Task;
import ru.sberbank.service.TaskService;
import ru.sberbank.service.TesterService;

public class Homework {

    public static void main(String[] args) {
        TesterService testerService = new TesterService();
        TaskService taskService = new TaskService();
        taskService.createTask(1, "test");
        taskService.addCommentToTask(1, "test");
        taskService.addCommentToTask(1, "test2");
        Task task = taskService.getTask("test");
        System.out.println(task.comments);
    }

}

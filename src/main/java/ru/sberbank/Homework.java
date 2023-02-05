package ru.sberbank;

import ru.sberbank.data.Developer;
import ru.sberbank.data.Task;
import ru.sberbank.data.Tester;
import ru.sberbank.service.DeveloperService;
import ru.sberbank.service.TaskService;
import ru.sberbank.service.TesterService;

import java.util.Arrays;

public class Homework {

    public static void main(String[] args) {
        DeveloperService developerService = new DeveloperService();
        TaskService taskService = new TaskService();
        TesterService testerService = new TesterService();

        developerService.createDeveloper(1, "Endy", "Pafca");
        try {
            developerService.getDeveloper("Endy", "");
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
        Developer developer = developerService.getDeveloper("Endy", "Pafca");

        taskService.createTask(1, "New SPA");
        Task task = taskService.getTaskById(1);
        try {
            taskService.getTask("New");
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
        developer.addTask(task);
        developer.makeTask();
        Task toTest = developer.getCurrentTask();

        System.out.println("Free testers:" +  testerService.getFreeTesters());

        testerService.createTester(1, "Damir", "Iskakov");
        testerService.createTester(2, "John", "Dow");
        System.out.println("Free testers:" +  testerService.getFreeTesters());
        Tester testerJohn = testerService.getTester("John", "Dow");
        testerJohn.addTask(toTest);
        System.out.println("Tester with task: " + testerJohn);
        try {
            System.out.println("Find tester Johnny :" + testerService.getTester("Johnny", "Dow"));
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Free testers:" +  testerService.getFreeTesters());

    }

}

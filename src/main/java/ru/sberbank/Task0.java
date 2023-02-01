package ru.sberbank;

import ru.sberbank.service.DeveloperService;

public class Task0 {

    public static void main(String[] args) {
        DeveloperService developerService = new DeveloperService();
        //developerService.createDeveloper(1, "", "");
        System.out.println(developerService.getFreeDevelopers());
    }

}

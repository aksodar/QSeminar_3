package ru.sberbank.service;

import ru.sberbank.data.Developer;

import java.util.ArrayList;

public class DeveloperService {
    public ArrayList<Developer> list;

    public DeveloperService() {
        this.list = new ArrayList<>();
    }

    public void createDeveloper(int id, String firstName, String secondName) {
        if((firstName == null || firstName.isEmpty()) || (secondName == null || secondName.isEmpty())) {
            throw new IllegalArgumentException("Недопустимые атрибуты Developer");
        }
        list.add(new Developer(id, firstName, secondName));
    }

    public Developer getDeveloper(String firstName, String secondName) {
        for (Developer t: list)  {
            if(firstName.equalsIgnoreCase(t.firstName) && secondName.equalsIgnoreCase(t.secondName)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Не найдено ни одной записи Developer");
    }

    public ArrayList<Developer> getFreeDevelopers() {
        ArrayList<Developer> temp = new ArrayList<>();
        for (Developer n: list) {
            if(n.isFree) {
                temp.add(n);
            }
        }
        if(list.isEmpty()){
            throw new IllegalArgumentException("Нет свободных разработчиков");
        }
        return temp;
    }

}
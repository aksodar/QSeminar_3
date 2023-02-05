package ru.sberbank.service;

import ru.sberbank.data.Tester;

import java.util.ArrayList;

public class TesterService {
    ArrayList<Tester> list;

    public TesterService() {
        this.list = new ArrayList<>();
    }

    public void createTester(int id, String firstName, String secondName) {
        if((firstName == null || firstName.isEmpty()) || (secondName == null || secondName.isEmpty())) {
            throw new IllegalStateException("Тестер не создан");
        }
        list.add(new Tester(id, firstName, secondName));
    }

    public Tester getTester(String firstName, String secondName) {
        for (Tester t: list)  {
            if(firstName.equalsIgnoreCase(t.firstName) && secondName.equalsIgnoreCase(t.secondName)) {
                return t;
            }
        }
        throw new IllegalStateException("Тестер не найден");
    }

    public ArrayList getFreeTesters() {
        ArrayList<Tester> freeTester = new ArrayList<>();
        for (Tester n: list) {
            if(n.isFree == true) {
                freeTester.add(n);
            }
        }
        if(freeTester.isEmpty()) {
            throw new IllegalStateException("Нет свободный тестеров");
        }
        return freeTester;
    }
}

package ru.sberbank.service;

import ru.sberbank.data.Tester;

import java.util.ArrayList;

public class TesterService {
    ArrayList<Tester> list;

    public TesterService() {
        this.list = new ArrayList<>();
    }

    public void createTester(int id, String firstName, String secondName) {

        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("incorrect firstname");
        } else if (secondName == null || secondName.isEmpty()) {
            throw new IllegalArgumentException("incorrect secondName");
        }

        this.list.add(new Tester(id, firstName, secondName));
    }

    public Tester getTester(String firstName, String secondName) {

        for (Tester tester : this.list) {
            if (tester.firstName.equalsIgnoreCase(firstName)
                    && tester.secondName.equalsIgnoreCase(secondName)) {
                return tester;
            }
        }
        throw new IllegalArgumentException("Tester not found");
    }

    public ArrayList<Tester> getFreeTesters() {
        ArrayList<Tester> freeTesters = new ArrayList<>();
        for (Tester tester : this.list) {
            if (tester.isFree) {
                freeTesters.add(tester);
            }
        }
        return freeTesters;
    }

}

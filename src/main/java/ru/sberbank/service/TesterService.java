package ru.sberbank.service;

import ru.sberbank.data.Tester;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TesterService {
    private List<Tester> list;

    public TesterService() {
        this.list = new ArrayList<>();
    }

    public boolean createTester(int id, String name, String secondName) {
        if (name == null || name.isEmpty() || secondName == null || secondName.isEmpty()) {
            throw new IllegalStateException("Tester is not created");
        }
        return list.add(new Tester(id, name, secondName));
    }

    public Tester getTester(String name, String secondName) {
        return list.stream()
                   .filter(
                           tester -> tester.getFirstName().equals(name) && tester.getSecondName().equals(secondName)
                   )
                   .findFirst()
                   .orElseThrow(() -> new IllegalStateException("Tester " + name + " " + secondName + " is not found"));
    }

    public List<Tester> getFreeTesters() {
        return list
                .stream()
                .filter(Tester::isFree)
                .collect(Collectors.toList());
    }
}

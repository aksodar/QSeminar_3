package ru.sberbank.service;

import ru.sberbank.data.Developer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeveloperService {
    private List<Developer> developerList;

    public DeveloperService() {
        this.developerList = new ArrayList<>();
    }

    public boolean createDeveloper(int id, String firstName, String secondName) {
        if ((firstName == null || firstName.isEmpty()) || (secondName == null || secondName.isEmpty())) {
            throw new IllegalStateException("Developer is not created");
        }
        return developerList.add(new Developer(id, firstName, secondName));
    }

    public Developer getDeveloper(String firstName, String secondName) {
        return developerList
                .stream()
                .filter(
                        dev -> firstName.equalsIgnoreCase(dev.getFirstName()) &&
                               secondName.equalsIgnoreCase(dev.getSecondName())
                )
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Developer is not found"));
    }

    public List<Developer> getFreeDevelopers() {
        return developerList.stream()
                            .filter(Developer::isFree)
                            .collect(Collectors.toList());
    }

}
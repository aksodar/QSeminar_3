package ru.sberbank.service;

import java.util.ArrayList;
import ru.sberbank.data.Tester;

public class TesterService {
    ArrayList<Tester> list;

    public TesterService() {
        this.list = new ArrayList<>();
    }

    public boolean createTester(int id, String firstName, String secondName) {
        if(firstName != null && !firstName.isEmpty() && secondName != null && !secondName.isEmpty()) {
            list.add(new Tester(id, firstName, secondName));
            return true;
        }
        return false;
    }

    public Tester getTester(String firstName, String secondName) {
        for(Tester user: list)
            if(firstName.equalsIgnoreCase(user.firstName) && secondName.equalsIgnoreCase(user.secondName))
                return user;

        return null;
    }

    public ArrayList getFreeTesters() {
        ArrayList<Tester> tmp = new ArrayList<>();

        for(Tester item: list)
            if(item.isFree)
                tmp.add(item);

        return tmp;
    }
}

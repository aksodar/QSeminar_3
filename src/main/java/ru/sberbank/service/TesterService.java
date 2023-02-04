package ru.sberbank.service;

import ru.sberbank.data.Tester;

import java.util.ArrayList;

public class TesterService {
    ArrayList<Tester> list;

    public TesterService(){
        this.list = new ArrayList<>();
    }

    public void createTester(int id, String firstName, String secondName){
        if(firstName == null || firstName.isEmpty() || secondName == null || secondName.isEmpty()){
            throw new IllegalArgumentException("Недопустимые атрибуты Tester");
        }
        list.add(new Tester(id, firstName, secondName));
    }

    public Tester getTester(String firstName, String secondName){
        for(Tester t: list){
            if(firstName.equalsIgnoreCase(t.firstName) && secondName.equalsIgnoreCase(t.secondName)){
                return t;
            }
        }
        throw new IllegalArgumentException("Не найдено ни одной записи Tester с именем " + firstName + " и фамилией " + secondName);
    }

    public ArrayList getFreeTesters(){
        ArrayList<Tester> temp = new ArrayList<>();

        for(Tester t: list){
            if(t.isFree){
                temp.add(t);
            }
        }
        if(list.isEmpty()){
            throw new IllegalArgumentException("Нет свободных тестировщиков");
        }
        return temp;
    }
}

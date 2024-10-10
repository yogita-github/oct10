package com.demo.dao;

import com.demo.beans.Person;

import java.util.Comparator;

public class NameSort implements Comparator<Person> {
    public int compare(Person p,Person q){
        return p.getName().compareTo(q.getName());
    }
}

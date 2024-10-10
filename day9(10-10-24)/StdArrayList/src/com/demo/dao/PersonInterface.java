package com.demo.dao;

import com.demo.beans.Person;
import java.util.ArrayList;

public interface PersonInterface {
    boolean addStudent();
    boolean deleteStudent();
    boolean modifyMarks();
    boolean searchById();
    ArrayList<Person> displayByMarks();
    void sortById();
    void sortByMarks();
    void showAll();
    void sortByName();
}

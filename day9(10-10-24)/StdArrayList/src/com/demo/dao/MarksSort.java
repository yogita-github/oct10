package com.demo.dao;

import com.demo.beans.Graduation;
import com.demo.beans.Masters;
import com.demo.beans.Person;

import java.util.Comparator;

public class MarksSort implements Comparator<Person> {

    public int compare(Person a, Person b){
        if((a instanceof Graduation) && (b instanceof Graduation)){
            return Integer.compare(((Graduation) a).getSpecialSubMarks(),((Graduation) b).getSpecialSubMarks());
        }else if((a instanceof Graduation) && (b instanceof Masters)){
            return Integer.compare(((Graduation) a).getSpecialSubMarks(),((Masters) b).getThesisMarks());
        }else if((a instanceof Masters) && (b instanceof Graduation)){
            return Integer.compare(((Masters) a).getThesisMarks(),((Graduation) b).getSpecialSubMarks());
        }
        return Integer.compare(((Masters) a).getThesisMarks(),((Masters) b).getThesisMarks());
    }
}

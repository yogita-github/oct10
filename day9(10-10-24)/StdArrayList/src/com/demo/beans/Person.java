package com.demo.beans;

import java.util.Objects;


public class Person implements Comparable<Person> {
    private int id;
    private String name;
    private String address;

    Person(){}
    Person(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Person(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id : " + id +
                ", name : " + name + '\'' +
                ", address : " + address + ",  ";
    }

    @Override
    public boolean equals(Object o) {
        Person newPerson = (Person) o;
        return this.getId() == newPerson.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public int compareTo(Person person){
        return Integer.compare(this.getId(),person.getId());
    }
}

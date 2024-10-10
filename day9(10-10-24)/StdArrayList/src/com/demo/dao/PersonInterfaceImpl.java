package com.demo.dao;

import com.demo.beans.Graduation;
import com.demo.beans.Masters;
import com.demo.beans.Person;
import com.demo.beans.Student;
import jdk.jshell.spi.SPIResolutionException;

import java.util.*;

public class PersonInterfaceImpl implements PersonInterface{
    static List<Person> personArray;
    Scanner sc = new Scanner(System.in);

    static{
        personArray = new ArrayList<>();
        personArray.add(new Graduation(2,"Omen","LA Galaxy",new int[]{80,90,90},99));
        personArray.add(new Masters(3,"Rock","Jamaica",new int[]{81,59,70},"WWE",84));

        personArray.add(new Graduation(4,"Devid Beckham","Manchester",new int[]{91,81,91},78));
        personArray.add(new Masters(1,"Krishna Ronaldo","Madira",new int[]{99,99,40},"Football",99));
    }

    //1 add student
    public boolean addStudent(){
        System.out.println("Enter which type of student you want to add : ");
        System.out.println("1. Graduation \n2. Masters \n3. get back");
        System.out.print("Enter you choice : ");
        int choice = sc.nextInt();

        if(choice == 1){
            System.out.print("Enter id : ");
            int gid = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter student name : ");
            String gName = sc.nextLine();
            System.out.println("Enter student address : ");
            String gAddress = sc.nextLine();

            System.out.print("Enter marks for subject 1 : ");
            int m1 = sc.nextInt();
            System.out.print("Enter marks for subject 2 : ");
            int m2 = sc.nextInt();
            System.out.print("Enter marks for subject 3 : ");
            int m3 = sc.nextInt();
            int[] m = {m1,m2,m3};

            System.out.print("Enter special subject marks : ");
            int gssub = sc.nextInt();
            personArray.add(new Graduation(gid,gName,gAddress,m,gssub));
            return true;
        }else if(choice == 2){
            System.out.print("Enter id : ");
            int gid = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter student name : ");
            String gName = sc.nextLine();
            System.out.println("Enter student address : ");
            String gAddress = sc.nextLine();

            System.out.print("Enter marks for subject 1 : ");
            int m1 = sc.nextInt();
            System.out.print("Enter marks for subject 2 : ");
            int m2 = sc.nextInt();
            System.out.print("Enter marks for subject 3 : ");
            int m3 = sc.nextInt();
            int[] m = {m1,m2,m3};
            sc.nextLine();
            System.out.print("Enter thesis subject Name : ");
            String mtsub = sc.nextLine();
            System.out.print("Enter thesis subject marks : ");
            int gssub = sc.nextInt();
            personArray.add(new Masters(gid,gName,gAddress,m,mtsub,gssub));
            return true;
        }
        return false;
    }

    //2 delete student
    public boolean deleteStudent(){
        System.out.print("Enter id of student you want to delete : ");
        int id = sc.nextInt();

        Person newPerson = new Person(id);

        int position = personArray.indexOf(newPerson);
        if (position != -1){
            personArray.remove(position);
            return true;
        }
        return false;
    }

    //3 modify marks
    public boolean modifyMarks(){
        System.out.print("Enter id of student who's marks you want to modify : ");
        int gid = sc.nextInt();

        System.out.print("Enter updated marks for subject 1 : ");
        int m1 = sc.nextInt();
        System.out.print("Enter updated marks for subject 2 : ");
        int m2 = sc.nextInt();
        System.out.print("Enter updated marks for subject 3 : ");
        int m3 = sc.nextInt();
        int[] m = {m1,m2,m3};

        for(int i =0; i < personArray.size(); i++){
            if(personArray.get(i).getId() == gid){
                ((Student) personArray.get(i)).setMarks(m);
            }
            return true;
        }
        return false;
    }
    
    //4 search by id
    public boolean searchById(){
        System.out.print("Enter id of student : ");
        int gid = sc.nextInt();

        Person newPerson = new Person(gid);
        int position = personArray.indexOf(newPerson);

        if (position != -1){
            System.out.println(personArray.get(position));
            return true;
        }
        return false;
    }

    //5 display marks
    public ArrayList<Person> displayByMarks(){
        System.out.println("how many students got marks above, .... out of 100 ? ");
        int minMarks = sc.nextInt();

        ArrayList<Person> ans = new ArrayList<>();
        for (Person p : personArray){
            int marks = 0;
            if (p instanceof Graduation){
                marks = ((Graduation) p).getSpecialSubMarks();
            }else{
                marks = ((Masters) p).getThesisMarks();
            }

            if(marks > minMarks) ans.add(p);
        }
        return ans;
    }

    //6 sort by id
    public void sortById(){
        Collections.sort(personArray);
        showAll();
    }


    //7. Sort by name
    public void sortByName(){
        personArray.sort(new NameSort());
        showAll();
    }

    //8 sort by marks
    public void sortByMarks() {
        personArray.sort(new MarksSort());
        System.out.println("In which order\n1. Ascending \n2. Descending ");
        System.out.print("Enter your choice : ");
        int choice = sc.nextInt();
        if(choice == 1){
            System.out.println("Marks in Ascending order : ");
        }else{
            System.out.println("Marks in Descending order : ");
            Collections.reverse(personArray);
        }
        showAll();
    }

    //10. showAll
    public void showAll(){
        for (Person p : personArray){
            System.out.println(p);
        }
    }
}

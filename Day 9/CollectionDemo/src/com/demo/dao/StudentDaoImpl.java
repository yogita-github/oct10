package com.demo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.demo.beans.GraduateStudent;
import com.demo.beans.MasterStudent;
import com.demo.beans.Person;
import com.demo.beans.Student;
import com.demo.comparators.MyMarksComparator;
import com.demo.comparators.MyNameComparator;

public class StudentDaoImpl implements StudentDao{
	private static List<Student> studlst; 
	static {
		studlst=new ArrayList<>();
		studlst.add(new GraduateStudent(12, "Manjiri", "Pune", LocalDate.of(2000, 01, 03), new int[] {88,87},89));
		studlst.add(new GraduateStudent(13, "Mugdha", "Pune", LocalDate.of(1999, 02, 13), new int[] {78,75},77));
    	studlst.add(new MasterStudent(14, "Sahil", "Mumbai", LocalDate.of(2002, 01, 03), new int[] {88,87},"accounts","BCOM",89));
	}
	@Override
	public void addStudent(Student s) {
		studlst.add(s);
		
	}
	@Override
	public List<Student> findAllStudent() {
		return studlst;
		
	}
	@Override
	public Student findById(int id) {
		//internally calls equals method of person class
		int pos=studlst.indexOf(new Person(id));
		if(pos!=-1) {
			//retrieves the student object from the given position
			return studlst.get(pos);
		}
		return null;
	}
	@Override
	public boolean removeById(int id) {
		//delete the first matching object
		return studlst.remove(new Person(id));
		//to delete all the objects which satisfies the condition
		//studlst.removeIf(ob->ob.getMarks()[0]>50);
		
	}
	@Override
	public boolean updateMarks(int id, int newmarks) {
		Student s=findById(id);
		if(s!=null) {
			if(s instanceof MasterStudent) {
				((MasterStudent)s).setThesismarks(newmarks);
				return true;
			}else if(s instanceof GraduateStudent ) {
				((GraduateStudent)s).setSpsub(newmarks);
				return true;
			}
				
		}
		return false;
	}
	@Override
	public List<Student> findByMarks(int mks) {
		List<Student> lst=new ArrayList<>();
		for(Student s:studlst) {
			if(s instanceof MasterStudent) {
				if(((MasterStudent)s).getThesismarks()>mks)
					lst.add(s);
			}else if(s instanceof GraduateStudent) {
				if(((GraduateStudent)s).getSpsub()>mks)
					lst.add(s);
			}
				
		}
		if(lst.size()>0)
			return lst;
		else
			return null;
	}
	@Override
	public List<Student> findByName(String nm) {
		//java 1.7
		/*List<Student> lst=new ArrayList<>();
		for(Student s:studlst) {
			if(s.getPname().equals(nm)) {
				lst.add(s);
			}
		}*/
		//java 1.8
		List<Student> lst=studlst.stream()
				.filter(ob->ob.getPname().equals(nm))
				.collect(Collectors.toList());
		if(lst.size()>0) {
			return lst;
		}
		return null;
	}
	@Override
	public List<Student> sortById() {
		List<Student> lst=new ArrayList<>(studlst.size());
		//Collections.copy(lst, studlst);
		for(Student s:studlst) {
			lst.add(s);
		}
		//lst.stream().forEach(System.out::println);
		lst.sort(null);
		return lst;
	}
	@Override
	public List<Student> sortByName() {
		List<Student> lst=new ArrayList<>(studlst.size());
		//Collections.copy(lst, studlst);
		//create a copy of the list
		for(Student s:studlst) {
			lst.add(s);
		}
		//lst.stream().forEach(System.out::println);
		lst.sort(new MyNameComparator());
		return lst;
	}
	@Override
	public List<Student> sortByMarks() {
		List<Student> lst=new ArrayList<>(studlst.size());
		//Collections.copy(lst, studlst);
		//create a copy of the list
		for(Student s:studlst) {
			lst.add(s);
		}
		//lst.stream().forEach(System.out::println);
		lst.sort(new MyMarksComparator());
		return lst;
	}

}

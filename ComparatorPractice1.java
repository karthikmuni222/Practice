package com.theTapacademyPack;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;


class SortIdASC implements Comparator<Agent>{
	
	@Override
	public int compare(Agent a1,Agent a2) {
		
		Integer id1 = a1.getId();
		Integer id2 = a2.getId();
		
		return id1.compareTo(id2);
	}
}

class SortIdDSC implements Comparator<Agent>{
	
	@Override
	public int compare(Agent a1,Agent a2) {
		
		Integer id1 = a1.getId();
		Integer id2 = a2.getId();
		
		return -1*id1.compareTo(id2);
	}
}

class SortName implements Comparator<Agent>{
	
	@Override
	public int compare(Agent a1,Agent a2) {
		
		return a1.getName().compareTo(a2.getName());
	}
}

class SortEmailId implements Comparator<Agent>{
	
	@Override
	public int compare(Agent a1, Agent a2) {
		
		return a1.getEmailId().compareTo(a2.getEmailId());
		
	}
}

class SortSalaryASC implements Comparator<Agent>{
	
	@Override
	public int compare(Agent a1,Agent a2) {
		
		Integer s1 = a1.getSalary();
		Integer s2 = a2.getSalary();
		
		return s1.compareTo(s2);
	}
}

class SortSalaryDSC implements Comparator<Agent>{
	
	@Override
	public int compare(Agent a1,Agent a2) {
		
		Integer s1 = a1.getSalary();
		Integer s2 = a2.getSalary();
		
		return -1*s1.compareTo(s2);
	}
}

class Agent{
	
	//Private members
	private int id;
	private String name;
	private String emailId;
	private int salary;
	
	//Constructors
	public Agent() {
		
	}
	public Agent(int id,String name,String emailId,int salary) {
		this.id=id;
		this.name=name;
		this.emailId=emailId;
		this.salary=salary;
	}
	
	//Setters
	public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setEmailId(String emailId) {
		this.emailId=emailId;
	}
	public void setSalary(int salary) {
		this.salary=salary;
	}
	
	//Getters
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmailId() {
		return emailId;
	}
	public int getSalary() {
		return salary;
	}
	
	//Overriding "toString"
	@Override
	public String toString() {
		return id+" "+name+" "+emailId+" "+salary; 
	}
	
}


public class ComparatorPractice1 {

	public static void main(String[] args) {
		System.out.println("\n---Welcome to Sorting Application---");
		Scanner sc = new Scanner(System.in);
		
		SortIdASC sia = new SortIdASC();
		SortIdDSC sid = new SortIdDSC();
		SortName sn = new SortName();
		SortEmailId se = new SortEmailId();
		SortSalaryASC ssa = new SortSalaryASC();
		SortSalaryDSC ssd = new SortSalaryDSC();
		
		TreeSet<Agent>ts = null;
		
		System.out.println("Sort based on \n1.Id[Low to High]\n2.Id[High to Low]\n3.Name\n4.Email\n5.Salary[Low to High]\n6.Salary[High to Low]");
		int option = sc.nextInt();
		switch(option) 
		{
		case 1:
			ts = new TreeSet<Agent>(sia);
			break;
		case 2:
			ts = new TreeSet<Agent>(sid);
			break;
		case 3:
			ts = new TreeSet<Agent>(sn);
			break;
		case 4:
			ts = new TreeSet<Agent>(se);
			break;
		case 5:
			ts = new TreeSet<Agent>(ssa);
			break;
		case 6:
			ts = new TreeSet<Agent>(ssd);
			break;
		default:
			System.out.println("Invalid Option");
			System.exit(0);
		}
		
		System.out.println("Enter the number of Agents");
		int n = sc.nextInt();
		sc.nextLine();
		try {
			for(int i=1 ; i<=n ; i++) 
			{
				System.out.println("Enter the details of Agent "+i);
				String[]details = sc.nextLine().split(",");
				Agent a = new Agent(Integer.parseInt(details[0]),details[1],details[2],Integer.parseInt(details[3]));
				ts.add(a);
			}
		}catch(Exception e) {
			System.out.println("Provide valid details");
			System.exit(0);
		}
		System.out.println(ts);
	}

}

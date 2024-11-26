import java.io.Serializable;
/**
 * File: Employee.java
 * Class: CSCI 1302
 * Author: Bailey Diehl
 * Created on: 11/22/2024
 * Last Modified: 11/26/2024
 * Description: class represents a employee that is serializable
 */
public class Employee implements Serializable {
	String name;
	double salary;
	double yrsWorked;

	// Default Constructor - not used but hate seeing empty methods
	public Employee() {
		name = "Bailey";
		salary = 50000.0;
		yrsWorked = 5.0;
	}
	
	// Convince Constructor
	public Employee(String name, double salary, double yrsWorked) {
		setName(name);
		setSalary(salary);
		setYrsWorked(yrsWorked);
	}

	// Information Print
	public String toString() {
		return String.format("Name: %s\nSalary: $%,.2f\nYears of Service: %.1f\n", name, salary, yrsWorked);
	}
	
	// returns the raise percentage owed
	public double raiseAmount() {
		if(salary <= 30000) {
			return(yrsWorked <=2) ? 3.00 : 2.50;
		} else if (salary <= 60000) {
			return(yrsWorked <=5) ? 2.25 : 2.00;
		} else if(salary <= 80000) {
			return(yrsWorked <=5) ? 1.75 : 1.50;
		} else {
			return(yrsWorked <= 5) ? 1.25 : 1.00;
		}
	}
	
	// applies the required raiseAmount
	public void processRaise() {
		double raiseAmount = raiseAmount();
		salary += salary * raiseAmount / 100.0;
	}

	// Accessors & Mutators
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getYrsWorked() {
		return yrsWorked;
	}

	public void setYrsWorked(double yrsWorked) {
		this.yrsWorked = yrsWorked;
	}

}

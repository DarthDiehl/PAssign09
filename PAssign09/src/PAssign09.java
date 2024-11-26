import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/**
 * File: Passign09.java
 * Class: CSCI 1302
 * Author: Bailey Diehl
 * Created on: 11/26/2024
 * Last Modified: 11/26/2024
 * Description: taking binary info from a file and adjusting salary based of years worked.
 */
public class PAssign09 {
	public static void main(String[] args) {
		try(
				DataInputStream inData = new DataInputStream(new FileInputStream("src/employeeData.dat"));
				ObjectOutputStream outData = new ObjectOutputStream(new FileOutputStream("src/processedEmployeeData.dat"));
				){
			while(true) {
				// translate information from a->b
				String name = inData.readUTF();
				double salary = inData.readDouble();
				double yrsWorked = inData.readDouble();
				Employee employee = new Employee(name, salary, yrsWorked);

				// extra prints to break down process
				//System.out.print(employee);
				employee.processRaise();
				outData.writeObject(employee);
				// prints info within outData
				//System.out.println("\tAdjusted Salary:");
				System.out.println(employee);
				//System.out.println("-------------------");
			}
		}catch (EOFException e) {
			System.out.println("\nEnd of File Reached.");			
		} catch (FileNotFoundException e) {
			System.out.println("Error: File Not Found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

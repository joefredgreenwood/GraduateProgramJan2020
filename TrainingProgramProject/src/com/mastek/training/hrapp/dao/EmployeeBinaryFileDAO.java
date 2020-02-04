package com.mastek.training.hrapp.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.mastek.training.hrapp.Employee;

public class EmployeeBinaryFileDAO implements DataAccessObject<Employee> {

	Map<Integer, Employee> empMap;

	private String fileName;

	public EmployeeBinaryFileDAO(String fileName) {
		empMap = new HashMap<Integer, Employee>();
		this.fileName = fileName;
		//read all the data from file and load in collection map
	}
	//Read data from file and add it to the map shared
	private void readMapFromFile(){
		//ObjectInputStream: Read Object from Binary FileINputStream
		//FileInpuStream: Read Binary Data from File Objects
		//File: Open or refer to the file name using Filename/FIle path
		try (ObjectInputStream objIn = new ObjectInputStream( //!!!!!!!!!!!!!!TRY AND CATCH ARE ABSOLUTELY KEY HERE!!!!!!!!!!!!!!
											new FileInputStream(
													new File(fileName)))){
			//We use try block with resources to manage autoclosing of streams
			empMap = (Map<Integer, Employee>) objIn.readObject();
			
		} catch (Exception e) {
			System.out.println("Exception Thrown");
			e.printStackTrace();
		}
	}
	//update file with Map content
	private void writeMapToFile() {
		//ObjectOutputStream: Write binary object in serialized format in FileOutputStream
		//FileOUtputStream: Write binary object to Files
		//FIle: File object will refer to the file to be updated/created if not present
		try (ObjectOutputStream objOut = new ObjectOutputStream(
												new FileOutputStream(
														new File(fileName)))){
			objOut.writeObject(empMap); //Write all data in serialized format in the file
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	@Override
	public Employee add(Employee newEmployee) {
		readMapFromFile();
		if(!empMap.containsKey(newEmployee.getEmpno())) { // the ! means if not contains, if it doesn't we''ll put it in.
			empMap.put(newEmployee.getEmpno(), newEmployee); // update the file with new content

			writeMapToFile();
		}
		return newEmployee;
	}

	@Override
	public Collection<Employee> listAll() {
		readMapFromFile();
		return empMap.values();
	}

	@Override
	public Employee find(int key) {
		readMapFromFile();
		return empMap.get(key);
	}

	@Override
	public Employee remove(int key) {
		readMapFromFile();

		Employee removedEmp =null; //this assigns removedEmp as null
		if(empMap.containsKey(key)) { // if the map contains the key as passed by the user
			removedEmp = empMap.remove(key); // if it does remove something it will now assign the removed value to remoed Emp
			writeMapToFile();
		}
		return removedEmp; // if removed will show that if not the original assignee which is null

	}

}

package com.mastek.training.hrapp.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.mastek.training.hrapp.Employee;

public class EmployeeJSonFileDAO implements DataAccessObject<Employee> {


	Map<Integer, Employee> empMap; // When using a map you sould have this right at the start then initiate inside a constructor
	String fileName;



	public EmployeeJSonFileDAO(String fileName) {
		empMap = new HashMap<>(); // this is where we initiaise the map
		this.fileName = fileName;
	}

	private void readJSONFileData() {
		try (BufferedReader brJSONFile = new BufferedReader(new FileReader(new File(fileName)))){
			String line=brJSONFile.readLine();
			while(line!=null) { //While the reader is still reading lines of code line will not be null so will continue
				Employee emp = Employee.parseJSONString(line);
				empMap.put(emp.getEmpno(), emp);
				line = brJSONFile.readLine();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}




	private void writeJSONFileData() {
		try (BufferedWriter bw = new BufferedWriter(
									new FileWriter(
										new File(fileName)))){
			for(Integer empno:empMap.keySet()) {
				bw.write(Employee.getJSONString(empMap.get(empno))+"\n"); // the \n is essential to put everything on a new line.
			}

		} catch (Exception e) {
			e.printStackTrace();
		}





	}











	@Override
	public Employee add(Employee newEmployee) {
		readJSONFileData();
		if (!empMap.containsKey(newEmployee.getEmpno())) {
			empMap.put(newEmployee.getEmpno(), newEmployee);
			writeJSONFileData();
		}
		return newEmployee;
	}

	@Override
	public Collection<Employee> listAll() {
		readJSONFileData();
		return empMap.values();
	}

	@Override
	public Employee find(int key) {
		readJSONFileData();
		return empMap.get(key);
	}

	@Override
	public Employee remove(int key) {
		readJSONFileData();
		Employee removedEmp = null;
		if (empMap.containsKey(key)) {
			removedEmp = empMap.remove(key);
			writeJSONFileData();
		}
		return removedEmp;
	}

}

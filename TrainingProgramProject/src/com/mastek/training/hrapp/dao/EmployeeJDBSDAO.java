package com.mastek.training.hrapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;

public class EmployeeJDBSDAO implements DataAccessObject<Employee> {

	Connection conMysql;

	public EmployeeJDBSDAO() {
		try {
			//1. Load the Database Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Open the connection to mySql
			conMysql = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/graduate_2020_masteknet",
					"root",
					"root");
			System.out.println("Connection Successful");

		} catch (Exception e) {
			e.printStackTrace();
		}


	}


	@Override
	public Employee add(Employee newEmployee) {
		String sqlInsert = "Insert into jdbc_employees "+
				"(empno,name,unit_salary,grade,designation) "+
				"values(?,?,?,?,?)";
		try (PreparedStatement psInsert = conMysql.prepareStatement(sqlInsert)) {
			//Set all parameters required in the query
			psInsert.setInt(1, newEmployee.getEmpno());
			psInsert.setString(2, newEmployee.getName());
			psInsert.setDouble(3, newEmployee.getUnitSalary());
			psInsert.setString(4, newEmployee.getGrade().toString());
			psInsert.setString(5, newEmployee.getDesignation().toString());

			//execute the query on the database table return the rows affected
			int recordsAffected = psInsert.executeUpdate();
			System.out.println(recordsAffected+" Employee Inserted");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return newEmployee;
	}

	@Override
	public Collection<Employee> listAll() {
		String sqlSelectAll = "select * from jdbc_employees";
		List<Employee> employees = new LinkedList<Employee>();
		try (Statement stSelectAll = conMysql.createStatement()){
			ResultSet rsEmployees = stSelectAll.executeQuery(sqlSelectAll);
			while(rsEmployees.next()) {
				//Create object for every employee
				Employee e = new Employee();
				
				//Read the data using resultset
				e.setEmpno(rsEmployees.getInt("empno"));
				e.setName(rsEmployees.getString("name"));
				e.setUnitSalary(rsEmployees.getInt("unit_salary"));
				e.setGrade(Grades.valueOf(rsEmployees.getString("grade")));
				e.setDesignation(Designations.valueOf(rsEmployees.getString("designation")));
			
				employees.add(e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees; //Add the data to collection
	}

	@Override
	public Employee find(int key) {
		String findSql = "select * from jdbc_employees where empno=?";
		Employee emp = null;
		try (PreparedStatement psFind = conMysql.prepareStatement(findSql)){
			psFind.setInt(1, key);
			ResultSet rsFindResult = psFind.executeQuery();
			if(rsFindResult.next()) {
				emp = new Employee();
				emp.setEmpno(rsFindResult.getInt("empno"));
				emp.setName(rsFindResult.getString("name"));
				emp.setUnitSalary(rsFindResult.getInt("unit_salary"));
				emp.setGrade(Grades.valueOf(rsFindResult.getString("grade")));
				emp.setDesignation(Designations.valueOf(rsFindResult.getString("designation")));
			
				
			}
			
		} catch (Exception e) {
		e.printStackTrace();	// TODO: handle exception
		}
		return emp;
	}

	@Override
	public Employee remove(int key) {
		Employee empToBeRemoved= find(key);
		if(empToBeRemoved!=null) {
			String sqlDelete = "delete from jdbc_employees where empno=?";
			
					try (PreparedStatement psDelete = conMysql.prepareStatement(sqlDelete)) {
				psDelete.setInt(1, key);
				
				int rowsDeleted = psDelete.executeUpdate();
				System.out.println(rowsDeleted+" Employees deleted");
			
					
					
					
					
					
					
					
					
					} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return empToBeRemoved;
	}

}

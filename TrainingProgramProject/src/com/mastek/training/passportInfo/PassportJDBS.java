package com.mastek.training.passportInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class PassportJDBS implements PassportAccessObject<Passport> {

	Connection sqlCon;
	
	public PassportJDBS() {
		try {
			//1. Load the Database Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Open the connection to mySql
			sqlCon = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/graduate_2020_masteknet",
					"root",
					"root");
			System.out.println("Connection Successful");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	@Override
	public Passport add(Passport newPassport) {
		String sqlInsert = "Insert into passports "+
				"(passport_number,name,date_of_birth,country) "+
				"values(?,?,?,?)";
		try (PreparedStatement psInsert = sqlCon.prepareStatement(sqlInsert)) {
			//Set all parameters required in the query
			psInsert.setLong(1, newPassport.getPassportNumber());
			psInsert.setString(2, newPassport.getName());
			psInsert.setString(3, newPassport.getDateOfBirth());
			psInsert.setString(4, newPassport.getCountry());
		

			//execute the query on the database table return the rows affected
			int recordsAffected = psInsert.executeUpdate();
			System.out.println(recordsAffected+" Passport Inserted");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return newPassport;
	}

	@Override
	public Collection<Passport> listAll() {
		String sqlSelectAll = "select * from passports";
		List<Passport> Passports = new LinkedList<Passport>();
		try (Statement stSelectAll = sqlCon.createStatement()){
			ResultSet rsPassports = stSelectAll.executeQuery(sqlSelectAll);
			while(rsPassports.next()) {
				//Create object for every Passport
				Passport p = new Passport();
				
				//Read the data using resultset
				p.setPassportNumber(rsPassports.getLong("passport_number"));
				p.setName(rsPassports.getString("name"));
				p.setDateOfBirth(rsPassports.getString("date_of_birth"));
				p.setCountry(rsPassports.getString("country"));
				
				
			
				Passports.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Passports; //Add the data to collection
	}

	@Override
	public Passport find(int key) {
		String findSql = "select * from passports where passport_number=?";
		Passport pasp = null;
		try (PreparedStatement psFind = sqlCon.prepareStatement(findSql)){
			psFind.setInt(1, key);
			ResultSet rsFindResult = psFind.executeQuery();
			if(rsFindResult.next()) {
				pasp = new Passport();
				pasp.setPassportNumber(rsFindResult.getLong("passport_number"));
				pasp.setName(rsFindResult.getString("name"));
				pasp.setDateOfBirth(rsFindResult.getString("date_of_birth"));
				pasp.setCountry(rsFindResult.getString("country"));

			
				
			}
			
		} catch (Exception e) {
		e.printStackTrace();	// TODO: handle exception
		}
		return pasp;
	}

	@Override
	public Passport remove(int key) {
		Passport paspToBeRemoved= find(key);
		if(paspToBeRemoved!=null) {
			String sqlDelete = "delete from passports where passport_number=?";
			
					try (PreparedStatement psDelete = sqlCon.prepareStatement(sqlDelete)) {
				psDelete.setInt(1, key);
				
				int rowsDeleted = psDelete.executeUpdate();
				System.out.println(rowsDeleted+" Passports deleted");				
					
					} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return paspToBeRemoved;
	}
}

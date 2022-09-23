package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonBatchExecution {
	public static void main(String[] args) {
		List<Person> list=new ArrayList<Person>();
		Person person=new Person(3, "sandeep", "tirupati", 98323267l, 98645);
		Person person1=new Person(4, "akshara", "banglore", 983232784l, 76645);
		Person person2=new Person(5, "manu yaday", "hyderabad", 983234553l, 65645);
		Person person3=new Person(6, "akshuu", "sri kalahasti", 983232345l, 45645);
		Person person4=new Person(7, "rani", "tirupati", 7663354545l, 3445);
		
		list.add(person);
		list.add(person1);
		list.add(person2);
		list.add(person3);
		list.add(person4);
		
		
		
		String path="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/jdbcprc";
		String user="root";
		String password="root";
		Connection connection=null;
		String query="INSERT INTO PERSON VALUES (?,?,?,?,?)";
		
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			for (Person p : list) {
				preparedStatement.setInt(1, p.getId());
				preparedStatement.setString(2, p.getName());
				preparedStatement.setString(3, p.getAddreess());
				preparedStatement.setLong(4, p.getPhone());
				preparedStatement.setInt(5, p.getPincode());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			System.out.println("inserted successfully");
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}

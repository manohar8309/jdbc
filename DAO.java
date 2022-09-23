package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	String path="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/jdbcprc";
	String user="root";
	String password="root";
	Connection connection=null;
	
	public String savePerson(Person p)  {
		String query="INSERT INTO PERSON VALUES (?,?,?,?,?)";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, p.getId());
			preparedStatement.setString(2, p.getName());
			preparedStatement.setString(3, p.getAddreess());
			preparedStatement.setLong(4, p.getPhone());
			preparedStatement.setInt(5, p.getPincode());
			int a=preparedStatement.executeUpdate();
			if (a==1) {
				return "saved";
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "not saved";
	}
	
	public String updatePerson(Person p)
	{
		String query="update person set name=?, address=?, phone=? , pincode=? where id=?";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(5, p.getId());
			preparedStatement.setString(1,p.getName());
			preparedStatement.setString(2, p.getAddreess());
			preparedStatement.setLong(3, p.getPhone());
			preparedStatement.setInt(4, p.getPincode());
			int a=preparedStatement.executeUpdate();
			if (a==1) {
				return "updated";
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "not updated";
				
	}
	public String deletePerson(int id)
	{
		String query="delete from person where id=?";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int a=preparedStatement.executeUpdate();
			if (a==1) {
				return "deleted";
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "not deleted";
	}
	public ResultSet getPerson(int id) {
		String query="select * from person where id=?";
		ResultSet resultSet=null;
		
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			 resultSet=preparedStatement.executeQuery();
			 if(resultSet!=null)
			 {
				 return resultSet;
			 }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public Person getPersonObj(int id)   {
		String query="select * from person where id=?";
		ResultSet resultSet=null;
		
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			 resultSet=preparedStatement.executeQuery();
			 if(resultSet!=null)
			 {
				while (resultSet.next()) {
					Person person=new Person();
					person.setId(resultSet.getInt(1));
					person.setName(resultSet.getString(2));
					person.setAddreess(resultSet.getString(3));
					person.setPhone(resultSet.getLong(4));
					person.setPincode(resultSet.getInt(5));
					return person;
				}
			 }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

}

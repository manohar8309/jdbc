package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MobileDAO {
	String path="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/jdbcprc";
	String user="root";
	String password="root";
	Connection connection=null;
	
	public String insertMobile(Mobile m)  {
		String query="INSERT INTO mobile VALUES (?,?,?,?,?,?,?)";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, m.getId());
			preparedStatement.setString(2, m.getName());
			preparedStatement.setString(3, m.getBrand());
			preparedStatement.setString(4, m.getColor());
			preparedStatement.setDouble(5, m.getPrice());
			preparedStatement.setString(6, m.getRam());
			preparedStatement.setString(7, m.getManufacture());
			
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
				
				e.printStackTrace();
			}
		}
		
		return "not saved";
	}
	public String updateMobile(Mobile m)
	{
		String query="update mobile set name=?, brand=?, color=? , price=?, ram=?, manufacture=? where id=?";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(7, m.getId());
			preparedStatement.setString(1,m.getName());
			preparedStatement.setString(2, m.getBrand());
			preparedStatement.setString(3, m.getColor());
			preparedStatement.setDouble(4, m.getPrice());
			preparedStatement.setString(5, m.getRam());
			preparedStatement.setString(6, m.getManufacture());
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
	public String deleteMobile(int id)
	{
		String query="delete from mobile where id=?";
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
	public Mobile getMobile(int id)   {
		String query="select * from mobile where id=?";
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
					Mobile mobile=new Mobile();
					mobile.setId(resultSet.getInt(1));
					mobile.setName(resultSet.getString(2));
					mobile.setBrand(resultSet.getString(3));
					mobile.setColor(resultSet.getString(4));
					mobile.setPrice(resultSet.getDouble(5));
					mobile.setRam(resultSet.getString(6));
					mobile.setManufacture(resultSet.getString(7));
					return mobile;
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

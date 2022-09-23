package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	
	String path="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/jdbcprc";
	String user="root";
	String password="root";
	Connection connection=null;
	
	public String insertProduct(Product p)  {
		String query="INSERT INTO product VALUES (?,?,?,?,?,?,?,?)";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, p.getId());
			preparedStatement.setString(2, p.getName());
			preparedStatement.setDouble(3, p.getPrice());
			preparedStatement.setString(4, p.getManufacture());
			preparedStatement.setDouble(5, p.getDiscount());
			preparedStatement.setString(6, p.getWarranty());
			preparedStatement.setString(7, p.getManufactureDate());
			preparedStatement.setDouble(8, p.getGst());
			
			int a=preparedStatement.executeUpdate();
			if (a==1) {
				return "saved";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
	
	public String updateProduct(Product p) {
	
	String query="update product set name=?,price=?,manufacture=?,discount=?,warranty=?,manufacturedate=?,gst=? where id=?";
	try {
		Class.forName(path);
		connection=DriverManager.getConnection(url,user,password);
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(8, p.getId());
		preparedStatement.setString(1, p.getName());
		preparedStatement.setDouble(2, p.getPrice());
		preparedStatement.setString(3, p.getManufacture());
		preparedStatement.setDouble(4, p.getDiscount());
		preparedStatement.setString(5, p.getWarranty());
		preparedStatement.setString(6, p.getManufactureDate());
		preparedStatement.setDouble(7, p.getGst());
		
		int a=preparedStatement.executeUpdate();
		if (a==1) {
			return "saved";
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
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
	public String deleteProduct(int id) {
		String query="delete from product where id=?";
		
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url, user, password);
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
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "not saved";
	}
	public Product getProduct(int id) {
		String query="select * from product where id=?";
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
					Product product=new Product();
					product.setId(resultSet.getInt(1));
					product.setName(resultSet.getString(2));
					product.setPrice(resultSet.getDouble(3));
					product.setManufacture(resultSet.getString(4));
					product.setDiscount(resultSet.getDouble(5));
					product.setWarranty(resultSet.getString(6));
					product.setManufactureDate(resultSet.getString(7));
					product.setGst(resultSet.getDouble(8));
					return product;
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
	public List<Product> getAllProduct() {
		String query="select * from product";
		ResultSet resultSet=null;
		
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			 resultSet=preparedStatement.executeQuery();
			 if(resultSet!=null)
			 { 
				 List<Product> list=new ArrayList<Product>();
				while (resultSet.next()) {
					
					Product product=new Product();
					product.setId(resultSet.getInt(1));
					product.setName(resultSet.getString(2));
					product.setPrice(resultSet.getDouble(3));
					product.setManufacture(resultSet.getString(4));
					product.setDiscount(resultSet.getDouble(5));
					product.setWarranty(resultSet.getString(6));
					product.setManufactureDate(resultSet.getString(7));
					product.setGst(resultSet.getDouble(8));
					list.add(product);
				}
				return list;
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

package jdbc_maven;

import java.awt.Choice;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DAODriver {
	public static void main(String[] args) throws SQLException {
		Scanner scanner=new Scanner(System.in);
		DAO dao=new DAO();
		
		boolean data=true;
		do {
			System.out.println("select one option");
			System.out.println("1.insert person \n 2.update person \n 3.delete person \n 4.get person details \n 5.exit");
			int choice=scanner.nextInt();
			switch (choice) {
			case 1:{
				System.out.println("enter id");
				int id=scanner.nextInt();
				System.out.println("enter name");
				String name=scanner.next();
				System.out.println("enter address");
				String address=scanner.next();
				System.out.println("enter phone number");
				long phone=scanner.nextLong();
				System.out.println("enter pincode");
				int pincode=scanner.nextInt();
				Person person=new Person();
				person.setId(id);
				person.setName(name);
				person.setAddreess(address);
				person.setPhone(phone);
				person.setPincode(pincode);
				System.out.println(dao.savePerson(person));
			}
				
				break;
			case 2:
			{
				System.out.println("enter id for update");
				int id=scanner.nextInt();
				System.out.println("enter name");
				String name=scanner.next();
				System.out.println("enter address");
				String address=scanner.next();
				System.out.println("enter phone number");
				long phone=scanner.nextLong();
				System.out.println("enter pincode");
				int pincode=scanner.nextInt();
				Person person=new Person();
				person.setId(id);
				person.setName(name);
				person.setAddreess(address);
				person.setPhone(phone);
				person.setPincode(pincode);
				System.out.println(dao.updatePerson(person));
			}break;
			case 3:
			{
				System.out.println("enter id for update");
				int id=scanner.nextInt();
				System.out.println(dao.deletePerson(id));
			}break;
			case 4:
			{
				System.out.println("enter id for getting");
				int id=scanner.nextInt();
				Person person=dao.getPersonObj(id);
				System.out.println(person.getId());
				System.out.println(person.getName());
				System.out.println(person.getAddreess());
				System.out.println(person.getPhone());
				System.out.println(person.getPincode());
			
				
			}break;
			case 5:
			{
				data =false;
			}break;

			default:
				System.out.println("select correct option");
			}
			
			
		} while (data);
		
		System.out.println("thank you for using");
		
	}

}

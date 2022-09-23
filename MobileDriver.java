package jdbc_maven;

import java.util.Scanner;

public class MobileDriver {
	public static void main(String[] args) {
		MobileDAO mobileDAO = new MobileDAO();
		Scanner scanner = new Scanner(System.in);

		boolean data = true;
		do {
			System.out.println("select the choice");
			System.out
					.println("1.insert mobile \n 2.update mobile \n 3.delete mobile \n 4.get mobile details \n 5.exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("enter id");
				int id = scanner.nextInt();
				System.out.println("enter name");
				String name = scanner.next();
				System.out.println("enter brand");
				String brand = scanner.next();
				System.out.println("enter color");
				String color = scanner.next();
				System.out.println("enter price");
				double price = scanner.nextDouble();
				System.out.println("enter ram");
				String ram = scanner.next();
				System.out.println("enter manufacture");
				String manufacture = scanner.next();
				Mobile mobile = new Mobile();
				mobile.setId(id);
				mobile.setName(name);
				mobile.setBrand(brand);
				mobile.setColor(color);
				mobile.setPrice(price);
				mobile.setRam(ram);
				mobile.setManufacture(manufacture);
				System.out.println(mobileDAO.insertMobile(mobile));
			}
				break;
			case 2: {
				System.out.println("enter id for update");
				int id = scanner.nextInt();
				System.out.println("enter name");
				String name = scanner.next();
				System.out.println("enter brand");
				String brand = scanner.next();
				System.out.println("enter color");
				String color = scanner.next();
				System.out.println("enter price");
				double price = scanner.nextDouble();
				System.out.println("enter ram");
				String ram = scanner.next();
				System.out.println("enter manufacture");
				String manufacture = scanner.next();
				Mobile mobile = new Mobile();
				mobile.setId(id);
				mobile.setName(name);
				mobile.setBrand(brand);
				mobile.setColor(color);
				mobile.setPrice(price);
				mobile.setRam(ram);
				mobile.setManufacture(manufacture);
				System.out.println(mobileDAO.updateMobile(mobile));
			}
				break;
			case 3: {
				System.out.println("enter id for update");
				int id = scanner.nextInt();
				System.out.println(mobileDAO.deleteMobile(id));
			}
				break;

			case 4: {
				System.out.println("enter id for getting");
				int id = scanner.nextInt();
				Mobile mobile = mobileDAO.getMobile(id);
				System.out.println(mobile.getId());
				System.out.println(mobile.getName());
				System.out.println(mobile.getBrand());
				System.out.println(mobile.getColor());
				System.out.println(mobile.getPrice());
				System.out.println(mobile.getRam());
				System.out.println(mobile.getManufacture());

			}
				break;

			case 5: {
				data = false;
			}
				break;

			default:
				System.out.println("select correct option");

			}
		} while (data);

		System.out.println("thank you for using");

	}
}

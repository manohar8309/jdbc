package jdbc_maven;

import java.util.List;
import java.util.Scanner;

public class ProductDriver {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		ProductDAO dao=new ProductDAO();
		
		boolean data = true;
		do {
			System.out.println("select the choice");
			System.out.println(" 1.insert product \n 2.update product \n 3.delete product \n 4.get product details \n 5.get all products 6.exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("enter id");
				int id = scanner.nextInt();
				System.out.println("enter name");
				String name = scanner.next();
				System.out.println("enter price");
				double price = scanner.nextDouble();
				System.out.println("enter manufacture");
				String manufacture= scanner.next();
				System.out.println("enter discount");
				double discount = scanner.nextDouble();
				System.out.println("enter waranty");
				String warranty = scanner.next();
				System.out.println("enter manufactureDate");
				String manufactureDate = scanner.next();
				System.out.println("enter gst");
				double gst = scanner.nextDouble();
				Product product=new Product(id, name, price, manufacture, discount, warranty, manufactureDate, gst);
				System.out.println(dao.insertProduct(product));
				
			}
				break;
			case 2: {
				System.out.println("enter id for update");
				int id = scanner.nextInt();
				System.out.println("enter name");
				String name = scanner.next();
				System.out.println("enter price");
				double price = scanner.nextDouble();
				System.out.println("enter manufacture");
				String manufacture= scanner.next();
				System.out.println("enter discount");
				double discount = scanner.nextDouble();
				System.out.println("enter waranty");
				String warranty = scanner.next();
				System.out.println("enter manufactureDate");
				String manufactureDate = scanner.next();
				System.out.println("enter gst"); 
				double gst = scanner.nextDouble();
				
				Product product=new Product(id, name, price, manufacture, discount, warranty, manufactureDate, gst);
				System.out.println(dao.updateProduct(product));
			}
				break;
			case 3: {
				System.out.println("enter id for update");
				int id = scanner.nextInt();
				System.out.println(dao.deleteProduct(id));
			}
				break;

			case 4: {
				System.out.println("enter id for getting");
				int id = scanner.nextInt();
				Product product=dao.getProduct(id);
				System.out.println(product.getId()); 
				System.out.println(product.getName());
				System.out.println(product.getPrice());
				System.out.println(product.getManufacture());
				System.out.println(product.getDiscount());
				System.out.println(product.getWarranty());
				System.out.println(product.getManufactureDate());
				System.out.println(product.getGst());

			}
				break;
			case 5:{
				List<Product> list=dao.getAllProduct();
				
				System.out.println(list);
			}

			case 6: {
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

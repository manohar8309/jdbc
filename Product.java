package jdbc_maven;

public class Product {
	private int id;
	private String name;
	private double price;
	private String manufacture;
	private double discount;
	private String warranty;
	private String manufactureDate;
	private double gst;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String name, double price, String manufacture, double discount, String warranty,
			String manufactureDate, double gst) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.manufacture = manufacture;
		this.discount = discount;
		this.warranty = warranty;
		this.manufactureDate = manufactureDate;
		this.gst = gst;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getWarranty() {
		return warranty;
	}
	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	public String getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", manufacture=" + manufacture
				+ ", discount=" + discount + ", warranty=" + warranty + ", manufactureDate=" + manufactureDate
				+ ", gst=" + gst + "]";
	}
	
	

}

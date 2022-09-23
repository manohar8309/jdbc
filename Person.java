package jdbc_maven;

public class Person {
	private int id;
	private String name;
	private String addreess;
	private long phone;
	private int pincode;
	
	
	public Person() {
		super();
		
	}
	
	public Person(int id, String name, String addreess, long phone, int pincode) {
		super();
		this.id = id;
		this.name = name;
		this.addreess = addreess;
		this.phone = phone;
		this.pincode = pincode;
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
	public String getAddreess() {
		return addreess;
	}
	public void setAddreess(String addreess) {
		this.addreess = addreess;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	

}

package entity;

public class Hero {
	private int id;
	private String name;
	private String type;
	private String gender;
	private int price;
	
	public Hero(int id, String name, String type, String gender, int price) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.gender = gender;
		this.price = price;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + ", type=" + type + ", gender=" + gender + ", price=" + price + "]";
	}
	
}

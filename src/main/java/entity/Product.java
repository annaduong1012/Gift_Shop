package entity;

public class Product {
	private int id;
	private String name;
	private int price;
	private String imgName;
	private boolean isNew;
	private String productDescription;
	private int quantiy;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, int price, String imgName) {
		super();
		this.name = name;
		this.price = price;
		this.imgName = imgName;
	}

	public Product(int id, String name, int price, String imgName, boolean isNew, String productDescription,
			int quantiy) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgName = imgName;
		this.isNew = isNew;
		this.productDescription = productDescription;
		this.quantiy = quantiy;
	}

	public Product(int id, String name, int price, String imgName) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgName = imgName;
	}

	public Product(int id, String name, int price, String imgName, boolean isNew) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgName = imgName;
		this.isNew = isNew;
	}

	public Product(int id, String name, int price, String imgName, String productDescription, int quantiy) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgName = imgName;
		this.productDescription = productDescription;
		this.quantiy = quantiy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getQuantiy() {
		return quantiy;
	}

	public void setQuantiy(int quantiy) {
		this.quantiy = quantiy;
	}

}

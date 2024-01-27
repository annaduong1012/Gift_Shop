package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
	private int id;
	private String name;
	private int price;
	private String imgName;
	private boolean isNew;
	private String productDescription;
	private int quantiy;
	private String categoryName;
	private int categoryId;

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

	public Product(int id, String name, int price, String imgName, String categoryName) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgName = imgName;
		this.categoryName = categoryName;
	}

	public Product(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public boolean getIsNew() {
		return isNew;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Product product = (Product) obj;
		return this.id == product.getId();
	}

}

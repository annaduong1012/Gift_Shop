package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class ProductInCart {
	private int id;
	private String name;
	private int price;
	private double subTotal;
	private int quantity;
	
	@Override
	public int hashCode() {
		int hashCode = 1;
		hashCode = 31 * hashCode + id;
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		ProductInCart product = (ProductInCart) obj;
		return this.id == product.getId();
	}

}

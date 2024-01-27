package dao;

import java.util.Map;

import entity.Product;

public class CartDAO {
	public static double calculateTotalPrice(Map<Product, Integer> items) {
		double totalPrice = 0.0;
		for (Map.Entry<Product, Integer> entry : items.entrySet()) {
			totalPrice += entry.getKey().getPrice() * entry.getValue();
		}
		return totalPrice;
	}
}

package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Category {
	private int id;
	private String name;
	private int priority;

	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}

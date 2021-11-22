package entities;

public class Product {
	
	private String name;
	private Double price;
	
	public Product(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public static boolean staticProductPredicate(Product p) {//metodo estatico trabalha com produto passado como argumento
		return p.getPrice() >= 100.0;
	}
	
	public boolean nonStaticProductPredicate() {//metodo não estático trabalha com produto da propria classe
		return price >= 100;
	}
	
	public static void staticPriceUpdate(Product p) {
		 p.setPrice(p.getPrice()*1.1);
	}
	
	public void nonStaticPriceUpdate() {
		price = price *1.1;
	}
	
	public static String staticUppercaseName(Product p) {
		return p.getName().toUpperCase();
	}
	
	public String nonStaticUppercaseName() {
		return name.toUpperCase();
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	

}

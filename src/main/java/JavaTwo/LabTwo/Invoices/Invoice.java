package JavaTwo.LabTwo.Invoices;

import java.math.BigDecimal;

public class Invoice {
	
	
	private Invoice() {
		
	}
	
	public void addProduct(Product product) {
		// TODO: implement
	}
	
	public void addProduct(Product product, Integer quantity) {
		// TODO: implement
	}
	
	public String getNumber() {
		// TODO: implement
		return null;
	}
	
	public BigDecimal getSubtotal() {
		return null;
	}
	
	public BigDecimal getTax() {
		return null;
	}
	
	public BigDecimal getTotal() {
		return null;
	}
	
	public static Invoice create() {
		return new Invoice();
	}
	
}

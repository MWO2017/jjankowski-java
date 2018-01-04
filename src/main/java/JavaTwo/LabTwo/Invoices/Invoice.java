package JavaTwo.LabTwo.Invoices;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Invoice {
	private ArrayList<Product> products;

	public Invoice() {
		products = new ArrayList<Product>();
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public void addProduct(Product product, Integer quantity) {
		for (int i=0; i < quantity; i++){
			products.add(product);
		}
	}
	
	public String getNumber() {
		return String.valueOf(products.size());
	}
	
	public BigDecimal getSubtotal() {
        BigDecimal subTotalPrice = BigDecimal.ZERO;
        for (int i=0 ; i<products.size(); i++){
            subTotalPrice.add(products.get(i).getPrice());
        }
        return subTotalPrice;
	}
	
	public BigDecimal getTax() {
         BigDecimal taxPrice = BigDecimal.ZERO;
        for (int i=0 ; i<products.size(); i++){
            taxPrice.add(products.get(i).getTaxPercent());
        }
        return taxPrice;
	}
	
	public BigDecimal getTotal() {
		BigDecimal totalPrice = BigDecimal.ZERO;

		for (int i=0 ; i<products.size(); i++){
            BigDecimal tempValue = products.get(i).getPriceWithTax();
			totalPrice= totalPrice.add(tempValue);
		}

		return  totalPrice;
	}
	
	public static Invoice create() {
		return new Invoice();
	}
	
}

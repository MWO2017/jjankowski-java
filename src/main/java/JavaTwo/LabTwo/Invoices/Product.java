package JavaTwo.LabTwo.Invoices;

import java.math.BigDecimal;

public class Product {

    private static final BigDecimal DEFAULT_TAX = BigDecimal.valueOf(0.23);

    private void setName(String name) {
        if (name == null || name.length() < 1) {
            throw new java.lang.IllegalArgumentException();
        } else {
            this.name = name;
        }
    }

    private String name;

    private void setPrice(BigDecimal price) {
        if (price == null) {
            throw new IllegalArgumentException();
        }
        if (price.compareTo(BigDecimal.ZERO) > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private BigDecimal price;

    private BigDecimal taxPercent;

    private void setTaxPercent(BigDecimal taxPercent) {
        if (taxPercent == null) {
            throw new IllegalArgumentException();
        }
        if (taxPercent.compareTo(BigDecimal.ZERO) > 0) {
            this.taxPercent = taxPercent;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private Product(final String name, final BigDecimal price, final BigDecimal tax) {
        setName(name);
        setPrice(price);
        setTaxPercent(tax);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTaxPercent() {
        return taxPercent;
    }

    public BigDecimal getPriceWithTax() {

        BigDecimal result;

        if (taxPercent != null) {
            result = price.add(taxPercent.multiply(BigDecimal.valueOf(100)));
        } else {
            result = price.add(DEFAULT_TAX.multiply(BigDecimal.valueOf(100)));
        }
        return result;
    }

    public static Product create(final String name, final BigDecimal price, final BigDecimal tax) {

        return new Product(name, price, tax);

    }

    public static Product create(final String name, final BigDecimal price) {
        return create(name, price, DEFAULT_TAX);


    }
}

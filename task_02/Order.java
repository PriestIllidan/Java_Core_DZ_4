package task_02;

/*
Шаг 1 (п.1) Написать классы
- заказ (объект покупатель, объект товар, количество).
 */

public class Order {
    private Customer customer;
    private Product product;
    private int amount;

    private double price;


    public Order(Customer customer, Product product, int amount) {
        this.customer = customer;
        this.product = product;
        this.amount = amount;
        this.price = product.getPrice() * amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}

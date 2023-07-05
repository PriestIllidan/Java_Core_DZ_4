package task_02;

import java.util.Random;

public class App {
    /*
    Шаг 3 (п.2) Создать
    - массив покупателей (2 элемента);
    - массив товаров (5 элементов);
    - массив заказов (пустой на 5 элементов).
     */
    private static Customer[] customers = new Customer[2];
    private static Product[] products = new Product[5];

    /*
    Шаг 4 (п.5) Вызвать метод совершения покупки несколько раз таким
    образом, чтобы заполнить массив покупок возвращаемыми значениями.
    Обработать исключения следующим образом (в заданном порядке):
    - если был передан неверный товар - вывести в консоль сообщение
    об ошибке, не совершать данную покупку;
    - если было передано неверное количество - купить товар в
    количестве 1;
    - если был передан неверный пользователь - завершить работу
    приложения с исключением.
    Шаг 5 (пп.4,5,6) Если в метод передан несуществующий покупатель - метод
    должен выбросить исключение CustomerException, если передан
    несуществующий товар, метод должен выбросить исключение ProductException,
    если было передано отрицательное или слишком большое значение количества
    (например, 100), метод должен выбросить исключение AmountException.
     */
    public static Order buy(String phoneNumber, String productName, int amount)
            throws CustomerException, ProductException, AmountException {
        Customer customer = null;
        Product product = null;
        for (Customer cust : customers) {
            if (cust.getPhoneNumber().equals(phoneNumber)) {
                customer = cust;
                break;
            }
        }
        if (customer == null) {
            throw new CustomerException("Customer not found!");
        }
        for (Product prod : products) {
            if (prod.getProductName().equals(productName)) {
                product = prod;
                break;
            }
        }
        if (product == null) {
            throw new ProductException("Product not found!");
        }
        if (amount < 1 || amount > 100) {
            throw new AmountException("Amount entered incorrectly!");
        }
        return new Order(customer, product, amount);
    }

    public static void main(String[] args) {
        /*Вызвать метод совершения покупки несколько раз таким образом, чтобы
    заполнить массив покупок возвращаемыми значениями. Обработать
    исключения следующим образом (в этом порядке):
    ● если был передан неверный товар - вывести в консоль сообщение об
    ошибке, не совершать данную покупку
    ● если было передано неверное количество - купить товар в количестве 1
    ● если был передан неверный пользователь - завершить работу приложения
    с исключением.
    Вывести в консоль итоговое количество совершённых покупок после
    выполнения приложения.
         */

        customers[0] = new Customer("Ivan", "Ivanov", 25, "11111", Customer.Gender.MALE);
        customers[1] = new Customer("Elena", "Petrova", 40, "22222", Customer.Gender.FEMALE);

        products[0] = new Product("Milk", 80.5);
        products[1] = new Product("Eggs", 90);
        products[2] = new Product("Bread", 40.25);
        products[3] = new Product("Oil", 125.8);
        products[4] = new Product("Water", 40);

        Order[] orders = new Order[5];
        int count = 0;
        String[] phones = {"33333", "11111", "11111", "22222", "22222"};
        String[] productNames = {"Oil", "Bread", "Soup", "Bread", "Bread"};

        for (int i = 0; i < orders.length; i++) {
            try {
                orders[i] = buy(phones[i], productNames[i], 4 - i);
                count++;
            } catch (CustomerException e) {
                e.printStackTrace();
            } catch (ProductException e) {
                e.printStackTrace();
            } catch (AmountException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < orders.length; i++) {
            if (!(orders[i] == null)) {
                System.out.println("Phone numbers: " + orders[i].getCustomer().getPhoneNumber() + "; "
                        + "Product name: " + orders[i].getProduct().getProductName() + "; "
                        + "Amount of goods: " + orders[i].getAmount() + "; "
                        + "Unit price: " + orders[i].getProduct().getPrice() + "; "
                        + "Price without discount: " + orders[i].getProduct().getPrice() * orders[i].getAmount() + "; "
                        + "Discount price: " + orders[i].getProduct().getPrice() * orders[i].getAmount() * Discount.TWENTY.getVALUE());
            }
        }
        System.out.println("Number of completed orders = " + count);
    }
}


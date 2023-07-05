package task_02;

/*
Шаг 2 (п.4) Если  передан
несуществующий товар, метод должен выбросить исключение
ProductException.
 */

public class ProductException extends Exception {
    public ProductException(String message) {
        super(message);
    }
}

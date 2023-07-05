package task_02;

/*
Шаг 2 (п.4) Если в метод передан несуществующий покупатель - метод
должен выбросить исключение CustomerException.
 */

public class CustomerException extends Exception {
    public CustomerException(String message) {
        super(message);
    }
}

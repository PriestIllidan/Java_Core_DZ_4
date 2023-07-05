package task_02;

/*
Шаг 2 (п.4) Если было передано отрицательное или слишком большое
значение количества (например, 100), метод должен выбросить
исключение AmountException.
 */

public class AmountException extends Exception {
    public AmountException(String message) {
        super(message);
    }
}

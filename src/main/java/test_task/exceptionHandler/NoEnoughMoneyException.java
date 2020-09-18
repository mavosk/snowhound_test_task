package test_task.exceptionHandler;

public class NoEnoughMoneyException extends Exception {

    public NoEnoughMoneyException(String message) {
        super(message);
    }
}

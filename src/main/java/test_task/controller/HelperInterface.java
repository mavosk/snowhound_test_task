package test_task.controller;

import java.util.Random;

public interface HelperInterface {
     Random random = new Random();

     default Long generateCode() {
        return (long) (random.nextInt((9999 - 100) + 1) + 10);
    }
}

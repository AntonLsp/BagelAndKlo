package restaurant;

import logger.LoggerFactory;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();
        Scanner scanner = new Scanner(System.in);
        Display display = new Display(LoggerFactory.getLogger("logger"));
        restaurant.setDisplay(display);
        Input input = new Input();
        input.setScanner(scanner);
        restaurant.setInputSystem(input);
        OperationExecutor operationExecutor = new OperationExecutor();
        operationExecutor.getOperation("NEW").doAutoOperation(restaurant,"BAGEL 5 20"); // [Nom] [Prix] [Quantité]
        operationExecutor.getOperation("NEW").doAutoOperation(restaurant,"BURGER 4 10");
        operationExecutor.getOperation("NEW").doAutoOperation(restaurant,"SMOOTHIE 3 30");
        operationExecutor.getOperation("NEW").doAutoOperation(restaurant,"COFFEE 1 10000");

        display.title();
        boolean run = true;
        while(run)
        {
            run = operationExecutor.operate(restaurant);
        }
    }
}

package restaurant;

import logger.src.logger.LoggerFactory;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Scanner scanner = new Scanner(System.in);
        Display display = new Display(LoggerFactory.getLogger("logger"));
        restaurant.setDisplay(display);
        Input input = new Input();
        input.setScanner(scanner);


    }
}

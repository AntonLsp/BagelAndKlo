package restaurant;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input(){
    }

    public void setScanner(Scanner scanner)
    {
        this.scanner = scanner;
    }

    public String getInput(){
        String input = scanner.next();
        input.toUpperCase();
        switch(input)
        {
            case "HELP":
                break;
            case "NEW PRODUCT":
                break;
            case "LIST":
                break;
            case "ADD":
                break;
            case "CLOSE":
                break;
            case "SHOW SALES":
                break;
            case "QUIT":
                break;
            default:
                break;
        }
        return input;
    }
}

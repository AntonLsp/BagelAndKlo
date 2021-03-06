package restaurant;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {
    private Scanner scanner;

    public Input(){
    }

    public void setScanner(Scanner scanner)
    {
        this.scanner = scanner;
    }

    // Récupère du texte en entrée
    public String getTextInput(){
        String input = scanner.next();
        input = input.toUpperCase();
        return input;
    }

    // Demande une entrée texte utilisateur et boucle si la demande est incorrecte
    public String requestTextInput(String request, Display display)
    {
        String input = "";
        display.show(request);
        do {
            input = this.getTextInput();
            if(!Pattern.matches("[a-zA-Z]+",input)) display.show("Please enter only letters, not numbers or special characters.");
        }while(!Pattern.matches("[a-zA-Z]+",input) );
        return input;
    }

    // Demande une entrée entier utilisateur et boucle si la demande est incorrecte
    public int requestIntegerInput(String request, Display display)
    {
        int input = -1;
        do {
            display.show(request);
            try {
                input = scanner.nextInt();
            }
            catch (InputMismatchException e){
                scanner.nextLine();
                display.incorrectIntegerInput();
            }
        }while(input < 0 );
        return input;
    }

    // Demande une entrée entier utilisateur et boucle si la demande est incorrecte
    public float requestFloatInput(String request, Display display)
    {
        float input = -1;
        display.show(request);
        do {
            try {
                input = scanner.nextFloat();
            }
            catch (InputMismatchException e){
                scanner.nextLine(); // Libère le buffer pour éviter une boucle infinie
                display.incorrectFloatInput();
            }
        }while(input < 0 );
        return input;
    }
}

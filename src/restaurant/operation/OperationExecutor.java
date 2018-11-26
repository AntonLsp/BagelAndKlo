package restaurant.operation;

import restaurant.Display;
import restaurant.Input;
import restaurant.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class OperationExecutor {
    private List<Operation> operations = new ArrayList<Operation>();
    private Input inputSystem;
    private Display display;

    public OperationExecutor() {
        operations.add(new NewProductOp());
        operations.add(new ListProductsOp());
    }

    // Effectue une requête à l'utilisateur et exécute l'opération
    public boolean operate(Restaurant restaurant)
    {
        display = restaurant.getDisplay();
        inputSystem = restaurant.getInputSystem();

        String command = inputSystem.requestTextInput("What do you want to do ?",display);
        if(command.equals("HELP")) {
            listAvailableOperations();
            return true;
        }
        if(command.equals("QUIT")) return false;
        // On itère parmi les opérations disponibles et si la requête correspond, on l'effectue
        for(int i = 0 ; i < operations.size() ; i++){
            Operation op = operations.get(i);
            if( op.toString().equals(command) ){
                op.doOperation(restaurant);
                return true;
            }
        }
        display.show("Unknown request.");
        return true;
    }

    public void listAvailableOperations(){
        display.show("Available requests :");
        for(Operation op : operations){
            display.show(" - " + op.toString() + " : " + op.getDescription());
        }
        display.show(" ");
    }
}

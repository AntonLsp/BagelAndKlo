package restaurant;

import java.util.ArrayList;
import java.util.List;

public class OperationExecutor {
    private List<Operation> operations = new ArrayList<Operation>();
    private Input inputSystem;
    private Display display;

    public OperationExecutor() {
        // C'est ici qu'il faut ajouter les opérations disponibles de base.
        operations.add(new NewProductOp());
        operations.add(new ListProductsOp());
        operations.add(new AddToBillOp());
        operations.add(new CloseBillOp());
        operations.add(new ShowBillOp());
        operations.add(new ShowRevenueOp());
    }

    // Effectue une requête à l'utilisateur et exécute l'opération
    public boolean operate(Restaurant restaurant)
    {
        display = restaurant.getDisplay();
        inputSystem = restaurant.getInputSystem();

        String command = inputSystem.requestTextInput("What do you want to do ? (type help for commands list)",display);
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
    // On itère parmi les opérations disponibles et si on la trouve, on la retourne
    public Operation getOperation(String name){
        for(int i = 0 ; i < operations.size() ; i++){
            Operation op = operations.get(i);
            if( op.toString().equals(name) ){
                return op;
            }
        }
        return null;
    }

    // Affiche la liste des opérations disponibles
    public void listAvailableOperations(){
        display.show("Available requests :");
        for(Operation op : operations){
            display.show(" - " + op.toString() + " : " + op.getDescription());
        }
        display.show(" - QUIT : Exits the program.");
    }
}

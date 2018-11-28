package restaurant;

import restaurant.Restaurant;

public interface Operation {
    // Méthode principale qui effectue l'opération
    public void doOperation(Restaurant restaurant);
    // Méthode alternative qui effectue l'opération sans entrée utilisateur
    public void doAutoOperation(Restaurant restaurant, String command);
    // Retourne la description de l'opération
    public String getDescription();
    // Retourne le nom de la commande à taper
    public String toString();
}

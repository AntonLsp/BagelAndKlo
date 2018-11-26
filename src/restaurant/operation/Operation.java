package restaurant.operation;

import restaurant.Restaurant;

public interface Operation {
    public void doOperation(Restaurant restaurant);
    public String getDescription();
    public String toString();
}

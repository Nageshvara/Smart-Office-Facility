import composite.*;;

public class Main {
    public static void main(String[] args) {
        InventoryComponent sword = new Item("Sword", 5);
        InventoryComponent shield = new Item("Shield", 7);
        InventoryComponent potion = new Item("Potion", 1);

        InventoryComponent smallBag = new InventoryGroup("Small Bag");
        smallBag.add(sword);
        smallBag.add(potion);

        InventoryComponent largeBag = new InventoryGroup("Large Bag");
        largeBag.add(smallBag);
        largeBag.add(shield);

        InventoryComponent playerInventory = new InventoryGroup("Player Inventory");
        playerInventory.add(largeBag);

        playerInventory.displayInventory();
    }
}

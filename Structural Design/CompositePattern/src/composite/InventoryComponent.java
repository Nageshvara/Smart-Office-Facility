package composite;

public abstract class InventoryComponent {
    public void add(InventoryComponent inventoryComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(InventoryComponent inventoryComponent) {
        throw new UnsupportedOperationException();
    }

    public InventoryComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public int getWeight() {
        throw new UnsupportedOperationException();
    }

    public void displayInventory() {
        throw new UnsupportedOperationException();
    }
}

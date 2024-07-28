package composite;

import java.util.ArrayList;
import java.util.List;

public class InventoryGroup extends InventoryComponent {
    private List<InventoryComponent> inventoryComponents = new ArrayList<>();
    private String name;

    public InventoryGroup(String name) {
        this.name = name;
    }

    @Override
    public void add(InventoryComponent inventoryComponent) {
        inventoryComponents.add(inventoryComponent);
    }

    @Override
    public void remove(InventoryComponent inventoryComponent) {
        inventoryComponents.remove(inventoryComponent);
    }

    @Override
    public InventoryComponent getChild(int i) {
        return inventoryComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayInventory() {
        System.out.println("Inventory Group: " + getName());
        for (InventoryComponent inventoryComponent : inventoryComponents) {
            inventoryComponent.displayInventory();
        }
    }
}

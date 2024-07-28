package composite;

public class Item extends InventoryComponent {
    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void displayInventory() {
        System.out.println("Item: " + getName() + ", Weight: " + getWeight());
    }
}

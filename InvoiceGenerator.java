import java.util.ArrayList;
import java.util.List;

class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotal() {
        return price * quantity;
    }

    public String toString() {
        return name + " - $" + price + " x " + quantity;
    }
}

class Invoice {
    private List<Item> items;

    public Invoice() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getTotal();
        }
        return total;
    }

    public void printInvoice() {
        System.out.println("Invoice:");
        for (Item item : items) {
            System.out.println(item.toString());
        }
        System.out.println("Total: $" + calculateTotal());
    }
}

public class InvoiceGenerator {
    public static void main(String[] args) {
        Invoice invoice = new Invoice();

        Item item1 = new Item("Product 1", 10.99, 2);
        invoice.addItem(item1);

        Item item2 = new Item("Product 2", 15.99, 3);
        invoice.addItem(item2);

        Item item3 = new Item("Product 3", 7.99, 1);
        invoice.addItem(item3);

        invoice.printInvoice();

        invoice.removeItem(item2);

        System.out.println("Updated Invoice:");
        invoice.printInvoice();
    }
}

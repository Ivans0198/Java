package advanced;

public class Varargs {

    public static void main(String[] args) {

        String[] shoppingList = {"Bread", "Eggs", "Milk", "Bananas"};

        printShoppingList(shoppingList);
        printShoppingList("Bread", "Eggs", "Milk");
    }

    public static void printShoppingList(String... list) {
        //list acts like an array
        for(String product: list) {
            System.out.println(product);
        }
    }


}

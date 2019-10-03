public class Inventory {

public static int item = 0;
public static int index = 0;

public static void main() {
        // Initialize stats
        int health = 10;
        int mind = 10;
        int damage = 2;

        int inventory[][] = new int[20][20];

}

public static boolean addToInventory(int inventory[][], int item) {

        try {

                inventory[index++][0] = item;
                return true;

        } catch(Exception e) {

                return false;

        }


}

}

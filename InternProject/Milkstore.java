package InternProject;
import java.util.Scanner;

public class Milkstore {
    public static int Identity;
    public static int idarea;
    public static int attempt = 0;

    public static void main(String[] args) {
        Introduction();
    }

    public static String[] arr = { "Madurai", "Chennai" };
    public static int[] pincode3 = new int[4];
    public static int[] pincode2 = new int[4];

    public static void Introduction() {

        System.out.println("\nWelcome to Aavin Diary!!!");
        System.out.println(
                "We are a farmer friendly organization, which provides the best and fresh products straight from the Village for your daily use.");
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + "." + arr[i]);
        } // to print the locations
        Scanner in = new Scanner(System.in);
        int j = -1;
        int m = 0;
        while (j == -1) { // to iterate indefinitely until the given location matches the available
                          // location
            if (m < 5) {
                System.out.println("\nEnter the location name (" + arr[0] + " or " + arr[1] + ") :");
                String choice = in.nextLine().trim();// to get location from the user

                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].equalsIgnoreCase(choice)) {
                        System.out.println("Location: " + arr[i]);
                        j = i;
                    }
                }
                m++;
            } else {
                System.out.println("You have exceeded 5 times!!");
                System.exit(0);
            }
        }
        Identity = StoreLocations(j, arr);
        System.out.println("ID : " + Identity);
        MilkStores(Identity, arr);

    }

    public static int StoreLocations(int j, String[] arr) { // to return the id
        int[] id = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            id[i] = i;
        }
        return id[j];
    }

    public static void MilkStores(int Identity, String[] arr) {
        try {
            String[] pin;
            Scanner place = new Scanner(System.in);// to get specific area from the user
            if (Identity == 0) {
                pin = new String[] { "Annanagar", "625002", "Yanaikkal", "625001", "Simakkal", "625003", "Nelpettai",
                        "625004" };
                for (int a = 0, i = 0; a < pin.length; a = a + 2, i++) {
                    pincode2[i] = Integer.parseInt(pin[a + 1]);
                    System.out.println(((a / 2) + 1) + "." + pin[a] + "-" + pin[a + 1]);
                }

            } else {
                pin = new String[] { "Gandhinagar", "625012", "Ambattur", "625011", "Adyar", "625013", "Royapuram",
                        "625014" };
                for (int a = 0, i = 0; a < pin.length; a = a + 2, i++) {
                    pincode3[i] = Integer.parseInt(pin[a + 1]);
                    System.out.println(((a / 2) + 1) + "." + pin[a] + "-" + pin[a + 1]);
                }
            }
            int k = -1;
            while (k == -1) { // to iterate indefinitely until the given number matches the available location

                System.out.println("\nChoose the location from (1 to 4): ");
                int ans = place.nextInt();
                if (ans < pin.length || ans >= 0) {
                    idarea = (ans - 1) * 2;
                    System.out.println("\nMilk products at " + pin[idarea] + "!!!");
                    k = 1;
                }
            }
            MilkProduct();
        } catch (Exception E) {
            System.out.println("Invalid choice");
            attempt++;
            if (attempt < 5) {
                MilkStores(Identity, arr);
            } else {
                System.out.println("\n you have exceeded the limit");
                System.exit(0);
            }
        }
    }

    public static void MilkProduct() {
        String[] products = { "Milk", "Cheese", "Butter", "Curd", "Sweets" };
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ".  " + products[i]);
        }
        milk2.ProductDetails();
    }
}



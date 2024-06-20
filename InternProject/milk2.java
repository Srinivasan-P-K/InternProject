package InternProject;

import java.util.HashMap;
import java.util.Scanner;

public class milk2 {
    public static int prodno;
    public static int noofproduct;
    public static int attempt1 = 0;
    public static int rem = 0;
    public static String[] productDetails = new String[2];
    public static HashMap<Integer, String[]> productdet = new HashMap<>();
    public static double wholeprice = 0;
    private static boolean valids = true;

    public static void ProductDetails() {

        productdet = new HashMap<>();
        productdet.put(0, new String[] { "Milk", "35" });
        productdet.put(1, new String[] { "Cheese", "100" });
        productdet.put(2, new String[] { "Butter", "40" });
        productdet.put(3, new String[] { "Curd", "20" });
        productdet.put(4, new String[] { "Sweets", "150" });

        Scanner pro1 = new Scanner(System.in);
        int quit = -1;
        int l = -1;

        try {
            while (quit == -1) { // inorder to get the product iteratively
                while (l == -1) { // to get the required product name
                    System.out.println("\nchoose the product from (1 to 5): ");
                    int product = pro1.nextInt();
                    prodno = product - 1;
                    if (product <= productdet.size() && product > 0) { // to check the given product with available
                                                                       // product
                        productDetails = productdet.get(prodno);
                        System.out.println("\n" + productDetails[0] + "!Good choice!!!");
                        System.out.println("#Price per pack for " + productDetails[0] + " is Rs." + productDetails[1]);
                        l = 1;
                    } else {
                        System.out.println("Enter the available product!!");
                    }
                }
                int identity = Milkstore.Identity;// to get index of location
                int idofarea = Milkstore.idarea;// to get index of area
                int[] availability;
                if (identity == 0) { // location
                    if (idofarea == 0) // area
                        availability = new int[] { 31, 50, 40, 90, 20 }; // availability in that area
                    else if (idofarea == 2)
                        availability = new int[] { 35, 55, 40, 50, 22 };
                    else if (idofarea == 4)
                        availability = new int[] { 36, 60, 30, 95, 28 };
                    else
                        availability = new int[] { 40, 60, 50, 80, 99 };
                } else {
                    if (idofarea == 0)
                        availability = new int[] { 39, 50, 40, 90, 20 };
                    else if (idofarea == 2)
                        availability = new int[] { 35, 55, 40, 50, 22 };
                    else if (idofarea == 4)
                        availability = new int[] { 36, 60, 30, 95, 28 };
                    else
                        availability = new int[] { 45, 60, 50, 80, 110 };
                }
                int totalavail = availability[prodno] - rem;
                if (totalavail < 0) {
                    totalavail = 0;
                }
                System.out.println("total availability: " + totalavail);
                System.out.println("\nenter the no of product(enter in numbers):");
                int check = -1;
                while (check != 1) { // to get no of product within the availability
                    noofproduct = pro1.nextInt();
                    if (noofproduct < 0) { // you can only order upto 15 products
                        System.out.println("no of product should not be negative");
                        attempt1++;
                        if (attempt1 > 5) {
                            System.out.println("you have exceeded the limit");
                            System.exit(0);
                        }
                        Milkstore.MilkProduct();
                    } else if (totalavail <= 0) {
                        System.out.println("there are no stocks available" + "\nyou can choose from another product");
                        Milkstore.MilkProduct();
                    } else if (noofproduct > totalavail) {
                        System.out.println("no of stock is lesser than required\nchoose from another product");
                        Milkstore.MilkProduct();
                    } else if (noofproduct > 15) {
                        System.out.println("no of product should not exceed 15\n choose again");
                        Milkstore.MilkProduct();
                    } else {
                        check = 1;
                    }
                }

                rem += noofproduct;

                int totalavail1 = availability[prodno] - rem;
                if (totalavail1 < 0) {
                    totalavail1 = 0;
                }

                double totalprice = Price.CalculatePrice(noofproduct, productDetails);
                wholeprice += totalprice;
                System.out.println("You must be a registered user to book the items");

                if (valids) {
                    User.Register();
                    valids = false;
                }

                System.out.println("#To be booked : " + noofproduct);
                System.out.println("#Available Quantity : " + totalavail1);
                System.out.println("\nWow Great Booking " + noofproduct + " " + productDetails[0] + " Packs");
                System.out.println("# Total Pricing : Rs." + wholeprice + "/-(including GST of 5%)");
                System.out.println("To exit press any number other than 2 or 3"
                        + "\nTo choose product from another location press 2:"
                        + "\nTo choose another product press 3:");
                quit = pro1.nextInt();
                if (quit == 2) {
                    Milkstore.Introduction();
                } else if (quit == 3) {
                    Milkstore.MilkProduct();
                }

                else {
                    System.exit(0);
                }

            }
        } catch (Exception e) {
            attempt1++;
            if (attempt1 < 5) {
                Milkstore.MilkProduct();
            } else {
                System.out.println("you have exceeded the limit");
                System.exit(0);
            }
        }

    }
}



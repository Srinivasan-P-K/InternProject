package InternProject;

import java.util.*;
import java.io.Console;

public class User {
    public static Map<Object, List<Object>> userDatabase = new HashMap<>(); // to store the register details
    public static char[] pass;
    public static char[] pass1;

    public static void Register() {
        int k = 0;
        int q = -1;
        Scanner scan = new Scanner(System.in);
        Console con = System.console();
        String[] arr1 = Milkstore.arr;
        int[] pinn1 = Milkstore.pincode2;
        int[] pinn2 = Milkstore.pincode3;

        while (q == -1) {
            System.out.println("Do you want to register(Yes/No):");
            String reg = scan.next().toUpperCase().trim(); // inorder to get yes or no for registration

            if (k < 2) {
                if (reg.equals("YES")) {
                    System.out.println("Fill in the details");
                    q = 1;
                } else if (reg.equals("NO")) {
                    System.exit(0);
                    q = 1;
                } else {
                    System.out.println("Invalid Input");
                    k++;
                }
            } else {
                System.exit(0);
            }
        }
        String username = "";
        int pincode = 0;
        String password = "";
        String repassword = "";
        boolean valid = false;
        int m = 0;
        int n = 0;
        int l = 0;
        while (username.length() < 4) {
            if (m < 3) {
                System.out.println("Enter the username (It should contain four or more characters):");
                username = scan.next().trim();
                m++;
            } else {
                System.out.println("You have exceede 3 times");
                System.exit(0);
            }
        }
        if (userDatabase.containsKey(username)) {
            System.out.println("\n The username is already used,please register a new name");
            Register();
        }
        int b = 0;
        String location = "";
        while (b == 0) {
            System.out.println("Available location");
            for (int i = 0; i < arr1.length; i++) {
                System.out.println((i + 1) + "." + arr1[i]);
            }
            System.out.println("enter from the given location:");
            location = scan.next().trim();
            for (int i = 0; i < arr1.length; i++) {
                if (location.equalsIgnoreCase(arr1[i])) {
                    b = 1;
                    break;
                }
            }
        }

        while (!valid) {
            try {
                System.out.println("Available pincode :");
                {
                    if (location.equalsIgnoreCase("madurai")) {
                        for (int i = 0; i < pinn1.length; i++) {
                            System.out.println(pinn1[i]);
                        }
                        System.out.println("enter the pincode(enter in numbers):");
                        String pincode1 = scan.next();
                        pincode = Integer.parseInt(pincode1);
                        for (int i = 0; i < pinn1.length; i++) {
                            if (pincode == pinn1[i]) {
                                valid = true;
                            }
                        }
                        System.out.println("Invalid input");

                    } else {
                        for (int i = 0; i < pinn2.length; i++) {
                            System.out.println(pinn2[i]);
                        }
                        System.out.println("enter the pincode(enter in numbers):");
                        String pincode1 = scan.next();
                        pincode = Integer.parseInt(pincode1);
                        for (int i = 0; i < pinn2.length; i++) {
                            if (pincode == pinn2[i]) {
                                valid = true;
                            }
                        }
                        System.out.println("Invalid input");
                    }
                }
            } catch (Exception e) {
                n++;
                if (n < 3) {
                    System.out.println("Invalid input");
                } else {
                    System.out.println("You have exceede 3 times");
                    System.exit(0);
                }
            }
        }

        while (password.length() != 8) {
            if (l < 3) {
                System.out.println("enter the password (It should contain 8 characters):");
                try {
                    pass = con.readPassword("********");
                    password = new String(pass);
                    l++;
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                System.out.println("you have exceeded 3 times!!");
                System.exit(0);
            }

        }

        while (!password.equals(repassword)) {
            System.out.println("retype the password:");
            try {
                pass1 = con.readPassword("********");
                repassword = new String(pass1);
                if (password.equals(repassword)) {
                    System.out.println("Your password is validated");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        List<Object> userDetails = new ArrayList<>(); // to store password,location,userId and pincode in arraylist
        String userID = generateid(username);
        userDetails.add(userID);

        userDetails.add(password);
        userDetails.add(location);
        userDetails.add(pincode);

        userDatabase.put(username, userDetails); // to store username and userDetails in HashMap
        System.out.println("User Registration is completed");
        System.out.println(userDatabase);
        User2.login();

    }

    public static String generateid(String username) {
        Random random = new Random();
        String firstfour = username.substring(0, Math.min(username.length(), 4));
        int randomno = random.nextInt(900) + 100;
        String userno = firstfour + randomno;
        return userno;
    }
}


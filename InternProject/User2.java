package InternProject;

import java.io.Console;
import java.util.*;

public class User2 {
    public static void login() {
        Map<Object, List<Object>> userDatabase1 = User.userDatabase;
        Console con1 = System.console();

        if (userDatabase1.isEmpty()) {
            System.out.println("There are no registered user , so you have to register first!!");
            User.Register();
        } else {
            System.out.println("Login form");
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nEnter the username:");
            String lusername = scanner.next().trim();
            if (userDatabase1.containsKey(lusername)) {
                System.out.println("--------------");
            } else {
                System.out.println("This username is not registered");
                login();
            }
            int esc = -1;
            String lpassword = "";
            char[] pass2;
            while (esc == -1) {
                System.out.println("Enter the password:");
                List<Object> userDetails1 = userDatabase1.get(lusername);
                String storedpswd = (String) userDetails1.get(1);

                try {
                    pass2 = con1.readPassword("********");
                    lpassword = new String(pass2);
                    if (storedpswd.equals(lpassword)) {
                        System.out.println("Your password is validated");
                        esc = 1;
                    } else {
                        System.out.println("password is incorrect. retry!!!");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        }

    }
}



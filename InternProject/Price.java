package InternProject;

import java.util.HashMap;

public class Price {

    public static double CalculatePrice(int noofproduct, String[] productDetails) {
        // HashMap<Integer,String[]> productdet1 = milk2.productdet;
        int pricedetails = Integer.parseInt(productDetails[1]);
        int total = pricedetails * noofproduct;
        double totgst = ((5.0 / 100) * total) + total;
        return totgst;

    }
}



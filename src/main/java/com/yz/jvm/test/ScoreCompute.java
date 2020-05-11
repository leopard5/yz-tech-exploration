package com.yz.jvm.test;

public class ScoreCompute {
    public static final double DEFAULT_HIS_CTR = 0.0617902306836393;
    public static final double DEFAULT_HIS_CVR = 0.12724432684889203;
    public static final double DEFAULT_HIS_BID = 6.376146885747841;
    public static final double DEFAULT_HIS_PRICE = 5578.529380027075;


    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        double a_factor = 10;
        double b_factor = 0.1;
        double ctr = -1;
        double cvr = 0;
        double bid = 0;
        double price = 0;

        if (ctr <= 0) {
            ctr = DEFAULT_HIS_CTR;
        }
        if (cvr <= 0) {
            cvr = DEFAULT_HIS_CVR;
        }
        if (bid <= 0) {
            bid = DEFAULT_HIS_BID;
        }
        if (price <= 0) {
            price = DEFAULT_HIS_PRICE;
        }


        double result = ctr * (1 + a_factor * cvr * ctr) * (bid + b_factor * price * cvr);
        System.out.println(result);
    }
}

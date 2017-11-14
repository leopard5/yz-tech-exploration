package com.yz.jvm.as;

import com.yz.jvm.as.vo.AsCeeDataVO;

import java.math.BigDecimal;

public class AsMain {
    public static final BigDecimal CONS_LOG = BigDecimal.valueOf(2.3);

    public static void main(String[] args) {
        BigDecimal test = BigDecimal.TEN;
        BigDecimal test1 = BigDecimal.valueOf( Math.log(test.doubleValue()));

        System.out.println(CONS_LOG.multiply(test1));
    }

    public static Boolean calcASAS20(AsCeeDataVO baseLine, AsCeeDataVO twoWeek){
        // yu
        return false;
    }

    public static Boolean calcASAS40(AsCeeDataVO baseLine, AsCeeDataVO twoWeek){
        return false;
    }

    public static Boolean calcASASpr(AsCeeDataVO baseLine, AsCeeDataVO twoWeek){
        return false;
    }

    public static Boolean calcASAS56(AsCeeDataVO baseLine, AsCeeDataVO twoWeek){
        return false;
    }


}
package com.yz.jvm.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collection;

/**
 * File Name:BigDecimalUtils
 *
 * @author:panwang
 * @description: Big Decimal Calc Utils
 * @date:2017/11/24
 * @version:V1.0
 * @see:jdk8 Copyright (c) 2017, qiyazhong@163.com All Rights Reserved.
 */
public class BigDecimalUtils {
    private static final String DECIMAL_DEFAULT = "0.00";

    private static final DecimalFormat DECIMALFORMAT_DEFAULT = new DecimalFormat("0.00");

    /**
     * 将数值转换为BigDecimal
     *
     * @param o object
     * @return
     */
    public static BigDecimal objectToBigDecimal(Object o) {
        return BigDecimal.valueOf(Double.valueOf(String.valueOf(o)));
    }

    /**
     * 将两个数值相加并返回浮点类型
     *
     * @param o1 object
     * @param o2 object
     * @return bigDecimal
     */
    public static BigDecimal plus(Object o1, Object o2) {
        return BigDecimal.valueOf(Double.valueOf(String.valueOf(o1)))
                .add(BigDecimal.valueOf(Double.valueOf(String.valueOf(o2))));
    }

    /**
     * 将传入的数值累加返回，入参必须是数字，任意类型
     *
     * @param o objects
     * @return bigDecimal
     */
    public static BigDecimal objectsTotalToBD(Object... o) {
        return Arrays.stream(o)
                .map(v -> BigDecimal.valueOf(Double.valueOf(String.valueOf(v))))
                .reduce(BigDecimal::add).get();
    }

    /**
     * 将集合的所有数值做累计操作,collection元素任意类型
     *
     * @param t   extends collection
     * @param <T> object
     * @return
     */
    public static <T extends Collection<?>> BigDecimal arrTotalToBD(T t) {
        return t.stream()
                .map(v -> BigDecimal.valueOf(Double.valueOf(String.valueOf(v))))
                .reduce(BigDecimal::add).get();
    }

    /**
     * 参数一减去参数二返回浮点类型
     *
     * @param o1 object
     * @param o2 object
     * @return
     */
    public static BigDecimal subtract(Object o1, Object o2) {
        return BigDecimal.valueOf(Double.valueOf(String.valueOf(o1)))
                .subtract(BigDecimal.valueOf(Double.valueOf(String.valueOf(o2))));
    }

    /**
     * 将参数一减去后续所有数值，任意类型
     *
     * @param total object
     * @param o     objects
     * @return
     */
    public static BigDecimal subtractObjectsToBD(Object total, Object... o) {
        return Arrays.stream(o)
                .map(v -> BigDecimal.valueOf(Double.valueOf(String.valueOf(v))))
                .reduce(BigDecimal.valueOf(Double.valueOf(String.valueOf(total))), (a, b) -> a.subtract(b));
    }

    /**
     * 将参数一减去后续集合中所有数值，collection元素任意类型
     *
     * @param total object
     * @param t     extends collection
     * @param <T>   object
     * @return
     */
    public static <T extends Collection<?>> BigDecimal subtractArrToBD(Object total, T t) {
        return t.stream()
                .map(v -> BigDecimal.valueOf(Double.valueOf(String.valueOf(v))))
                .reduce(BigDecimal.valueOf(Double.valueOf(String.valueOf(total))), (a, b) -> a.subtract(b));
    }

    /**
     * 计算两个数值的乘积
     *
     * @param o1 object
     * @param o2 object
     * @return
     */
    public static BigDecimal multiply(Object o1, Object o2) {
        return BigDecimal.valueOf(Double.valueOf(String.valueOf(o1)))
                .multiply(BigDecimal.valueOf(Double.valueOf(String.valueOf(o2))));
    }

    /**
     * 计算多个数值的乘积，任意类型长度
     *
     * @param o objects
     * @return
     */
    public static BigDecimal multiplyObjectsToBD(Object... o) {
        return Arrays.stream(o)
                .map(v -> BigDecimal.valueOf(Double.valueOf(String.valueOf(v))))
                .reduce(BigDecimal::multiply).get();
    }

    /**
     * 计算集合中数值的乘积，collection元素任意类型
     *
     * @param t   extends collection
     * @param <T> object
     * @return
     */
    public static <T extends Collection<?>> BigDecimal multiplyArrToBD(T t) {
        return t.stream()
                .map(v -> BigDecimal.valueOf(Double.valueOf(String.valueOf(v))))
                .reduce(BigDecimal::multiply).get();
    }

    /**
     * 两个数相除四舍五入
     * 根据指定保留小数，如果不指定则默认保留两位
     *
     * @param o1 object
     * @param o2 object
     * @return
     */
    public static BigDecimal divide(Object o1, Object o2, Integer i) {
        if (i == null) {
            i = 2;
        }
        return BigDecimal.valueOf(Double.valueOf(String.valueOf(o1)))
                .divide(BigDecimal.valueOf(
                        Double.valueOf(String.valueOf(o2))), i, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 格式化浮点类型成指定的小数四舍五入,缺省格式0.00
     * 设置格式请看DecimalFormat
     *
     * @param o      object
     * @param format string
     * @return strng
     * @see java.text.DecimalFormat
     */
    public static String objectFormatToString(Object o, String format) {
        if (format == null) {
            format = DECIMAL_DEFAULT;
        }
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(
                BigDecimal.valueOf(Double.valueOf(String.valueOf(o))));
    }

    /**
     * 格式化浮点类型成指定的小数四舍五入,缺省格式0.00
     * 设置格式请看DecimalFormat
     *
     * @param o      object
     * @param format string
     * @return bigDecimal
     * @see java.text.DecimalFormat
     */
    public static BigDecimal objectFormatToBD(Object o, String format) {
        if (format == null) {
            format = DECIMAL_DEFAULT;
        }
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return BigDecimalUtils.objectToBigDecimal(
                decimalFormat.format(
                        BigDecimal.valueOf(Double.valueOf(String.valueOf(o)))));
    }
}

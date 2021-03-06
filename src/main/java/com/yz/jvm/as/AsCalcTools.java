package com.yz.jvm.as;

import com.alibaba.fastjson.JSON;
import com.yz.jvm.as.vo.AsCeeDataVO;
import com.yz.jvm.as.vo.AsResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.Bidi;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AsCalcTools {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsCalcTools.class);

    public static final BigDecimal CONS_LOG = BigDecimal.valueOf(2.3);

    /**
     * BigDecimal test = BigDecimal.TEN;
     * BigDecimal test1 = BigDecimal.valueOf( Math.log(test.doubleValue()));
     * System.out.println(CONS_LOG.multiply(test1));
     *
     * @param args
     */
    public static void main(String[] args) {

        AsCeeDataVO baseLine = new AsCeeDataVO();
        baseLine.setPga(BigDecimal.valueOf(6));
        baseLine.setPainScore(BigDecimal.valueOf(6));
        baseLine.setBasfi(BigDecimal.valueOf(4.9));
        baseLine.setInflammatoryReact(BigDecimal.valueOf(4.5));
        baseLine.setCrp(BigDecimal.valueOf(26.25));
        baseLine.setSpinalMobility(BigDecimal.valueOf(1));

        AsCeeDataVO twoWeek = new AsCeeDataVO();
        twoWeek.setPga(BigDecimal.valueOf(4));
        twoWeek.setPainScore(BigDecimal.valueOf(3.5));
        twoWeek.setBasfi(BigDecimal.valueOf(3));
        twoWeek.setInflammatoryReact(BigDecimal.valueOf(3.5));
        twoWeek.setCrp(BigDecimal.valueOf(2.46));
        twoWeek.setSpinalMobility(BigDecimal.valueOf(0));


        AsResultVO result = new AsResultVO();
        result.setAsas20(calcASAS20(baseLine, twoWeek));
        result.setAsas40(calcASAS40(baseLine, twoWeek));
        result.setAsasPr(calcASASpr(baseLine, twoWeek));
        result.setAsas56(calcASAS56(baseLine, twoWeek));

        System.out.println(JSON.toJSONString(result));
    }

    public static Boolean calcASAS20(AsCeeDataVO baseLine, AsCeeDataVO twoWeek) {
        return baseCalc(baseLine, twoWeek, 0.2, 1);
    }

    public static Boolean calcASAS40(AsCeeDataVO baseLine, AsCeeDataVO twoWeek) {
        return baseCalc(baseLine, twoWeek, 0.4, 2);
    }

    public static Boolean baseCalc(AsCeeDataVO baseLine, AsCeeDataVO twoWeek, double percentage, double score) {
        setDefaultValue(baseLine, BigDecimal.ZERO);
        setDefaultValue(twoWeek, BigDecimal.ZERO);

        //
        Set<String> fourKeys = new HashSet<>();
        fourKeys.add(ASASConsts.PGA);
        fourKeys.add(ASASConsts.PAINSCORE);
        fourKeys.add(ASASConsts.BASFI);
        fourKeys.add(ASASConsts.INFLAMMATORYREACT);

        Map<String, Boolean> improvementDegree = new HashMap<>();
        if (baseLine.getPga().compareTo(twoWeek.getPga()) > 0) {
            BigDecimal value1 = baseLine.getPga().subtract(twoWeek.getPga()).divide(baseLine.getPga(), 2, BigDecimal.ROUND_HALF_UP);
            if (value1.compareTo(BigDecimal.valueOf(percentage)) >= 0
                    && baseLine.getPga().subtract(twoWeek.getPga()).compareTo(BigDecimal.valueOf(score)) >= 0) {
                improvementDegree.put(ASASConsts.PGA, true);
            }
        }

        if (baseLine.getPainScore().compareTo(twoWeek.getPainScore()) > 0) {
            BigDecimal value2 = baseLine.getPainScore().subtract(twoWeek.getPainScore()).divide(baseLine.getPainScore(), 2, BigDecimal.ROUND_HALF_UP);
            if (value2.compareTo(BigDecimal.valueOf(percentage)) >= 0
                    && baseLine.getPainScore().subtract(twoWeek.getPainScore()).compareTo(BigDecimal.valueOf(score)) >= 0) {
                improvementDegree.put(ASASConsts.PAINSCORE, true);
            }
        }

        if (baseLine.getBasfi().compareTo(twoWeek.getBasfi()) > 0) {
            BigDecimal value3 = baseLine.getBasfi().subtract(twoWeek.getBasfi()).divide(baseLine.getBasfi(), 2, BigDecimal.ROUND_HALF_UP);
            if (value3.compareTo(BigDecimal.valueOf(percentage)) >= 0
                    && baseLine.getBasfi().subtract(twoWeek.getBasfi()).compareTo(BigDecimal.valueOf(score)) >= 0) {
                improvementDegree.put(ASASConsts.BASFI, true);
            }
        }

        if (baseLine.getInflammatoryReact().compareTo(twoWeek.getInflammatoryReact()) > 0) {
            BigDecimal value4 = baseLine.getInflammatoryReact().subtract(twoWeek.getInflammatoryReact()).divide(baseLine.getInflammatoryReact(), 2, BigDecimal.ROUND_HALF_UP);
            if (value4.compareTo(BigDecimal.valueOf(percentage)) >= 0
                    && baseLine.getInflammatoryReact().subtract(twoWeek.getInflammatoryReact()).compareTo(BigDecimal.valueOf(score)) >= 0) {
                improvementDegree.put(ASASConsts.INFLAMMATORYREACT, true);
            }
        }

        if (improvementDegree.size() >= 3) {
            if (improvementDegree.size() == 4) {
                return true;
            } else {
                fourKeys.removeAll(improvementDegree.keySet());
                for (String fourKey : fourKeys) {
                    switch (fourKey) {
                        case ASASConsts.PGA:
                            if (baseLine.getPga().compareTo(twoWeek.getPga()) >= 0) {
                                return true;
                            }
                            break;
                        case ASASConsts.PAINSCORE:
                            if (baseLine.getPainScore().compareTo(twoWeek.getPainScore()) >= 0) {
                                return true;
                            }
                            break;
                        case ASASConsts.BASFI:
                            if (baseLine.getBasfi().compareTo(twoWeek.getBasfi()) >= 0) {
                                return true;
                            }
                            break;
                        case ASASConsts.INFLAMMATORYREACT:
                            if (baseLine.getInflammatoryReact().compareTo(twoWeek.getInflammatoryReact()) >= 0) {
                                return true;
                            }
                            break;
                        default:
                            return false;
                    }
                }
            }
        }
        return false;
    }

    public static Boolean calcASASpr(AsCeeDataVO baseLine, AsCeeDataVO twoWeek) {
        setDefaultValue(baseLine, BigDecimal.ZERO);
        setDefaultValue(twoWeek, BigDecimal.ZERO);
        return twoWeek.getPga().compareTo(BigDecimal.valueOf(2)) <= 0
                && twoWeek.getPainScore().compareTo(BigDecimal.valueOf(2)) <= 0
                && twoWeek.getBasfi().compareTo(BigDecimal.valueOf(2)) <= 0
                && twoWeek.getInflammatoryReact().compareTo(BigDecimal.valueOf(2)) <= 0;
    }

    public static Boolean calcASAS56(AsCeeDataVO baseLine, AsCeeDataVO twoWeek) {
        setDefaultValue(baseLine, BigDecimal.ZERO);
        setDefaultValue(twoWeek, BigDecimal.ZERO);

        Map<String, Boolean> improvementDegree = new HashMap<>();
        if (baseLine.getPga().compareTo(twoWeek.getPga()) > 0) {
            BigDecimal value1 = baseLine.getPga().subtract(twoWeek.getPga()).divide(baseLine.getPga(), 2, BigDecimal.ROUND_HALF_UP);
            if (value1.compareTo(BigDecimal.valueOf(0.2)) >= 0) {
                improvementDegree.put(ASASConsts.PGA, true);
            }
        }

        if (baseLine.getPainScore().compareTo(twoWeek.getPainScore()) > 0) {
            BigDecimal value2 = baseLine.getPainScore().subtract(twoWeek.getPainScore()).divide(baseLine.getPainScore(), 2, BigDecimal.ROUND_HALF_UP);
            if (value2.compareTo(BigDecimal.valueOf(0.2)) >= 0) {
                improvementDegree.put(ASASConsts.PAINSCORE, true);
            }
        }

        if (baseLine.getBasfi().compareTo(twoWeek.getBasfi()) > 0) {
            BigDecimal value3 = baseLine.getBasfi().subtract(twoWeek.getBasfi()).divide(baseLine.getBasfi(), 2, BigDecimal.ROUND_HALF_UP);
            if (value3.compareTo(BigDecimal.valueOf(0.2)) >= 0) {
                improvementDegree.put(ASASConsts.BASFI, true);
            }
        }

        if (baseLine.getInflammatoryReact().compareTo(twoWeek.getInflammatoryReact()) > 0) {
            BigDecimal value4 = baseLine.getInflammatoryReact().subtract(twoWeek.getInflammatoryReact()).divide(baseLine.getInflammatoryReact(), 2, BigDecimal.ROUND_HALF_UP);
            if (value4.compareTo(BigDecimal.valueOf(0.2)) >= 0) {
                improvementDegree.put(ASASConsts.INFLAMMATORYREACT, true);
            }
        }

        if (baseLine.getCrp().compareTo(twoWeek.getCrp()) > 0) {
            BigDecimal value5 = baseLine.getCrp().subtract(twoWeek.getCrp()).divide(baseLine.getCrp(), 2, BigDecimal.ROUND_HALF_UP);
            if (value5.compareTo(BigDecimal.valueOf(0.2)) >= 0) {
                improvementDegree.put(ASASConsts.CRP, true);
            }
        }

        if (baseLine.getSpinalMobility().compareTo(twoWeek.getSpinalMobility()) > 0) {
            BigDecimal value6 = baseLine.getSpinalMobility().subtract(twoWeek.getSpinalMobility()).divide(baseLine.getSpinalMobility(), 2, BigDecimal.ROUND_HALF_UP);
            if (value6.compareTo(BigDecimal.valueOf(0.2)) >= 0) {
                improvementDegree.put(ASASConsts.SPINALMOBILITY, true);
            }
        }

        return improvementDegree.size() >= 5;
    }

    public static void setDefaultValue(AsCeeDataVO vo, BigDecimal def){
        if (vo.getPga() == null) {
            vo.setPga(def);
        }
        if (vo.getPainScore() == null){
            vo.setPainScore(def);
        }
        if (vo.getBasfi() == null) {
            vo.setBasfi(def);
        }
        if (vo.getInflammatoryReact() == null) {
            vo.setInflammatoryReact(def);
        }
        if (vo.getCrp()==null) {
            vo.setCrp(def);
        }
        if (vo.getSpinalMobility() == null) {
            vo.setSpinalMobility(def);
        }
    }
}
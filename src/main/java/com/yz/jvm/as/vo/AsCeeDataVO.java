package com.yz.jvm.as.vo;

import java.math.BigDecimal;

/**
 * AS Curative effect evaluation
 */
public class AsCeeDataVO {
    /**
     * 患者总体评估(PGA)
     */
    private BigDecimal pga;

    /**
     * 夜间背痛和整体背痛
     */
    private BigDecimal painScore;

    /**
     * BASFI
     */
    private BigDecimal basfi;

    /**
     * 炎症反应
     */
    private BigDecimal inflammatoryReact;

    /**
     * CRP(mg/L)
     */
    private BigDecimal crp;

    /**
     * 脊柱活动度
     */
    private BigDecimal spinalMobility;


    public BigDecimal getPga() {
        return pga;
    }

    public void setPga(BigDecimal pga) {
        this.pga = pga;
    }

    public BigDecimal getPainScore() {
        return painScore;
    }

    public void setPainScore(BigDecimal painScore) {
        this.painScore = painScore;
    }

    public BigDecimal getBasfi() {
        return basfi;
    }

    public void setBasfi(BigDecimal basfi) {
        this.basfi = basfi;
    }

    public BigDecimal getInflammatoryReact() {
        return inflammatoryReact;
    }

    public void setInflammatoryReact(BigDecimal inflammatoryReact) {
        this.inflammatoryReact = inflammatoryReact;
    }

    public BigDecimal getCrp() {
        return crp;
    }

    public void setCrp(BigDecimal crp) {
        this.crp = crp;
    }

    public BigDecimal getSpinalMobility() {
        return spinalMobility;
    }

    public void setSpinalMobility(BigDecimal spinalMobility) {
        this.spinalMobility = spinalMobility;
    }
}

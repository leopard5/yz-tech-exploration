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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AsCeeDataVO that = (AsCeeDataVO) o;

        if (getBasfi() != null ? !getBasfi().equals(that.getBasfi()) : that.getBasfi() != null) return false;
        if (getInflammatoryReact() != null ? !getInflammatoryReact().equals(that.getInflammatoryReact()) : that.getInflammatoryReact() != null)
            return false;
        if (getCrp() != null ? !getCrp().equals(that.getCrp()) : that.getCrp() != null) return false;
        return getSpinalMobility() != null ? getSpinalMobility().equals(that.getSpinalMobility()) : that.getSpinalMobility() == null;
    }

    @Override
    public int hashCode() {
        int result = getBasfi() != null ? getBasfi().hashCode() : 0;
        result = 31 * result + (getInflammatoryReact() != null ? getInflammatoryReact().hashCode() : 0);
        result = 31 * result + (getCrp() != null ? getCrp().hashCode() : 0);
        result = 31 * result + (getSpinalMobility() != null ? getSpinalMobility().hashCode() : 0);
        return result;
    }
}

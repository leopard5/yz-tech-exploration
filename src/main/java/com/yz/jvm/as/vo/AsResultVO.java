package com.yz.jvm.as.vo;

public class AsResultVO {
    /**
     * 序号
     */
    private Long DataNo;

    /**
     * 实验中心
     */
    private Integer centerNo;

    /**
     * ASAS 20
     */
    private Boolean asas20;

    /**
     * ASAS 40
     */
    private Boolean asas40;

    /**
     * 部分缓解
     */
    private Boolean asasPr;

    /**
     * ASAS 5/6
     */
    private Boolean asas56;


    public Long getDataNo() {
        return DataNo;
    }

    public void setDataNo(Long dataNo) {
        DataNo = dataNo;
    }

    public Integer getCenterNo() {
        return centerNo;
    }

    public void setCenterNo(Integer centerNo) {
        this.centerNo = centerNo;
    }

    public Boolean getAsas20() {
        return asas20;
    }

    public void setAsas20(Boolean asas20) {
        this.asas20 = asas20;
    }

    public Boolean getAsas40() {
        return asas40;
    }

    public void setAsas40(Boolean asas40) {
        this.asas40 = asas40;
    }

    public Boolean getAsasPr() {
        return asasPr;
    }

    public void setAsasPr(Boolean asasPr) {
        this.asasPr = asasPr;
    }

    public Boolean getAsas56() {
        return asas56;
    }

    public void setAsas56(Boolean asas56) {
        this.asas56 = asas56;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AsResultVO that = (AsResultVO) o;

        if (getAsas20() != null ? !getAsas20().equals(that.getAsas20()) : that.getAsas20() != null) return false;
        if (getAsas40() != null ? !getAsas40().equals(that.getAsas40()) : that.getAsas40() != null) return false;
        if (getAsasPr() != null ? !getAsasPr().equals(that.getAsasPr()) : that.getAsasPr() != null) return false;
        return getAsas56() != null ? getAsas56().equals(that.getAsas56()) : that.getAsas56() == null;
    }

    @Override
    public int hashCode() {
        int result = getAsas20() != null ? getAsas20().hashCode() : 0;
        result = 31 * result + (getAsas40() != null ? getAsas40().hashCode() : 0);
        result = 31 * result + (getAsasPr() != null ? getAsasPr().hashCode() : 0);
        result = 31 * result + (getAsas56() != null ? getAsas56().hashCode() : 0);
        return result;
    }
}

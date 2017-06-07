package com.yz.jvm.project.test;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;

public class SkuApplicable implements Serializable {

	private static final long serialVersionUID = 8365399568185066954L;
	private int skuId;
	private int skuStock;
	private BigDecimal promotion;

	public int getSkuId() {
		return skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

	public int getSkuStock() {
		return skuStock;
	}

	public void setSkuStock(int skuStock) {
		this.skuStock = skuStock;
	}

	public BigDecimal getPromotion() {
		return promotion;
	}

	public void setPromotion(BigDecimal promotion) {
		this.promotion = promotion;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

package com.yz.jvm.project.test;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

public class SkuPromotionApplicable implements Serializable {

	private static final long serialVersionUID = 3408539562499912946L;
	private int store;
	private List<SkuApplicable> skuIds;

	public int getStore() {
		return store;
	}

	public void setStore(int store) {
		this.store = store;
	}

	public List<SkuApplicable> getSkuIds() {
		return skuIds;
	}

	public void setSkuIds(List<SkuApplicable> skuIds) {
		this.skuIds = skuIds;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

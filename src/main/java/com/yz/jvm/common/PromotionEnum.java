package com.yz.jvm.common;

/**
 *
 */
public enum PromotionEnum {
	SHOP("storeId"),
	SKUID("skuId"),
	SKUSTOCK("skuStock"),
	PROMOTION("promotion"),
	;
	
	PromotionEnum(String p)
	{
		this.value = p;
	}
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


	
}

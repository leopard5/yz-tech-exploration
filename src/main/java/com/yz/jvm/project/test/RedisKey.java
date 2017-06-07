package com.yz.jvm.project.test;

public class RedisKey {
	public static final String SEPARATOR = ":";
	public static final String PREFIX = "promotion:";
	// 51-56优惠券剩余库存
	public static final String COUPON_STOCK = "promotion:coupon:stock:";
	// 31爆品剩余库存
	public static final String PREFIX_SUBPROMOTION = "promotion:subpromotion:";
	
	public static String getCacheKeyByCouponId(Integer couponId){
		if (couponId == null || couponId.intValue() <= 0) {
			return "";
		}
		StringBuilder sbBuilder = new StringBuilder(50);
		sbBuilder.append(COUPON_STOCK);
		sbBuilder.append(couponId);
		return sbBuilder.toString();
	}
	
	public static String getCacheKeyBySkuId(Integer skuId){
		if (skuId == null || skuId.intValue() <= 0) {
			return "";
		}
		StringBuilder sbBuilder = new StringBuilder(50);
		sbBuilder.append(PREFIX_SUBPROMOTION);
		sbBuilder.append(skuId);
		return sbBuilder.toString();
	}
	
	public static String getCacheKeyByType(PromotionEnum promotion) {
		if (promotion == null) {
			return "";
		}
		StringBuilder sbBuilder = new StringBuilder(50);
		sbBuilder.append(PREFIX_SUBPROMOTION);
		switch (promotion) {
		case SHOP:
			PromotionEnum.SHOP.getValue();
			break;

		default:
			break;
		}
		return "";
	}
}

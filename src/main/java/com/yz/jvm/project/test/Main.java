package com.yz.jvm.project.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.yz.jvm.util.FileUtil;

public class Main {
	public static void main(String[] args) {
		String app = null;
		try {
			app = FileUtil.getResourceContent("/testdata/b.json");
			List<SkuPromotionApplicable> promotionApplicables = JSON.parseArray(app, SkuPromotionApplicable.class);
			for (SkuPromotionApplicable item : promotionApplicables) {
				System.out.println(item.getStore());
				List<SkuApplicable> temps = item.getSkuIds();
				for (SkuApplicable skuApplicable : temps) {
					System.out.println(skuApplicable.getSkuId());
				}
				for (SkuApplicable skuApplicable : temps) {
					System.out.println(skuApplicable.getPromotion());
				}
				for (SkuApplicable skuApplicable : temps) {
					System.out.println(skuApplicable.getSkuStock());
				}
				System.out.println("-------");
			}
			// System.out.println(JSON.toJSONString());
		} catch (Exception e) {
			System.out.println("error");
		}
	}
	
	
	public static void aaaa(){
		String app = "";
		try {
			app = FileUtil.getResourceContent("/testdata/b.json");
			List<SkuPromotionApplicable> promotionApplicables = JSON.parseArray(app, SkuPromotionApplicable.class);
			Set<Integer> shops = new HashSet<Integer>();
			for (SkuPromotionApplicable item : promotionApplicables) {
				shops.add(item.getStore());
			}
			
			List<SkuPromotionApplicable> newSkuApplicables = new ArrayList<SkuPromotionApplicable>(shops.size());
			for (Integer item : shops) {
				SkuPromotionApplicable skuApplicable = new SkuPromotionApplicable();
				skuApplicable.setStore(item);
				skuApplicable.setSkuIds(getSkuApplicables(item.intValue() , promotionApplicables));
				newSkuApplicables.add(skuApplicable);
			}
			System.out.println(JSON.toJSONString(newSkuApplicables));
		} catch (Exception e) {
			System.out.println("error");
		}
	}
	
	
	public static String getRuleValue(String intputData){
		List<SkuPromotionApplicable> promotionApplicables = JSON.parseArray(intputData, SkuPromotionApplicable.class);
		Set<Integer> shops = new HashSet<Integer>();
		for (SkuPromotionApplicable item : promotionApplicables) {
			shops.add(item.getStore());
		}
		
		List<SkuPromotionApplicable> newSkuApplicables = new ArrayList<SkuPromotionApplicable>(shops.size());
		for (Integer item : shops) {
			SkuPromotionApplicable skuApplicable = new SkuPromotionApplicable();
			skuApplicable.setStore(item);
			skuApplicable.setSkuIds(getSkuApplicables(item.intValue() , promotionApplicables));
			newSkuApplicables.add(skuApplicable);
		}
		System.out.println(JSON.toJSONString(newSkuApplicables));
		return JSON.toJSONString(newSkuApplicables);
	}
	
	public static List<SkuApplicable>  getSkuApplicables(int shopId, List<SkuPromotionApplicable> promotionApplicables){
		List<SkuApplicable> SkuApplicables = null;
		for (SkuPromotionApplicable item : promotionApplicables) {
			if (item.getStore() == shopId) {
				if (SkuApplicables == null) {
					SkuApplicables = item.getSkuIds();
				}else {
					SkuApplicables.addAll(item.getSkuIds());
				}
			}
		}
		return SkuApplicables;
	}
}

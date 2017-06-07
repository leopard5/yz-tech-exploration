package com.yz.jvm.designPattern.Mdeiator.complexity.bad;

public class Purchase {
	// 采购IBM型号的电脑
	public void buyIBMcomputer(int number) {
		// 访问库存
		Stock stock = new Stock();
		// 访问销售
		Sale sale = new Sale();
		// 电脑的销售情况
		int saleStatus = sale.getSaleStatus();
		if (saleStatus > 80) { // 销售情况良好
			System.out.println("采购IBM电脑:" + number + "台");
			stock.increase(number);
		} else { // 销售情况不好
			int buyNumber = number / 2; // 折半采购
			System.out.println("采购IBM电脑：" + buyNumber + "台");
		}
	}

	// 不再采购IBM电脑
	public void refuseBuyIBM() {
		System.out.println("不再采购IBM电脑");
	}
}

package com.venus.finance.vo;

import java.util.List;

import com.venus.finance.model.FuturesOrders;
import com.venus.finance.model.FuturesStrategy;

public class FuturesOrdersVO{
	private List<FuturesOrders> ordersList;

	public List<FuturesOrders> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<FuturesOrders> ordersList) {
		this.ordersList = ordersList;
	}

	
}

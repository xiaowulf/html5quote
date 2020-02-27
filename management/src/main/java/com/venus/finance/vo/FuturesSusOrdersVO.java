package com.venus.finance.vo;

import java.util.List;

import com.venus.finance.model.FuturesClose;
import com.venus.finance.model.FuturesOrders;
import com.venus.finance.model.FuturesSusOrders;

public class FuturesSusOrdersVO{
	private List<FuturesSusOrders> susOrdersList;

	public List<FuturesSusOrders> getSusOrdersList() {
		return susOrdersList;
	}

	public void setSusOrdersList(List<FuturesSusOrders> susOrdersList) {
		this.susOrdersList = susOrdersList;
	}

}

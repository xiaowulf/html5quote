package com.venus.finance.vo;

public class FuturesOrderRet {
	private String code;
	private Double volume;
	private String uuid;
	private String order_result;
	private int ref_value;
	private int sessionid;
	private int frontid;
	private Double sxf;
	private Double close_price;
	private Double open_price;
	private String order_type;
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public Double getClose_price() {
		return close_price;
	}

	public void setClose_price(Double close_price) {
		this.close_price = close_price;
	}

	public Double getVolume() {
		return volume;
	}
	public void setVolume(Double volume) {
		this.volume = volume;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getOrder_result() {
		return order_result;
	}
	public void setOrder_result(String order_result) {
		this.order_result = order_result;
	}
	public int getRef_value() {
		return ref_value;
	}
	public void setRef_value(int ref_value) {
		this.ref_value = ref_value;
	}
	public int getSessionid() {
		return sessionid;
	}
	public void setSessionid(int sessionid) {
		this.sessionid = sessionid;
	}
	public int getFrontid() {
		return frontid;
	}
	public void setFrontid(int frontid) {
		this.frontid = frontid;
	}
	public Double getSxf() {
		return sxf;
	}
	public void setSxf(Double sxf) {
		this.sxf = sxf;
	}
	public String getOrder_type() {
		return order_type;
	}
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	public Double getOpen_price() {
		return open_price;
	}

	public void setOpen_price(Double open_price) {
		this.open_price = open_price;
	}
	
	
}

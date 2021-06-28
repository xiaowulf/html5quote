package com.venus.finance.vo;

public class FuturesOrdersDetail{

	private Long id;
	private Long record_date;
	private Double open_price;
	private Double hand;
	private String fund_account;
	private String code;
	private Long strategy_id;
	private String record_time;
	private Double remain_hand;
	private Double remain_profit;
	private Double risk;
	private Long ref_value;
	private Long sessionid;
	private Long frontid;
	private Double ccjsyk;
	private Double sxf;
	private String direction;
	private String strategy_name;
	
	public FuturesOrdersDetail() {
		this.id=0L;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getRemain_profit() {
		return remain_profit;
	}
	public void setRemain_profit(Double remain_profit) {
		this.remain_profit = remain_profit;
	}
	public Long getRecord_date() {
		return record_date;
	}
	public void setRecord_date(Long record_date) {
		this.record_date = record_date;
	}
	public Double getOpen_price() {
		return open_price;
	}
	public void setOpen_price(Double open_price) {
		this.open_price = open_price;
	}
	
	public String getFund_account() {
		return fund_account;
	}
	public void setFund_account(String fund_account) {
		this.fund_account = fund_account;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getStrategy_id() {
		return strategy_id;
	}
	public void setStrategy_id(Long strategy_id) {
		this.strategy_id = strategy_id;
	}
	public Double getRemain_hand() {
		return remain_hand;
	}
	public void setRemain_hand(Double remain_hand) {
		this.remain_hand = remain_hand;
	}
	public Double getRisk() {
		return risk;
	}
	public void setRisk(Double risk) {
		this.risk = risk;
	}
	public Double getHand() {
		return hand;
	}
	public void setHand(Double hand) {
		this.hand = hand;
	}
	
	public Double getCcjsyk() {
		return ccjsyk;
	}
	public void setCcjsyk(Double ccjsyk) {
		this.ccjsyk = ccjsyk;
	}
	public Double getSxf() {
		return sxf;
	}
	public void setSxf(Double sxf) {
		this.sxf = sxf;
	}
	public String getRecord_time() {
		return record_time;
	}
	public void setRecord_time(String record_time) {
		this.record_time = record_time;
	}
	public Long getRef_value() {
		return ref_value;
	}
	public void setRef_value(Long ref_value) {
		this.ref_value = ref_value;
	}
	public Long getSessionid() {
		return sessionid;
	}
	public void setSessionid(Long sessionid) {
		this.sessionid = sessionid;
	}
	public Long getFrontid() {
		return frontid;
	}
	public void setFrontid(Long frontid) {
		this.frontid = frontid;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getStrategy_name() {
		return strategy_name;
	}

	public void setStrategy_name(String strategy_name) {
		this.strategy_name = strategy_name;
	}
	
}

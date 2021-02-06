package com.venus.finance.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "futures_sus_orders", catalog = "xtrader")
public class FuturesSusOrders implements java.io.Serializable{

	private Long id;
	private Long record_date;
	private Double open_price;
	private Double hand;
	private String fund_account;
	private String code;
	private Long strategy_id;
	private String direction;
	private String record_time;
	private Double remain_hand;
	private Double remain_profit;
	private Double risk;
	private Long ref_value;
	private Long sessionid;
	private Long frontid;
	private Double ccjsyk;
	private Double sxf;
	
	
	public FuturesSusOrders() {
		this.id=0L;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "remain_profit")
	public Double getRemain_profit() {
		return remain_profit;
	}
	public void setRemain_profit(Double remain_profit) {
		this.remain_profit = remain_profit;
	}
	@Column(name = "record_date")
	public Long getRecord_date() {
		return record_date;
	}
	public void setRecord_date(Long record_date) {
		this.record_date = record_date;
	}
	@Column(name = "open_price")
	public Double getOpen_price() {
		return open_price;
	}
	public void setOpen_price(Double open_price) {
		this.open_price = open_price;
	}
	
	@Column(name = "fund_account")
	public String getFund_account() {
		return fund_account;
	}
	public void setFund_account(String fund_account) {
		this.fund_account = fund_account;
	}
	@Column(name = "code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Column(name = "strategy_id")
	public Long getStrategy_id() {
		return strategy_id;
	}
	public void setStrategy_id(Long strategy_id) {
		this.strategy_id = strategy_id;
	}
	@Column(name = "remain_hand")
	public Double getRemain_hand() {
		return remain_hand;
	}
	public void setRemain_hand(Double remain_hand) {
		this.remain_hand = remain_hand;
	}
	@Column(name = "risk")
	public Double getRisk() {
		return risk;
	}
	public void setRisk(Double risk) {
		this.risk = risk;
	}
	@Column(name = "hand")
	public Double getHand() {
		return hand;
	}
	public void setHand(Double hand) {
		this.hand = hand;
	}
	@Column(name = "direction")
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	@Column(name = "ccjsyk")
	public Double getCcjsyk() {
		return ccjsyk;
	}
	
	public void setCcjsyk(Double ccjsyk) {
		this.ccjsyk = ccjsyk;
	}
	@Column(name = "sxf")
	public Double getSxf() {
		return sxf;
	}
	public void setSxf(Double sxf) {
		this.sxf = sxf;
	}
	@Column(name = "record_time")
	public String getRecord_time() {
		return record_time;
	}
	public void setRecord_time(String record_time) {
		this.record_time = record_time;
	}
	@Column(name = "ref_value")
	public Long getRef_value() {
		return ref_value;
	}
	public void setRef_value(Long ref_value) {
		this.ref_value = ref_value;
	}
	@Column(name = "sessionid")
	public Long getSessionid() {
		return sessionid;
	}
	public void setSessionid(Long sessionid) {
		this.sessionid = sessionid;
	}
	@Column(name = "frontid")
	public Long getFrontid() {
		return frontid;
	}
	public void setFrontid(Long frontid) {
		this.frontid = frontid;
	}
	
}

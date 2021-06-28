package com.venus.finance.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "futures_close", catalog = "xtrader")
public class FuturesClose implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2386819603865565369L;
	private Long id;
	private String code;
	private Long order_id;
	private Double open_price;
	private Double close_price;
	private Double hand;
	private Long record_date;
	private String record_time;
	private Long strategy_id;
	private Double close_profit;
	private String fund_account;
	private String direction;
	private Double sxf;
	public FuturesClose() {
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
	@Column(name = "order_id")
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	@Column(name = "close_price")
	public Double getClose_price() {
		return close_price;
	}
	public void setClose_price(Double close_price) {
		this.close_price = close_price;
	}
	@Column(name = "close_profit")
	public Double getClose_profit() {
		return close_profit;
	}
	public void setClose_profit(Double close_profit) {
		this.close_profit = close_profit;
	}
	
	@Column(name = "record_date")
	public Long getRecord_date() {
		return record_date;
	}
	public void setRecord_date(Long record_date) {
		this.record_date = record_date;
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
	@Column(name = "open_price")
	public Double getOpen_price() {
		return open_price;
	}
	public void setOpen_price(Double open_price) {
		this.open_price = open_price;
	}
	
}

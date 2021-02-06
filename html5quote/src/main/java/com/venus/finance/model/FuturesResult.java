package com.venus.finance.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "futures_result", catalog = "xtrader")
public class FuturesResult implements java.io.Serializable{
	
	private Long id=0L;
	private Long record_date=0L;
	private Long strategy_id=0L;
	private Double drqy=0.0D;
	private Double srqy=0.0D;
	private Double dwjz=0.0D;
	private Double ljyle=0.0D;
	private Double kyzj=0.0D;
	private Double bzj=0.0D;
	private Double bzjratio=0.0D;
	private Double pcyk=0.0D;
	private Double ccyk=0.0D;
	private Double sxf=0.0D;
	public FuturesResult() {
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
	@Column(name = "record_date")
	public Long getRecord_date() {
		return record_date;
	}
	public void setRecord_date(Long record_date) {
		this.record_date = record_date;
	}
	@Column(name = "strategy_id")
	public Long getStrategy_id() {
		return strategy_id;
	}
	public void setStrategy_id(Long strategy_id) {
		this.strategy_id = strategy_id;
	}
	
	@Column(name = "sxf")
	public Double getSxf() {
		return sxf;
	}
	public void setSxf(Double sxf) {
		this.sxf = sxf;
	}
	@Column(name = "drqy")
	public Double getDrqy() {
		return drqy;
	}
	public void setDrqy(Double drqy) {
		this.drqy = drqy;
	}
	@Column(name = "srqy")
	public Double getSrqy() {
		return srqy;
	}
	public void setSrqy(Double srqy) {
		this.srqy = srqy;
	}
	@Column(name = "dwjz")
	public Double getDwjz() {
		return dwjz;
	}
	public void setDwjz(Double dwjz) {
		this.dwjz = dwjz;
	}
	@Column(name = "ljyle")
	public Double getLjyle() {
		return ljyle;
	}
	public void setLjyle(Double ljyle) {
		this.ljyle = ljyle;
	}
	@Column(name = "kyzj")
	public Double getKyzj() {
		return kyzj;
	}
	public void setKyzj(Double kyzj) {
		this.kyzj = kyzj;
	}
	@Column(name = "bzj")
	public Double getBzj() {
		return bzj;
	}
	public void setBzj(Double bzj) {
		this.bzj = bzj;
	}
	@Column(name = "bzjratio")
	public Double getBzjratio() {
		return bzjratio;
	}
	public void setBzjratio(Double bzjratio) {
		this.bzjratio = bzjratio;
	}
	@Column(name = "pcyk")
	public Double getPcyk() {
		return pcyk;
	}
	public void setPcyk(Double pcyk) {
		this.pcyk = pcyk;
	}
	@Column(name = "ccyk")
	public Double getCcyk() {
		return ccyk;
	}
	public void setCcyk(Double ccyk) {
		this.ccyk = ccyk;
	}
	
}

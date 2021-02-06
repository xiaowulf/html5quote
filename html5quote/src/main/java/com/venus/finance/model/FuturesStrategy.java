package com.venus.finance.model;

// Generated 2014-9-9 14:04:51 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TbAddress generated by hbm2java
 */
@Entity
@Table(name = "futures_strategy", catalog = "xtrader")
public class FuturesStrategy implements java.io.Serializable {

	private Long id;
	private String name;
	private String is_use;
	private Double qcqy;
	private Double drqy;
	private Double srqy;
	private Long initdate;
	private Long record_date;
	private Double kyzj;
	public FuturesStrategy() {
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "is_use")
	public String getIs_use() {
		return is_use;
	}
	public void setIs_use(String is_use) {
		this.is_use = is_use;
	}
	@Column(name = "qcqy")
	public Double getQcqy() {
		return qcqy;
	}
	public void setQcqy(Double qcqy) {
		this.qcqy = qcqy;
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
	@Column(name = "initdate")
	public Long getInitdate() {
		return initdate;
	}
	public void setInitdate(Long initdate) {
		this.initdate = initdate;
	}
	@Column(name = "record_date")
	public Long getRecord_date() {
		return record_date;
	}
	public void setRecord_date(Long record_date) {
		this.record_date = record_date;
	}
	@Column(name = "kyzj")
	public Double getKyzj() {
		return kyzj;
	}
	public void setKyzj(Double kyzj) {
		this.kyzj = kyzj;
	}
}

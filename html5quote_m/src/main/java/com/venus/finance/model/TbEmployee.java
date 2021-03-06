package com.venus.finance.model;

// Generated 2014-8-22 9:25:02 by Hibernate Tools 3.4.0.CR1




import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;

/**
 * TbEmployee generated by hbm2java
 */

@Entity
@Table(name = "tb_employee", catalog = "xedu")
public class TbEmployee implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4644564185899307376L;
	private Long id;
	private String userName;
	private String trueName;
	private String password;
	private Date logintime;
	private String loginip;
	private String mobile;
	private String tel;
	private String address;
	private String sex;
	private String email;
	private int showorder;
	private Long createdate;
	public TbEmployee() {
	}

	public TbEmployee(String userName, String trueName, String password,
			Date logintime, String loginip, String mobile, String tel,
			String address, String sex, String email) {
		this.userName = userName;
		this.trueName = trueName;
		this.password = password;
		this.logintime = logintime;
		this.loginip = loginip;
		this.mobile = mobile;
		this.tel = tel;
		this.address = address;
		this.sex = sex;
		this.email = email;
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

	@Column(name = "username")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "truename")
	public String getTrueName() {
		return this.trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "logintime", length = 19)
	public Date getLogintime() {
		return this.logintime;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}

	@Column(name = "loginip")
	public String getLoginip() {
		return this.loginip;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	@Column(name = "mobile")
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "tel")
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "sex")
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "showorder")
	public int getShoworder() {
		return showorder;
	}

	public void setShoworder(int showorder) {
		this.showorder = showorder;
	}

	public Long getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Long createdate) {
		this.createdate = createdate;
	}
}

package com.venus.finance.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_course_category", catalog = "xedu")
public class TbCourseCategory implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2416641545438055479L;
	private Long id;
	private String coursename;
	private String description;
	private Integer status=0;
	private Long create_date;
	private String coursecode;
	private Long update_date;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "coursename")
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Column(name = "create_date")
	public Long getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Long create_date) {
		this.create_date = create_date;
	}
	@Column(name = "coursecode")
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}
	@Column(name = "update_date")
	public Long getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Long update_date) {
		this.update_date = update_date;
	}
	
}

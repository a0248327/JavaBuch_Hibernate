package com.helloweenvsfei.hibernate.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity													// @Entity表示该类能被Hibernate持久化
@Table(name = "tb_cat")									// 指定该Entity对应的数据库名
public class Cat {
	
	@Id													// 指定该列为主键
	@GeneratedValue(strategy = GenerationType.AUTO)	// 主键类型，auto为自增长类型
	private Integer id;
	
	@Column(name = "name")							// 指定属性对应的数据表的列为name
	private String name;
	
	@Column(name = "description")						// 同上。
	private String description;
	
	@ManyToOne										// 指定实体类之间的关系，本例为多对一关系
	@JoinColumn(name = "mother_id")					// 该属性对应的列
	private Cat mother;
	
	@Temporal(TemporalType.TIMESTAMP)				// 日期类型
	@Column(name = "createDate")
	private Date createDate;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cat getMother() {
		return mother;
	}

	public void setMother(Cat mother) {
		this.mother = mother;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

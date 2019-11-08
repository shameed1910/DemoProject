package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer {
	//Test commit
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(Integer id, String name, String email, String commodity, Integer weight, String weightdesc,
			Integer rupees, long mobile, Date purchase_date) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.commodity = commodity;
		this.weight = weight;
		this.weightdesc = weightdesc;
		this.rupees = rupees;
		this.mobile=mobile;
		this.purchase_date = purchase_date;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String commodity;
	@Column
	private Integer weight;
	@Column
	private String weightdesc;
	@Column
	private Integer rupees;
	@Column
	private long mobile;

	@Column
	private Date purchase_date;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCommodity() {
		return commodity;
	}
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	public String getWeightdesc() {
		return weightdesc;
	}

	public void setWeightdesc(String weightdesc) {
		this.weightdesc = weightdesc;
	}

	public Integer getRupees() {
		return rupees;
	}
	public void setRupees(Integer rupees) {
		this.rupees = rupees;
	}
	public Date getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	
	

}

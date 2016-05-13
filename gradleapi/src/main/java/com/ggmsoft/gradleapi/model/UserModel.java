package com.ggmsoft.gradleapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USER")
public class UserModel {

	/**
	 * Default Construct is Required for Hibernate...
	 */
	public UserModel() {
		
	}

	public UserModel(String id, String name, String addressDefault, String addressDetail) {
		super();
		this.id = id;
		this.name = name;
		this.addressDefault = addressDefault;
		this.addressDetail = addressDetail;
	}

	public UserModel(int seq, String id, String name, String addressDefault, String addressDetail) {
		super();
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.addressDefault = addressDefault;
		this.addressDetail = addressDetail;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq;
	
	private String id;

	private String name;

	@Column(name = "address_default")
	private String addressDefault;
	
	@Column(name = "address_detail")
	private String addressDetail;

	public int getSeq() {
		return seq;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressDefault() {
		return addressDefault;
	}

	public void setAddressDefault(String addressDefault) {
		this.addressDefault = addressDefault;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
}

package com.iparty.services.dao.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vinothkumar P T
 *
 */
@Entity
@Table(name="PARTY_ITEMS")
public class PartyItemsEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7242316641335695601L;
	@Id
	@Column(name="PARTY_ID")
	private Integer partyId;
	@Id	
	@Column(name="USER_ID")
	private Integer userId;
	@Id	
	@Column(name="CATEG_ID")
	private Integer categoryId;
	@Id	
	@Column(name="SUB_CATEG_ONE_VALUE")
	private String subCategoryOneValue;
	@Id	
	@Column(name="SUB_CATEG_TWO_VALUE")
	private String subCategoryTwoValue;
	
	@Column(name="QUANTITY")
	private Integer quantity;

	@Column(name="CREATED_DTTM")
	private Timestamp createdDttm;

	/**
	 * @return the adminId
	 */
	public Integer getPartyId() {
		return partyId;
	}

	/**
	 * @param adminId the adminId to set
	 */
	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the subCategoryOneValue
	 */
	public String getSubCategoryOneValue() {
		return subCategoryOneValue;
	}

	/**
	 * @param subCategoryOneValue the subCategoryOneValue to set
	 */
	public void setSubCategoryOneValue(String subCategoryOneValue) {
		this.subCategoryOneValue = subCategoryOneValue;
	}

	/**
	 * @return the subCategoryTwoValue
	 */
	public String getSubCategoryTwoValue() {
		return subCategoryTwoValue;
	}

	/**
	 * @param subCategoryTwoValue the subCategoryTwoValue to set
	 */
	public void setSubCategoryTwoValue(String subCategoryTwoValue) {
		this.subCategoryTwoValue = subCategoryTwoValue;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the createdDttm
	 */
	public Timestamp getCreatedDttm() {
		return createdDttm;
	}

	/**
	 * @param createdDttm the createdDttm to set
	 */
	public void setCreatedDttm(Timestamp createdDttm) {
		this.createdDttm = createdDttm;
	}

	
}

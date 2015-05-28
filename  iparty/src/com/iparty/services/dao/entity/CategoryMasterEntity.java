package com.iparty.services.dao.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vinothkumar P T
 *
 */
@Entity
@Table(name="CATEGORY_MASTER")
public class CategoryMasterEntity {
	@Id
	@Column(name="ADMIN_ID")
	private Integer adminId;
	
	@Column(name="CATEG_ID")
	private Integer categoryId;
	
	@Column(name="CATEG_NAME")
	private String categoryName;
	
	@Column(name="SUB_CATEG_ONE")
	private String subCategoryOne;
	
	@Column(name="SUB_CATEG_TWO")
	private String subCategoryTwo;
	
	@Column(name="UNIT_ID")
	private Integer unitId;

	/**
	 * @return the adminId
	 */
	public Integer getAdminId() {
		return adminId;
	}

	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
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
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the subCategoryOne
	 */
	public String getSubCategoryOne() {
		return subCategoryOne;
	}

	/**
	 * @param subCategoryOne the subCategoryOne to set
	 */
	public void setSubCategoryOne(String subCategoryOne) {
		this.subCategoryOne = subCategoryOne;
	}

	/**
	 * @return the subCategoryTwo
	 */
	public String getSubCategoryTwo() {
		return subCategoryTwo;
	}

	/**
	 * @param subCategoryTwo the subCategoryTwo to set
	 */
	public void setSubCategoryTwo(String subCategoryTwo) {
		this.subCategoryTwo = subCategoryTwo;
	}

	/**
	 * @return the unitId
	 */
	public Integer getUnitId() {
		return unitId;
	}

	/**
	 * @param unitId the unitId to set
	 */
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	
}

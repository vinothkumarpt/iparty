/**
 * 
 */
package com.iparty.services.dao.entity;

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
@Table(name="PARTY_ADMIN")
public class PartyAdminEntity {
@Id
@Column(name="ADMIN_ID")
private Integer adminId;
@Column(name="ADMIN_NAME")
private String adminName;
@Column(name="ADMIN_PASSWORD")
private String adminPassword;
@Column(name="ADMIN_EMAIL")
private String adminEmail;
@Column(name="CREATE_DTTM")
private Timestamp createDttm;
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
 * @return the adminName
 */
public String getAdminName() {
	return adminName;
}
/**
 * @param adminName the adminName to set
 */
public void setAdminName(String adminName) {
	this.adminName = adminName;
}
/**
 * @return the adminPassword
 */
public String getAdminPassword() {
	return adminPassword;
}
/**
 * @param adminPassword the adminPassword to set
 */
public void setAdminPassword(String adminPassword) {
	this.adminPassword = adminPassword;
}
/**
 * @return the adminEmail
 */
public String getAdminEmail() {
	return adminEmail;
}
/**
 * @param adminEmail the adminEmail to set
 */
public void setAdminEmail(String adminEmail) {
	this.adminEmail = adminEmail;
}
/**
 * @return the createDttm
 */
public Timestamp getCreateDttm() {
	return createDttm;
}
/**
 * @param createDttm the createDttm to set
 */
public void setCreateDttm(Timestamp createDttm) {
	this.createDttm = createDttm;
}
}

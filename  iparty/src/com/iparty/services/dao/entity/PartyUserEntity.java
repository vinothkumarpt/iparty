/**
 * 
 */
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
@Table(name="PARTY_USER")
public class PartyUserEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PARTY_ID")
	private Integer partyId;	
	
	@Id
	@Column(name="ADMIN_ID")
	private Integer adminId;
	
	@Id
	@Column(name="USER_ID")
	private Integer userId;	
	
	@Column(name="ADMIN_FLAG")
	private String adminFlag;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="USER_EMAIL")
	private String userEmail;
	
	@Column(name="USER_STATUS")
	private Integer userStatus;
	
	@Column(name="UPDATE_DTTM")
	private Timestamp updateDttm;

	/**
	 * @return the partyId
	 */
	public Integer getPartyId() {
		return partyId;
	}

	/**
	 * @param partyId the partyId to set
	 */
	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}

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
	 * @return the adminFlag
	 */
	public String getAdminFlag() {
		return adminFlag;
	}

	/**
	 * @param adminFlag the adminFlag to set
	 */
	public void setAdminFlag(String adminFlag) {
		this.adminFlag = adminFlag;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return the userStatus
	 */
	public Integer getUserStatus() {
		return userStatus;
	}

	/**
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	/**
	 * @return the updateDttm
	 */
	public Timestamp getUpdateDttm() {
		return updateDttm;
	}

	/**
	 * @param updateDttm the updateDttm to set
	 */
	public void setUpdateDttm(Timestamp updateDttm) {
		this.updateDttm = updateDttm;
	}
}

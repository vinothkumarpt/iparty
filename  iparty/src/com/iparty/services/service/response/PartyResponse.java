/**
 * 
 */
package com.iparty.services.service.response;

/**
 * @author Vinothkumar P T
 *
 */
public class PartyResponse {
	private Integer adminId;
	private Integer partyId;
	private Integer userCnt;
	private String status;
	private String comments;
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
	 * @return the userCnt
	 */
	public Integer getUserCnt() {
		return userCnt;
	}
	/**
	 * @param userCnt the userCnt to set
	 */
	public void setUserCnt(Integer userCnt) {
		this.userCnt = userCnt;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
}

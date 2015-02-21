/**
 * 
 */
package com.iparty.services.dao;

import com.iparty.services.dao.entity.PartyUserEntity;


/**
 * @author vinothkumar pt
 *
 */
public interface IPartyServiceDAO {
	public Integer fetchAdminIdSequence();
	
	public Integer fetchPartyIdSequence();
	
	public String insertUserDetails(PartyUserEntity partyUserEntity);
}

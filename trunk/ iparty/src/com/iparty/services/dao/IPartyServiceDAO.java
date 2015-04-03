/**
 * 
 */
package com.iparty.services.dao;

import com.iparty.services.dao.entity.PartyAdminEntity;
import com.iparty.services.dao.entity.PartyUserEntity;


/**
 * @author vinothkumar pt
 *
 */
public interface IPartyServiceDAO {
	public Integer fetchAdminIdSequence();
	
	public Integer fetchPartyIdSequence();
	
	public Boolean insertUserDetails(PartyUserEntity partyUserEntity);
	
	public Boolean deleteUnsave(Integer adminId, Integer partyId);
	
	public Boolean insertAdminDetails(PartyAdminEntity partyAdminEntity);
}
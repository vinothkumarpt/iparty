package com.iparty.services.service;

import com.iparty.services.dao.entity.CategoryMasterEntity;
import com.iparty.services.dao.entity.PartyAdminEntity;
import com.iparty.services.dao.entity.PartyUserEntity;
import com.iparty.services.service.response.PartyResponse;

/**
 * @author vinothkumar pt
 *
 */
public interface IPartyService {
	public Integer getNewAdminId();
	
	public Integer getNewPartyId();
	
	public PartyResponse registerPartyUser(PartyUserEntity partyUserEntity[]);
	
	public Boolean trash(Integer adminId, Integer partyId);
	
	public PartyResponse registerAdmin(PartyAdminEntity partyAdminEntity);
	
	public PartyResponse newCategory(CategoryMasterEntity categoryMasterEntity);
}

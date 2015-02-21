package com.iparty.services.service;

import com.iparty.services.dao.entity.PartyUserEntity;

/**
 * @author vinothkumar pt
 *
 */
public interface IPartyService {
	public Integer getNewAdminId();
	
	public Integer getNewPartyId();
	
	public String registerPartyUser(PartyUserEntity partyUserEntity[]);
}

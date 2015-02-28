package com.iparty.services.service;

import com.iparty.services.dao.entity.PartyUserEntity;
import com.iparty.services.service.response.PartyUserResponse;

/**
 * @author vinothkumar pt
 *
 */
public interface IPartyService {
	public Integer getNewAdminId();
	
	public Integer getNewPartyId();
	
	public PartyUserResponse registerPartyUser(PartyUserEntity partyUserEntity[]);
}

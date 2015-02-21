/**
 * 
 */
package com.iparty.services.spring;


import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iparty.services.dao.IPartyServiceDAO;
import com.iparty.services.dao.entity.PartyUserEntity;
import com.iparty.services.service.IPartyService;


/**
 * @author vinothkumar pt
 *
 */
@Component
public class IPartyServiceSpringImpl implements IPartyService {
	
	@Autowired
	IPartyServiceDAO ipartyServiceDAO;
	
	@Override
	public Integer getNewAdminId() {
		// TODO Auto-generated method stub
		return ipartyServiceDAO.fetchAdminIdSequence();
	}

	@Override
	public Integer getNewPartyId() {
		// TODO Auto-generated method stub
		return ipartyServiceDAO.fetchPartyIdSequence();
	}

	@Override
	public String registerPartyUser(PartyUserEntity[] partyUserEntity) {
		if(partyUserEntity != null){
			int userId = 1;
			for(PartyUserEntity partyUser:partyUserEntity){
				
				if(partyUser.getPartyId() == null ||partyUser.getPartyId()==0){
					partyUser.setPartyId(getNewPartyId());
				}
				if(partyUser.getAdminId() == null||partyUser.getAdminId()==0){
					partyUser.setAdminId(getNewAdminId());
				}
				partyUser.setUserId(userId);
				
				if(partyUser.getUserName() == null){
					partyUser.setUserName("USER_"+userId);
				}
				
				Date currentDate = new Date();
				partyUser.setUpdateDttm(new Timestamp(currentDate.getTime()));
				partyUser.setCreateDttm(new Timestamp(currentDate.getTime()));
				//Calling DAO
				ipartyServiceDAO.insertUserDetails(partyUser);
				
				userId++;
			}
		}
		
		return "done";
	}
}

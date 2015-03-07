/**
 * 
 */
package com.iparty.services.spring;


import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iparty.controllers.CommonController;
import com.iparty.services.dao.IPartyServiceDAO;
import com.iparty.services.dao.entity.PartyAdminEntity;
import com.iparty.services.dao.entity.PartyUserEntity;
import com.iparty.services.service.IPartyService;
import com.iparty.services.service.response.PartyUserResponse;
import com.iparty.util.IPartyConstants;
import com.iparty.util.IPartyUtil;


/**
 * @author vinothkumar pt
 *
 */
@Component
public class IPartyServiceSpringImpl implements IPartyService {
	
	private final  String CLASS_NAME = "IPartyServiceSpringImpl";
	private final static Logger logger = Logger.getLogger(CommonController.class);
	
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
	public PartyUserResponse registerPartyUser(PartyUserEntity[] partyUserEntity) {
		
		String methodName="registerPartyUser";
		logger.debug(IPartyUtil.getMethodEnterMessage(CLASS_NAME, methodName)); 
		PartyUserResponse response = new PartyUserResponse();
		
		int userId = 0;
		
		int adminId = 0;
		int partyId = 0;
		
		if(partyUserEntity != null){
			
			for(PartyUserEntity partyUser:partyUserEntity){
				//Setting up Admin ID if it is not sent
				userId++;
				if(partyUser.getAdminId() == null||partyUser.getAdminId()==0){
					if(adminId == 0){
						adminId = getNewAdminId();
						partyUser.setAdminId(adminId);
					}
					else{
						partyUser.setAdminId(adminId);
					}
				}
				else{
					adminId = partyUser.getAdminId();
				}
				
				//Setting up Party ID if it not sent
				if(partyUser.getPartyId() == null || partyUser.getPartyId()==0){
					if(partyId == 0){
						partyId = getNewPartyId();
						partyUser.setPartyId(partyId);
					}
					else{
						partyUser.setPartyId(partyId);
					}
				}
				else{
					partyId = partyUser.getPartyId();
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
			}
		}
		response.setAdminId(adminId);
		response.setPartyId(partyId);
		response.setUserCnt(userId);
		response.setStatus(IPartyConstants.DB_STATE_SAVED);
		
		logger.debug("Admin Id: "+adminId);
		logger.debug("Party Id: "+partyId);
		
		logger.debug(IPartyUtil.getMethodExitMessage(CLASS_NAME, methodName)); 
		return response;
	}

	@Override
	public Boolean trash(Integer adminId, Integer partyId) {
		String methodName="trash";
		logger.debug(IPartyUtil.getMethodEnterMessage(CLASS_NAME, methodName)); 
		return ipartyServiceDAO.deleteUnsave(adminId, partyId);
	}

	@Override
	public PartyUserResponse registerAdmin(PartyAdminEntity partyAdminEntity) {
		
		String methodName="registerAdmin";
		
		logger.debug(IPartyUtil.getMethodEnterMessage(CLASS_NAME, methodName)); 
		PartyUserResponse response = new PartyUserResponse();
		
	
		if(partyAdminEntity != null){
			//Setting up Admin ID if it is not sent
			if(partyAdminEntity.getAdminId() == null||partyAdminEntity.getAdminId()==0){
				partyAdminEntity.setAdminId(getNewAdminId());
			}
			response.setAdminId(partyAdminEntity.getAdminId());
			Date currentDate = new Date();

			partyAdminEntity.setCreateDttm(new Timestamp(currentDate.getTime()));
			//Calling DAO
			
			boolean adminStatus = ipartyServiceDAO.insertAdminDetails(partyAdminEntity);
			
			if(adminStatus){
				response.setStatus(IPartyConstants.DB_STATE_SAVED);
			}
		}
				
		logger.debug("Admin Id: "+response.getAdminId());
		logger.debug("Status:  "+response.getStatus());
		
		logger.debug(IPartyUtil.getMethodExitMessage(CLASS_NAME, methodName)); 
		
		return response;
	}
}

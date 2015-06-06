/**
 * 
 */
package com.iparty.services.spring;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iparty.controllers.CommonController;
import com.iparty.services.dao.IPartyServiceDAO;
import com.iparty.services.dao.entity.CategoryMasterEntity;
import com.iparty.services.dao.entity.PartyAdminEntity;
import com.iparty.services.dao.entity.PartyItemsEntity;
import com.iparty.services.dao.entity.PartyUserEntity;
import com.iparty.services.service.IPartyService;
import com.iparty.services.service.response.PartyResponse;
import com.iparty.util.IPartyConstants;
import com.iparty.util.IPartyException;
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
	public PartyResponse registerPartyUser(PartyUserEntity[] partyUserEntity) {
		
		String methodName="registerPartyUser";
		logger.debug(IPartyUtil.getMethodEnterMessage(CLASS_NAME, methodName)); 
		PartyResponse response = new PartyResponse();
		
		int userId = 0;
		
		int adminId = 0;
		int partyId = 0;
		
		if(IPartyUtil.isNotNull(partyUserEntity)){
			
			for(PartyUserEntity partyUser:partyUserEntity){
				//Setting up Admin ID if it is not sent
				userId++;
				if(IPartyUtil.isNull(partyUser.getAdminId()) || 
						partyUser.getAdminId() == IPartyConstants.INT_ZERO){
					
					if(adminId == IPartyConstants.INT_ZERO){
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
				if(IPartyUtil.isNull(partyUser.getPartyId()) || 
						partyUser.getPartyId() == IPartyConstants.INT_ZERO){
					if(partyId == IPartyConstants.INT_ZERO){
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
				
				if(IPartyUtil.isNull(partyUser.getUserName())){
					partyUser.setUserName("USER_"+userId);
				}
				
				partyUser.setUpdateDttm(IPartyUtil.timeStampNow());
				partyUser.setCreateDttm(IPartyUtil.timeStampNow());
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
	public PartyResponse registerAdmin(PartyAdminEntity partyAdminEntity) {
		
		String methodName="registerAdmin";
		
		logger.debug(IPartyUtil.getMethodEnterMessage(CLASS_NAME, methodName)); 
		PartyResponse response = new PartyResponse();
		
	
		if(IPartyUtil.isNotNull(partyAdminEntity)){
			//Setting up Admin ID if it is not sent
			if(IPartyUtil.isNull(partyAdminEntity.getAdminId()) || 
					partyAdminEntity.getAdminId() == IPartyConstants.INT_ZERO){
				partyAdminEntity.setAdminId(getNewAdminId());
			}
			response.setAdminId(partyAdminEntity.getAdminId());

			partyAdminEntity.setCreateDttm(IPartyUtil.timeStampNow());
			//Calling DAO
			
			boolean adminStatus = false;
			
			try{
				adminStatus = ipartyServiceDAO.insertAdminDetails(partyAdminEntity);
			}
			catch(org.springframework.dao.DataIntegrityViolationException e){
				new IPartyException(IPartyConstants.EXCEP_MESSAGE_DUPLICATE_ADMIN_ID, e).log();
				adminStatus = false;
				response.setComments(IPartyConstants.EXCEP_MESSAGE_DUPLICATE_ADMIN_ID);
			}
			
			if(adminStatus){
				response.setStatus(IPartyConstants.DB_STATE_SAVED);
			}
		}
				
		logger.debug("Admin Id: "+response.getAdminId());
		logger.debug("Status:  "+response.getStatus());
		
		logger.debug(IPartyUtil.getMethodExitMessage(CLASS_NAME, methodName)); 
		
		return response;
	}

	@Override
	public PartyResponse newCategory(CategoryMasterEntity categoryMasterEntity) {
		String methodName="newCategory";
		
		logger.debug(IPartyUtil.getMethodEnterMessage(CLASS_NAME, methodName)); 
		
		PartyResponse response = new PartyResponse();
		boolean categStatus = false;
		try{
			categStatus = ipartyServiceDAO.insertCategory(categoryMasterEntity);
		}
		catch(org.springframework.dao.DataIntegrityViolationException e){
			new IPartyException(IPartyConstants.EXCEP_MESSAGE_DUPLICATE_CATEGORY, e).log();
			categStatus = false;
			response.setComments(IPartyConstants.EXCEP_MESSAGE_DUPLICATE_CATEGORY);
		}
		
		if(categStatus){
			response.setStatus(IPartyConstants.DB_STATE_SAVED);
		}
	
		return response;
	}

	@Override
	public PartyResponse saveItems(PartyItemsEntity[] partyItemsEntity) {
		
		String methodName="saveItems";
		
		logger.debug(IPartyUtil.getMethodEnterMessage(CLASS_NAME, methodName)); 
		PartyResponse response = new PartyResponse();
		
		int partyId = 0;
		String itemSaveStatus = null;
		try{
				for(PartyItemsEntity partyItem:partyItemsEntity){
					if(partyId == 0){
						partyId = partyItem.getPartyId();
					}
					
					if(partyItem.getCreatedDttm() == null){
						partyItem.setCreatedDttm(IPartyUtil.timeStampNow());
					}
					
					//Calling DAO
					ipartyServiceDAO.insertPartyItem(partyItem);
				}
				itemSaveStatus = IPartyConstants.DB_STATE_SAVED;
			}
		catch(org.springframework.dao.DataIntegrityViolationException e){
			new IPartyException(IPartyConstants.EXCEP_MESSAGE_DUPLICATE_CATEGORY, e).log();
			itemSaveStatus = IPartyConstants.DB_STATE_NOT_SAVED;
			response.setComments(IPartyConstants.EXCEP_MESSAGE_DUPLICATE_CATEGORY);
		}
		finally{
			response.setPartyId(partyId);
			response.setStatus(itemSaveStatus);
		}
		
		logger.debug(IPartyUtil.getMethodExitMessage(CLASS_NAME, methodName)); 
		return response;
	}

	@Override
	public PartyResponse deleteItems(PartyItemsEntity[] partyItemsEntity) {
		
		String methodName="deleteItems";
		
		logger.debug(IPartyUtil.getMethodEnterMessage(CLASS_NAME, methodName)); 
		
		PartyResponse response = new PartyResponse();
	
		int itemDeletedCount = IPartyConstants.INT_ZERO;
		
		itemDeletedCount = ipartyServiceDAO.deletePartyItem(partyItemsEntity);
		
		if(itemDeletedCount == IPartyConstants.INT_ZERO){
			response.setStatus(IPartyConstants.DB_STATE_NOT_DELETED);
		}else{
			response.setStatus(IPartyConstants.DB_STATE_DELETED);
		}
		
		response.setRecordCount(itemDeletedCount);

				/*try{
						for(PartyItemsEntity partyItem:partyItemsEntity){
							if(partyId == 0){
								partyId = partyItem.getPartyId();
							}
							
							if(partyItem.getCreatedDttm() == null){
								partyItem.setCreatedDttm(IPartyUtil.timeStampNow());
							}
							
							//Calling DAO
							ipartyServiceDAO.insertPartyItem(partyItem);
						}
						
					}
				catch(org.springframework.dao.DataIntegrityViolationException e){
					new IPartyException(IPartyConstants.EXCEP_MESSAGE_DUPLICATE_CATEGORY, e).log();
					itemSaveStatus = IPartyConstants.DB_STATE_NOT_SAVED;
					response.setComments(IPartyConstants.EXCEP_MESSAGE_DUPLICATE_CATEGORY);
				}
				finally{
					response.setPartyId(partyId);
					response.setStatus(itemSaveStatus);
				}*/
	
		logger.debug(IPartyUtil.getMethodExitMessage(CLASS_NAME, methodName)); 
		return response;
	}
}

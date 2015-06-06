package com.iparty.services.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iparty.controllers.CommonController;
import com.iparty.services.dao.entity.CategoryMasterEntity;
import com.iparty.services.dao.entity.PartyAdminEntity;
import com.iparty.services.dao.entity.PartyItemsEntity;
import com.iparty.services.dao.entity.PartyUserEntity;
import com.iparty.util.IPartyConstants;
import com.iparty.util.IPartyUtil;

/**
 * @author vinothkumar pt
 *
 */
@Repository

public class IPartyServiceDAOImpl implements IPartyServiceDAO{
	private final  String CLASS_NAME = "IPartyServiceDAOImpl";
	private final static Logger logger = Logger.getLogger(CommonController.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Integer fetchAdminIdSequence() {
		// TODO Auto-generated method stub
		List list = sessionFactory
				.getCurrentSession().createSQLQuery("SELECT ADMIN_ID_SEQ.NEXTVAL FROM DUAL").list();

		return ((BigDecimal)list.get(0)).intValue();
	}
	
	@Override
	@Transactional
	public Integer fetchPartyIdSequence() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List list = sessionFactory
				.getCurrentSession().createSQLQuery("SELECT PARTY_ID_SEQ.NEXTVAL FROM DUAL").list();

		return ((BigDecimal)list.get(0)).intValue();
	}
	
	@Override
	@Transactional
	public Boolean insertUserDetails(PartyUserEntity partyUserEntity) {
		String methodName="insertUserDetails";
		logger.debug(IPartyUtil.getMethodEnterMessage(CLASS_NAME, methodName)); 
		boolean saved = false;
		Session session = sessionFactory
		.getCurrentSession();
		
		Serializable obj = session.save(partyUserEntity);
		//session.getTransaction().commit();		
		if(IPartyUtil.isNotNull(obj)){
			saved = true;
		}
		
		logger.debug("Saved: "+saved);
		logger.debug(IPartyUtil.getMethodExitMessage(CLASS_NAME, methodName));  
		
		return saved;
	}
	
	@Override
	@Transactional
	public Boolean deleteUnsave(Integer adminId, Integer partyId) {
		String methodName="deleteUnsave";
		boolean deleted = false;
		logger.debug(IPartyUtil.getMethodEnterMessage(CLASS_NAME, methodName)); 
		
		Session session = sessionFactory
				.getCurrentSession();
		
		//Delete Items
		Query delItemsQuery = session.createQuery("delete PartyItemsEntity where "
				+ "partyId= :PartyId");
		
		delItemsQuery.setInteger("PartyId", partyId);
		
		int updatedCnt = delItemsQuery.executeUpdate();
		logger.debug("No of items deleted "+updatedCnt);
		
		if(updatedCnt > IPartyConstants.INT_ZERO){
			deleted = true;
		}
		
		
		//Delete Category
		Query delCategQuery = session.createQuery("delete CategoryMasterEntity where "
				+ "adminId= :AdminId");
		
		delCategQuery.setInteger("AdminId", adminId);
		
		updatedCnt = delCategQuery.executeUpdate();
		logger.debug("No of categories deleted "+updatedCnt);
		
		if(updatedCnt > IPartyConstants.INT_ZERO){
			deleted = true;
		}
		
		
		//Delete users
		Query delUserQuery = session.createQuery("delete PartyUserEntity where "
				+ "adminId = :AdminId and partyId= :PartyId");
		
		delUserQuery.setInteger("AdminId", adminId);
		delUserQuery.setInteger("PartyId", partyId);
		
		updatedCnt = delUserQuery.executeUpdate();
		logger.debug("No of users deleted "+updatedCnt);
		
		if(updatedCnt > IPartyConstants.INT_ZERO){
			deleted = true;
		}
		
		
		
		
		logger.debug(IPartyUtil.getMethodExitMessage(CLASS_NAME, methodName));  
		return deleted;
	}
	
	@Override
	@Transactional
	public Boolean insertAdminDetails(PartyAdminEntity partyAdminEntity) {
		String methodName="insertAdminDetails";
		
		logger.debug(IPartyUtil.getMethodEnterMessage(CLASS_NAME, methodName)); 
		
		boolean saved = false;
		
		Session session = sessionFactory
		.getCurrentSession();
		
		Serializable obj = session.save(partyAdminEntity);
		
		if(IPartyUtil.isNotNull(obj)){
			saved = true;
		}
		logger.debug("Saved: "+saved);
		logger.debug(IPartyUtil.getMethodExitMessage(CLASS_NAME, methodName));  
		
		return saved;
	}

	@Override
	@Transactional
	public Boolean insertCategory(CategoryMasterEntity categoryMasterEntity) {
		String methodName="insertCategory";
		logger.debug(IPartyUtil.getMethodEnterMessage(CLASS_NAME, methodName)); 

		boolean saved = false;
		
		Session session = sessionFactory.getCurrentSession();
		
		Serializable obj = session.save(categoryMasterEntity);
		
		if(IPartyUtil.isNotNull(obj)){
			saved = true;
		}
		logger.debug("Saved: "+saved);
		logger.debug(IPartyUtil.getMethodExitMessage(CLASS_NAME, methodName)); 
		
		return saved;
	}

	@Override
	@Transactional
	public Boolean insertPartyItem(PartyItemsEntity partyItem) {
		String methodName="insertPartyItem";
		logger.debug(IPartyUtil.getMethodEnterMessage(CLASS_NAME, methodName)); 
		
		boolean saved = false;
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(partyItem);
		
		logger.debug(IPartyUtil.getMethodExitMessage(CLASS_NAME, methodName)); 
		return saved;
	}

	@Override
	@Transactional
	public Integer deletePartyItem(PartyItemsEntity[] partyItems) {
		String methodName="deletePartyItem";
		logger.debug(IPartyUtil.getMethodEnterMessage(CLASS_NAME, methodName)); 
		int deletedRecords = 0;
		
		String hql = "DELETE FROM PartyItemsEntity where partyId = :PARTY_ID and "
				+ "userId =:USER_ID and categoryId in (:CATEG_LIST) and subCategoryOneValue in (:SUB_CA1_LIST1) "
				+ "and subCategoryTwoValue in (:SUB_CA2_LIST2) ";
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		
		//Constructing query parameters Starts
		int partyId = IPartyConstants.INT_ZERO;
		int userId = IPartyConstants.INT_ZERO;
		
		ArrayList<Integer> categIdList = new ArrayList<Integer>();
		ArrayList<String> subCategVal1 = new ArrayList<String>();
		ArrayList<String> subCategVal2 = new ArrayList<String>();
		
		for(PartyItemsEntity itemEntity: partyItems){
			if(partyId == IPartyConstants.INT_ZERO){
				partyId = itemEntity.getPartyId();
			}
			if(userId == IPartyConstants.INT_ZERO){
				userId = itemEntity.getUserId();
			}
			
			categIdList.add(itemEntity.getCategoryId());
			subCategVal1.add(itemEntity.getSubCategoryOneValue());
			subCategVal2.add(itemEntity.getSubCategoryTwoValue());
		}
		//Constructing query parameters Ends
		
		query.setInteger("PARTY_ID", partyId);
		query.setInteger("USER_ID", userId);
		query.setParameterList("CATEG_LIST", categIdList);
		query.setParameterList("SUB_CA1_LIST1", subCategVal1);
		query.setParameterList("SUB_CA2_LIST2", subCategVal2);
		
		deletedRecords = query.executeUpdate();
		
		categIdList.clear();
		subCategVal1.clear();
		subCategVal2.clear();
		
		categIdList = null;
		subCategVal1= null;
		subCategVal2= null;
		
		logger.debug(IPartyUtil.getMethodExitMessage(CLASS_NAME, methodName)); 
		return deletedRecords;
	}

}

package com.iparty.services.dao;

import java.io.Serializable;
import java.math.BigDecimal;
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
		Query query = session.createQuery("delete PartyUserEntity where "
				+ "adminId = :AdminId and partyId= :PartyId");
		
		query.setInteger("AdminId", adminId);
		query.setInteger("PartyId", partyId);
		
		int updatedCnt = query.executeUpdate();
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

}

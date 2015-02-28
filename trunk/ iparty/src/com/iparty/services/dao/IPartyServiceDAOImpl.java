package com.iparty.services.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.iparty.controllers.CommonController;
import com.iparty.services.dao.entity.AdminIDSequenceEntity;
import com.iparty.services.dao.entity.PartyAdminEntity;
import com.iparty.services.dao.entity.PartyUserEntity;
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
		
		Session session = sessionFactory
		.getCurrentSession();
		
		session.save(partyUserEntity);
		//session.getTransaction().commit();		
		
		logger.debug(IPartyUtil.getMethodExitMessage(CLASS_NAME, methodName));  
		
		return true;
	}

}

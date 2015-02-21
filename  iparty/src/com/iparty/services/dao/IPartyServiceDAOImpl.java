package com.iparty.services.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.iparty.services.dao.entity.AdminIDSequenceEntity;
import com.iparty.services.dao.entity.PartyAdminEntity;
import com.iparty.services.dao.entity.PartyUserEntity;

/**
 * @author vinothkumar pt
 *
 */
@Repository

public class IPartyServiceDAOImpl implements IPartyServiceDAO{
	
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
	public String insertUserDetails(PartyUserEntity partyUserEntity) {
		// TODO Auto-generated method stub
		sessionFactory
		.getCurrentSession().save(partyUserEntity);
		return "user details has been inserted";
	}

}

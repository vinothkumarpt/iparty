package com.iparty.services.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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
	public String getPlainTextHelloData() {
		// TODO Auto-generated method stub
		List<PartyAdminEntity> pael = sessionFactory.getCurrentSession().createQuery("from PartyAdminEntity").list();
		String name = "";
		if(pael != null && pael.size()>0){
			PartyAdminEntity pae = pael.get(0);
			name = pae.getAdminName();
		}
		
		return name;
	}

}

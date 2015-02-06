/**
 * 
 */
package com.iparty.services.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iparty.services.dao.IPartyServiceDAO;
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
	public String getNewAdminId() {
		// TODO Auto-generated method stub
		return ipartyServiceDAO.fetchAdminIdSequence();
	}
}
